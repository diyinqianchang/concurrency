package work;

/**
 * @Author Administrator
 * @Date 2022/8/14 11:45
 * @Version 1.0
 */
public class ProdcutionChannel {

    private final static int MAX_PROD = 100;

    private final Production[]  productionQueue;

    private int tail;

    private int head;

    private int total;

    private final Worker[]  workers;

    public ProdcutionChannel(int workerSize) {
        this.workers = new Worker[workerSize];
        this.productionQueue = new Production[MAX_PROD];
        for (int i = 0; i < workerSize; i++) {
            workers[i] = new Worker("Worker-"+i,this);
            workers[i].start();
        }
    }

    public void offerProduction(Production production){

        synchronized (this){
            while (total >= productionQueue.length){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            productionQueue[tail] = production;
            tail = (tail+1)%productionQueue.length;
            total++;
            this.notifyAll();
        }
    }

    public Production takeProduction(){
        synchronized (this){
            while (total <=0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Production prod = productionQueue[head];
            head = (head+1) % productionQueue.length;
            total--;
            this.notifyAll();
            return prod;
        }
    }
}



































