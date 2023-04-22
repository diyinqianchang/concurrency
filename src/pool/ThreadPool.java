package pool;

public interface ThreadPool {

    void execute(Runnable runnable);

    void shoutDown();

    int getInitSize();

    int getMaxSize();

    int getCoreSize();

    int getQueueSize();

    int getActiveCount();

    boolean isShutDown();

}
