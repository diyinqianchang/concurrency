package pool;

public class ThreadTask {

    public Thread thread;

    public InternalTask internalTask;

    public ThreadTask(Thread thread, InternalTask internalTask) {
        this.thread = thread;
        this.internalTask = internalTask;
    }
}
