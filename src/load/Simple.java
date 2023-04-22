package load;

public class Simple {
    static {
        System.out.println("I will be initialized");
    }

    public static int x = 10;

    public static final int MAX = 100;

    public static void test(){

    }

    public static void main(String[] args) {
//        Simple.test();
//        try {
////            Class.forName("load.Simple");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        Simple[] simples = new Simple[10];
        System.out.println(simples.length);
    }
}
