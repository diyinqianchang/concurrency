package eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @Author Administrator
 * @Date 2022/8/14 17:09
 * @Version 1.0
 */
public class Dispatcher {

    private final Executor executorService;

    private final EventExceptionHandler eventExceptionHandler;

    public static final Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.INSTANCE;

    public static final Executor PRE_THREAD_EXECUTOR_SERVICE = PreThreadExecutorService.INSTANCE;

    public Dispatcher(Executor executorService, EventExceptionHandler eventExceptionHandler) {
        this.executorService = executorService;
        this.eventExceptionHandler = eventExceptionHandler;
    }


    public void dispatch(Bus bus,Registry registry,Object event,String topic){

        ConcurrentLinkedQueue<Subscriber> subscribers = registry.scanSubscriber(topic);
        if (null == subscribers){
            if (eventExceptionHandler !=null){
                eventExceptionHandler.handle(new IllegalArgumentException("The topic "+ topic + "not bind yet"),
                        new BaseEventContext(bus.getBusName(), null,event));
            }
            return;
        }
        subscribers.stream()
                .filter(subscriber -> !subscriber.isDisable())
                .filter(subscriber -> {
                    Method subscribeMethod = subscriber.getSubscribeMethod();
                    Class<?> aClass = subscribeMethod.getParameterTypes()[0];
                    return (aClass.isAssignableFrom(event.getClass()));
                }).forEach(subscriber -> realInvokeSubscribe(subscriber,event,bus));
    }

    private void realInvokeSubscribe(Subscriber subscriber,Object event,Bus bus){

        Method subscribeMethod = subscriber.getSubscribeMethod();
        Object subscribeObject = subscriber.getSubscribeObject();
        executorService.execute(()->{
            try {
                subscribeMethod.invoke(subscribeObject,event);
            } catch (Exception e) {
                e.printStackTrace();
                if (null != eventExceptionHandler){
                    eventExceptionHandler.handle(e,new BaseEventContext(bus.getBusName(), subscriber,event));
                }
            }
        });

    }

    public void close(){
        if (executorService instanceof ExecutorService){
            ((ExecutorService) executorService).shutdown();
        }
    }

    static Dispatcher newDispatcher(EventExceptionHandler eventExceptionHandler,Executor executor){
        return new Dispatcher(executor,eventExceptionHandler);
    }

    static Dispatcher seqDispatcher(EventExceptionHandler eventExceptionHandler){
        return new Dispatcher(SEQ_EXECUTOR_SERVICE,eventExceptionHandler);
    }

    static Dispatcher preThreadDispatcher(EventExceptionHandler eventExceptionHandler){
        return new Dispatcher(PRE_THREAD_EXECUTOR_SERVICE,eventExceptionHandler);
    }






    private static class SeqExecutorService implements Executor{

        private final static SeqExecutorService INSTANCE = new SeqExecutorService();

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }


    private static class PreThreadExecutorService implements Executor{

        private final static PreThreadExecutorService INSTANCE = new PreThreadExecutorService();

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    private static class BaseEventContext implements EventContext{

        private final String eventBusName;

        private final Subscriber subscriber;

        private final Object event;

        public BaseEventContext(String eventBusName, Subscriber subscriber, Object event) {
            this.eventBusName = eventBusName;
            this.subscriber = subscriber;
            this.event = event;
        }

        @Override
        public String getSource() {
            return this.eventBusName;
        }

        @Override
        public Object getSubscriber() {
            return subscriber !=null ? subscriber.getSubscribeObject():null;
        }

        @Override
        public Method getSubscribe() {
            return subscriber !=null ? subscriber.getSubscribeMethod():null;
        }

        @Override
        public Object getEvent() {
            return this.event;
        }
    }

}












