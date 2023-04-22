package permess;

import pool.BasicThreadPool;
import pool.ThreadPool;

/**
 * @Author Administrator
 * @Date 2022/8/14 11:04
 * @Version 1.0
 */
public class Operator {

    private final ThreadPool threadPool = new BasicThreadPool(2,6,4,1000);

    public void call(String business){
        TaskHandler taskHandler = new TaskHandler(new Request(business));
        threadPool.execute(taskHandler);
//        new Thread(taskHandler).start();
    }

}
