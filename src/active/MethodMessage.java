package active;

import java.util.Map;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:05
 * @Version 1.0
 */
public abstract class MethodMessage {

    protected final Map<String,Object> params;

    protected final OrderService orderService;

    public MethodMessage(Map<String, Object> params, OrderService orderService) {
        this.params = params;
        this.orderService = orderService;
    }

    public abstract void execute();
}
