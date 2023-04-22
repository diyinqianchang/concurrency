package context;

/**
 * @Author Administrator
 * @Date 2023/4/22 18:33
 * @Version 1.0
 */
public class ActionContext {

    private static final ThreadLocal<Context> context = ThreadLocal.withInitial(Context::new);

    public static Context get(){
        return context.get();
    }


    static class Context{

        //TODO 其他成员变量

    }

}
