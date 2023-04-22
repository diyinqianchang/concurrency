package notice;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface MyLock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();

}
