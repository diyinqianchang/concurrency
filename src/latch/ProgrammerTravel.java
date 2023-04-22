package latch;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/8/13 21:42
 * @Version 1.0
 */
public class ProgrammerTravel extends Thread{

    private final Latch latch;

    private final String programmer;

    private final String transportation;


    public ProgrammerTravel(Latch latch, String programmer, String transportation) {
        this.latch = latch;
        this.programmer = programmer;
        this.transportation = transportation;
    }

    @Override
    public void run() {
        System.out.println(programmer+ " start take the transportation [ "+ transportation + " ]");
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(programmer + " arrived by "+transportation);
        latch.countDown();
    }
}
