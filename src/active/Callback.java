package active;

/**
 * @Author Administrator
 * @Date 2022/8/14 14:59
 * @Version 1.0
 */

@FunctionalInterface
public interface Callback<OUT>{

    public void call(OUT out);
}
