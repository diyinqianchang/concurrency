package active;

/**
 * @Author Administrator
 * @Date 2022/8/14 14:34
 * @Version 1.0
 */
public interface Future<T> {

    T get() throws InterruptedException;

    boolean done();

}
