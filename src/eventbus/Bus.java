package eventbus;

/**
 * @Author Administrator
 * @Date 2022/8/14 17:04
 * @Version 1.0
 */
public interface Bus {

    void register(Object subscriber);

    void unregister(Object subscriber);

    void post(Object event);

    void post(Object event,String topic);

    void close();

    String getBusName();


}
