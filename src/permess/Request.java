package permess;

/**
 * @Author Administrator
 * @Date 2022/8/14 11:01
 * @Version 1.0
 */
public class Request {

    private final String busiess;

    public Request(String busiess) {
        this.busiess = busiess;
    }

    @Override
    public String toString() {
        return "Request{" +
                "busiess='" + busiess + '\'' +
                '}';
    }
}
