package active;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:12
 * @Version 1.0
 */
public class ActiveDaemonThread extends Thread{

    private final ActiveMessageQueue queue;

    public ActiveDaemonThread(ActiveMessageQueue queue) {
        super("ActiveDaemonThread");
        this.queue = queue;
        setDaemon(true);
    }

    @Override
    public void run() {
       for (;;){
           MethodMessage message = this.queue.take();
           message.execute();
       }
    }
}
