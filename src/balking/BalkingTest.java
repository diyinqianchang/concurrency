package balking;

/**
 * @Author Administrator
 * @Date 2022/8/13 17:43
 * @Version 1.0
 */
public class BalkingTest {

    public static void main(String[] args) {
        new DocumentEditThread("C:\\Users\\Administrator\\Desktop\\javetest\\src\\balking","balking.txt").start();
    }

}
