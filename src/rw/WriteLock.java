package rw;

/**
 * @Author Administrator
 * @Date 2021/10/30 20:15
 * @Version 1.0
 */
public class WriteLock implements Lock{

    private final ReadWriteLockImpl readWriteLock;

    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {

        synchronized (readWriteLock.getMUTEX()){
            try {
                readWriteLock.incrementWaitingWriters();
                while (readWriteLock.getReadingReaders() > 0
                || readWriteLock.getWritingWriters() > 0){
                    readWriteLock.getMUTEX().wait();
                }
            }finally {
                this.readWriteLock.decrementWaitingWriters();
            }
            readWriteLock.incrementWritingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()){
            readWriteLock.decrementWritingWriters();
            readWriteLock.changePrefer(false);
            readWriteLock.getMUTEX().notifyAll();
        }
    }
}
