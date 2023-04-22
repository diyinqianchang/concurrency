package eventbus;

import java.lang.reflect.Method;

/**
 * @Author Administrator
 * @Date 2022/8/14 17:32
 * @Version 1.0
 */
public interface EventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();

}
