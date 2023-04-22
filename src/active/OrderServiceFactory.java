package active;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:40
 * @Version 1.0
 */
public final class OrderServiceFactory {

    private final static ActiveMessageQueue activeMessageQueue = new ActiveMessageQueue();
    private OrderServiceFactory()
    {}

    public static OrderService toActiveObject(OrderService orderService){
        return new OrderServiceProxy(orderService,activeMessageQueue);
    }



}
