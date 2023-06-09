package rw;

/**
 * @Author Administrator
 * @Date 2021/10/30 20:08
 * @Version 1.0
 */
public class ReadWriteLockImpl implements ReadWriteLock {

    private final Object MUTEX = new Object();

    private int writingWriters = 0;

    private int waitingWriters = 0;

    private int readingReaders = 0;

    private boolean preferWriter;

    public ReadWriteLockImpl() {
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }


    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    void incrementWritingWriters(){
        this.writingWriters++;
    }

    void incrementWaitingWriters(){
        this.waitingWriters++;
    }

    void incrementReadingReaders(){
        this.readingReaders++;
    }

    void decrementWritingWriters(){
        this.writingWriters--;
    }

    void decrementWaitingWriters(){
        this.waitingWriters--;
    }

    void decrementReadingReaders(){
        this.readingReaders--;
    }

    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getReadingReaders() {
        return this.readingReaders;
    }

    @Override
    public int getWaitingWriters() {
        return this.waitingWriters;
    }

    public Object getMUTEX() {
        return MUTEX;
    }

    public boolean getPreferWriter() {
        return preferWriter;
    }

    void changePrefer(boolean preferWriter){
        this.preferWriter = preferWriter;
    }
}















