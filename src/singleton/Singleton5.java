package singleton;

public enum Singleton5 {

    INSTANCE;

    Singleton5(){
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method(){

    }

    public static Singleton5 getInstance(){
        return INSTANCE;
    }

}
