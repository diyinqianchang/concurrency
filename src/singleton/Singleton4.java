package singleton;

public final class Singleton4 {

    private byte[] data = new byte[1024];


    private Singleton4() {
    }

    private static class Holder{
        private static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Holder.instance;
    }
}
