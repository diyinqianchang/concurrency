package eventbus;

/**
 * @Author Administrator
 * @Date 2022/8/14 17:12
 * @Version 1.0
 */


public interface EventExceptionHandler {


    void handle(Throwable cause,EventContext context);
}
