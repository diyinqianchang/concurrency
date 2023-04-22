package eventbus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Administrator
 * @Date 2023/4/22 17:23
 * @Version 1.0
 */
public class AsyncEventBusTest {

    public static void main(String[] args) {

        AsyncEventBus bus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleSubscriber1());
        bus.post("Hello");
        System.out.println("----------------");
        bus.post("Hello","test");

    }

}
