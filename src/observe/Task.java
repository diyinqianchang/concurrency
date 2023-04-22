package observe;


@FunctionalInterface
public interface Task <T>{

    T call();
}
