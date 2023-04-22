package active;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:42
 * @Version 1.0
 */
public class ActiveTest {

    public static void main(String[] args) throws InterruptedException {

        OrderService orderService = OrderServiceFactory.toActiveObject(new OrderServiceImpl());
        orderService.order("hello",453453);
        Future<String> orderDetails = orderService.findOrderDetails(453453);
        System.out.println("return immediately");
        System.out.println(orderDetails.get());
        Thread.currentThread().join();

    }
}
