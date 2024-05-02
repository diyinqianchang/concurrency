package pool;

import java.util.concurrent.*;

/**
 * @Author Administrator
 * @Date 2024/2/24 11:36
 * @Version 1.0
 */
public class ThreadPoolExample {

    private static final ExecutorService executor = new ThreadPoolExecutor(4,
            4,
            60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(30));

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            Runnable task = ()->{
                System.out.println("Task "+taskId+" started by thread: "+Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task "+taskId+" finished.");
            };
            executor.execute(task);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30,TimeUnit.SECONDS)){
                System.err.println("pool did not terminate");
            }
        }catch (Exception e){
            executor.shutdown();
            Thread.currentThread().interrupt();
        }
    }

}
