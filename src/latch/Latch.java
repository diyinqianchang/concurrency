package latch;

import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/8/13 21:36
 * @Version 1.0
 */
public abstract class Latch {

    protected int limit;

    public Latch(int limit) {
        this.limit = limit;
    }

    public abstract void await() throws InterruptedException;

    public abstract void await(TimeUnit unit,long time) throws InterruptedException,WaitTimeoutException;

    public abstract void countDown();

    public abstract int getUnarrived();
}
