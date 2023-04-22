package permess;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/8/14 11:02
 * @Version 1.0
 */
public class TaskHandler implements Runnable {

    private final Request request;

    public TaskHandler(Request request) {
        this.request = request;
    }

    @Override
    public void run() {
        System.out.println("Begin handle "+request);
        slowly();
        System.out.println("End handle "+request);
    }

    private void slowly(){
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
