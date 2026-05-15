package com.abc.latch;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author Administrator
 * @Date 2025/9/28 21:21
 * @Version 1.0
 */
public class CyclicBarrierTest {

    private static final int WORKER_COUNT = 4;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(WORKER_COUNT,
                () -> System.out.println("--- 阶段完成，准备下一阶段 ---"));

        for (int i = 0; i < WORKER_COUNT; i++) {
            new Thread(new Worker(barrier, "Worker-" + i)).start();
        }
    }

    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final String name;

        public Worker(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                // 第一阶段
                System.out.println(name + " 执行第一阶段");
                Thread.sleep((long) (Math.random() * 2000));
                barrier.await();

                // 第二阶段
                System.out.println(name + " 执行第二阶段");
                Thread.sleep((long) (Math.random() * 2000));
                barrier.await();

                // 第三阶段
                System.out.println(name + " 执行第三阶段");
                Thread.sleep((long) (Math.random() * 2000));
                barrier.await();

                System.out.println(name + " 所有阶段完成！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
