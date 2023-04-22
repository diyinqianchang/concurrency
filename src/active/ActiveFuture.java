package active;

/**
 * @Author Administrator
 * @Date 2022/8/14 15:15
 * @Version 1.0
 */
public class ActiveFuture<T> extends FutureTask<T>{

    @Override
    public void finish(T result) {
        super.finish(result);
    }
}
