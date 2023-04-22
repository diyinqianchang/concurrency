package latch;

import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/8/13 21:45
 * @Version 1.0
 */
public class ProgrammerTest {

    public static void main(String[] args) throws InterruptedException {

        Latch latch = new CountDownLatch(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("finish");
            }
        });
        new ProgrammerTravel(latch,"Alex","Bus").start();
        new ProgrammerTravel(latch,"Gavin","Walking").start();
        new ProgrammerTravel(latch,"Jack","Subway").start();
        new ProgrammerTravel(latch,"Dillon","Bicycle").start();
        latch.await();
//        try {
//            latch.await(TimeUnit.SECONDS,5);
//        } catch (WaitTimeoutException e) {
//            e.printStackTrace();
//        }
        System.out.println("====all of programmer arrived");
    }

}
