package com.abc.latch;

/**
 * @Author Administrator
 * @Date 2026/5/13 17:07
 * @Version 1.0
 */
public class ThreadLocalExample {

    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {

        try {
            Runnable task = () -> {
                int value = threadLocal.get();
                threadLocal.set(value + 1);
                System.out.println("Thread: " + Thread.currentThread().getName() + ", Value: " + threadLocal.get());
            };
            for (int i = 0; i < 5; i++) {
                new Thread(task).start();
            }
            Thread.sleep(3000);
        }catch (Exception e){

        }finally {
            System.out.println("ThreadLocal removed");
            threadLocal.remove();
        }


    }

}
