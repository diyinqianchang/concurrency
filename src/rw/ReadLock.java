package rw;

/**
 * @Author Administrator
 * @Date 2021/10/30 20:13
 * @Version 1.0
 */
public class ReadLock implements Lock{

    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {

        synchronized (readWriteLock.getMUTEX()){
            while (readWriteLock.getWritingWriters() > 0
            || (readWriteLock.getPreferWriter()) && readWriteLock.getWaitingWriters() > 0)
            {
                readWriteLock.getMUTEX().wait();
            }
            readWriteLock.incrementReadingReaders();
        }

    }

    @Override
    public void unlock() {

        synchronized (readWriteLock.getMUTEX()){
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMUTEX().notifyAll();
        }

    }
}
