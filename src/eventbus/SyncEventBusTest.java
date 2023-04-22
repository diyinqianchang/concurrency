package eventbus;

/**
 * @Author Administrator
 * @Date 2023/4/22 17:01
 * @Version 1.0
 */
public class SyncEventBusTest {

    public static void main(String[] args) {

        EventBus testBus = new EventBus("TestBus");
        testBus.register(new SimpleSubscriber1());
        testBus.post("Hello");
        System.out.println("---------------");
        testBus.post("Hello","test");


    }

}
