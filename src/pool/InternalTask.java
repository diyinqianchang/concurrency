package pool;

public class InternalTask implements Runnable{

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()){
            System.out.println("InternalTask running");
            try {
                Runnable take = runnableQueue.take();
                take.run();
            }catch (InterruptedException e){
                running = false;
                break;
            }

        }
    }

    public void stop(){
        this.running = false;
    }

}
