package singleton;

public final class Singleton3 {

    private byte[] data = new byte[1024];

    private volatile static Singleton3 instance = null;

    private Singleton3() {
    }

    public static  Singleton3 getInstance() {
        if (null == instance){
            synchronized (Singleton3.class){
                if (null == instance){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
