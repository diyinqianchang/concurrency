package singleton;

public final class Singleton2 {

    private byte[] data = new byte[1024];

    private static Singleton2 instance = null;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (null == instance){
            instance = new Singleton2();
        }
        return instance;
    }
}
