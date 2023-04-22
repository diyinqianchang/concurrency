package suspension;

import java.util.LinkedList;

/**
 * @Author Administrator
 * @Date 2023/4/22 17:42
 * @Version 1.0
 */
public class GuardedSuspensionQueue {


    private final LinkedList<Integer> queue = new LinkedList<>();

    private final int LIMIT = 100;

    public void offer(Integer data) throws InterruptedException{
        synchronized (this){
            while (queue.size() >= LIMIT){
                this.wait();
            }
            queue.addLast(data);
            this.notifyAll();
        }
    }

    public Integer take() throws InterruptedException{
        synchronized (this){
            while (queue.isEmpty()){
                this.wait();
            }
            this.notifyAll();
            return queue.removeFirst();
        }
    }

}
