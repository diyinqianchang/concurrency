package notice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.currentThread;

public class BooleanLock implements MyLock{


    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this){
            while (locked){
                final Thread tempThread = currentThread();
                try {
                    if (!blockedList.contains(tempThread)){
                        blockedList.add(tempThread);
                    }
                    this.wait();
                }catch (InterruptedException exception){
                    blockedList.remove(tempThread);
                    throw exception;
                }
            }
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {

        synchronized (this){
            if (mills <= 0){
                this.lock();
            }else {
                long remainingMills = mills;
                long endMills = System.currentTimeMillis()+remainingMills;
                while (locked){
                    final Thread tempThread = currentThread();
                    try {
                        if (remainingMills <= 0){
                            throw new TimeoutException("can not get the lock during "+mills);
                        }
                        if (!blockedList.contains(tempThread)){
                            blockedList.add(tempThread);
                        }
                        this.wait(remainingMills);
                    }catch (InterruptedException | TimeoutException e){
                        blockedList.remove(tempThread);
                        throw e;
                    }
                    remainingMills = endMills - System.currentTimeMillis();
                }
                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }

    }

    @Override
    public void unlock() {
        synchronized (this){
            if (currentThread == currentThread()){
                this.locked = false;
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
