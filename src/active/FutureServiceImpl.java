package active;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Administrator
 * @Date 2022/8/14 14:38
 * @Version 1.0
 */
public class FutureServiceImpl<IN,OUT> implements FutureService<IN,OUT> {

    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";

    private final AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName(){
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {

        final FutureTask<Void> future = new FutureTask<>();
        new Thread(()->{
            runnable.run();
            future.finish(null);
        }).start();
        return future;
    }

    @Override
    public Future submit(Task<IN,OUT> task, IN input,Callback<OUT> callback) {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(()->{
            OUT result = task.get(input);
            future.finish(result);
            if (null!=callback){
                callback.call(result);
            }
        },getNextName()).start();
        return future;
    }
}
