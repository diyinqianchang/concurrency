package rw;

/**
 * @Author Administrator
 * @Date 2021/10/30 20:52
 * @Version 1.0
 */
public class ReadWriteLockTest {

    private final static String text = "Thisistheexampleforreadwritelock";

    public static void main(String[] args) {

        final SharedData sharedData = new SharedData(10);
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int index = 0; index < text.length(); index++) {
                    try {
                        char o = text.charAt(index);
                        sharedData.write(o);
                        System.out.println(Thread.currentThread()+" write "+o);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    try {
                        System.out.println(Thread.currentThread()+" read "+new String(sharedData.read()));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
