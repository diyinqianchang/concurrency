package eventbus;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Administrator
 * @Date 2023/4/22 16:46
 * @Version 1.0
 */
public class AsyncEventBus extends EventBus{

    AsyncEventBus(String busName, EventExceptionHandler eventExceptionHandler, ThreadPoolExecutor executor){
        super(busName,eventExceptionHandler,executor);
    }

    public AsyncEventBus(String busName, ThreadPoolExecutor executor) {
        this(busName,null,executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor){
        this("default-async",null,executor);
    }
}
