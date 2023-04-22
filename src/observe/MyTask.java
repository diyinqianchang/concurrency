package observe;

import java.util.concurrent.TimeUnit;

public class MyTask implements Task{

    @Override
    public String call() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "MyTask";
    }
}
