package active;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:02
 * @Version 1.0
 */
public class OrderServiceProxy implements OrderService{

    private final OrderService orderService;

    private final ActiveMessageQueue activeMessageQueue;

    public OrderServiceProxy(OrderService orderService, ActiveMessageQueue activeMessageQueue) {
        this.orderService = orderService;
        this.activeMessageQueue = activeMessageQueue;
    }

    @Override
    public Future<String> findOrderDetails(long orderId) {
        final ActiveFuture<String> activeFuture = new ActiveFuture<>();
        Map<String,Object> params = new HashMap<>();
        params.put("orderId",orderId);
        params.put("activeFuture",activeFuture);
        MethodMessage message = new FindOrderDetailsMessage(params,orderService);
        activeMessageQueue.offer(message);
        return activeFuture;
    }

    @Override
    public void order(String account, long orderId) {

        Map<String,Object> params = new HashMap<>();
        params.put("account",account);
        params.put("orderId",orderId);
        MethodMessage message = new OrderMessage(params,orderService);
        activeMessageQueue.offer(message);


    }
}
