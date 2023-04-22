package active;

import java.util.Map;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:18
 * @Version 1.0
 */
public class FindOrderDetailsMessage extends MethodMessage{

    public FindOrderDetailsMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {
        Future<String> realFuture = orderService.findOrderDetails((long) params.get("orderId"));
        ActiveFuture<String> activeFuture = (ActiveFuture<String>) params.get("activeFuture");
        try {
            String result = realFuture.get();
            activeFuture.finish(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
