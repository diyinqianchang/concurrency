package active;



/**
 * @Author Administrator
 * @Date 2022/8/14 14:35
 * @Version 1.0
 */
public interface FutureService<IN,OUT> {

    Future<?> submit(Runnable runnable);

    Future<OUT> submit(Task<IN,OUT> task, IN input,Callback<OUT> callback);

    static <T,R> FutureService<T,R> newService(){
        return new FutureServiceImpl<>();
    }

}
