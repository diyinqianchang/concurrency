package latch;

/**
 * @Author Administrator
 * @Date 2022/8/13 21:54
 * @Version 1.0
 */
public class WaitTimeoutException extends Exception{

    public WaitTimeoutException(String message) {
        super(message);
    }
}
