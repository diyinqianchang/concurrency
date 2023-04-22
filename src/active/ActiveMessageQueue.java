package active;

import java.util.LinkedList;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:03
 * @Version 1.0
 */
public class ActiveMessageQueue {

    private final LinkedList<MethodMessage> messages = new LinkedList<>();

    public ActiveMessageQueue() {
        new ActiveDaemonThread(this).start();
    }

    public void offer(MethodMessage methodMessage){
        synchronized (this){
            messages.addLast(methodMessage);
            this.notify();
        }
    }

    protected MethodMessage take(){
        synchronized (this){
            while (messages.isEmpty()){
                try {
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return messages.removeFirst();
        }
    }
}
