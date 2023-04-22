package eventbus;

/**
 * @Author Administrator
 * @Date 2023/4/22 16:59
 * @Version 1.0
 */
public class SimpleSubscriber1 {

    @Subscribe
    public void method1(String message){
        System.out.println("====SimpleSubscriber1==method1=="+message);
    }

    @Subscribe(topic = "test")
    public void method2(String message){
        System.out.println("====SimpleSubscriber1==method2=="+message);
    }

}
