package eventbus;

/**
 * @Author Administrator
 * @Date 2022/8/14 17:13
 * @Version 1.0
 */
public interface Executor {

    void execute(Runnable command);

}
