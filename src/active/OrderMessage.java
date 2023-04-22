package active;

import java.util.Map;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:08
 * @Version 1.0
 */
public class OrderMessage extends MethodMessage{


    public OrderMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {
        String account = (String) params.get("account");
        long orderId = (long) params.get("orderId");
        orderService.order(account,orderId);
    }
}
