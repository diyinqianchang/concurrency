package load;

import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    static {
        System.out.println("Hello World Class is Initialized");
    }
    public String welcome(){
        return "Hello World";
    }

    public static void main(String[] args) {

        try {
            Thread.sleep(1000000);
        }catch (Exception e){

        }
        Map<String,String> map = new HashMap<>();

    }
}
