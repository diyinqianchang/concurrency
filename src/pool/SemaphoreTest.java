package pool;

import java.util.concurrent.Semaphore;

/**
 * @Author Administrator
 * @Date 2024/2/24 11:53
 * @Version 1.0
 */
public class SemaphoreTest {

    public static void main(String[] args) {
//
//
//        try {
//            Thread.sleep(100000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }  Sema sema =
//        new Sema();
////        sema.run();
        String s = new StringBuilder("go").append("od").toString();
        System.out.println(s.intern() == s);

    }

}

class Sema{
    private Semaphore semaphore = new Semaphore(5);

    public void run(){
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            }).start();
        }
    }

    private void test(){
        System.out.println("dede");
        try {
            semaphore.acquire();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        semaphore.release();
    }
}
