package active;



/**
 * @Author Administrator
 * @Date 2022/8/14 14:29
 * @Version 1.0
 */
public interface OrderService {

    Future<String> findOrderDetails(long orderId);

    void order(String account,long orderId);

}
