package work;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author Administrator
 * @Date 2022/8/14 11:47
 * @Version 1.0
 */
public class Worker extends Thread{

    private final ProdcutionChannel channel;

    private final static Random random = new Random(System.currentTimeMillis());

    public Worker(String workerName,ProdcutionChannel channel) {
        super(workerName);
        this.channel = channel;
    }

    @Override
    public void run() {
       while (true){
           try {
               Production production = channel.takeProduction();
               System.out.println(getName() + " process the " + production);
               production.create();
               TimeUnit.SECONDS.sleep(random.nextInt(10));
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }
    }
}
