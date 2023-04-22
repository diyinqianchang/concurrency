package load;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("load.HelloWorld");
        System.out.println(aClass.getClassLoader());

        Object helloWorld = aClass.newInstance();
        System.out.println(helloWorld);

        Method welcome = aClass.getMethod("welcome");
        Object invoke = welcome.invoke(helloWorld);
        System.out.println("Result: "+invoke);


    }

}
