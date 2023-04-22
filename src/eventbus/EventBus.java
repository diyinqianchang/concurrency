package eventbus;

/**
 * @Author Administrator
 * @Date 2022/8/14 17:07
 * @Version 1.0
 */
public class EventBus implements Bus{

    private final Registry registry = new Registry();

    private String busName;

    private final static String DEFAULT_BUS_NAME = "default";

    private final static String DEFAULT_TOPIC = "default-topic";


    public EventBus() {
        this(DEFAULT_BUS_NAME,null,null);
    }

    public EventBus(String busName) {
        this(busName,null,null);
    }

    public EventBus(String busName,EventExceptionHandler eventExceptionHandler,Executor executor) {
        this.busName = busName;
    }



    @Override
    public void register(Object subscriber) {

    }

    @Override
    public void unregister(Object subscriber) {

    }

    @Override
    public void post(Object event) {

    }

    @Override
    public void post(Object event, String topic) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getBusName() {
        return null;
    }
}
