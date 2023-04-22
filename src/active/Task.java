package active;

/**
 * @Author Administrator
 * @Date 2022/8/14 14:36
 * @Version 1.0
 */
@FunctionalInterface
public interface Task<IN,OUT> {

    OUT get(IN input);
}
