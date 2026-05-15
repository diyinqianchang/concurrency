package com.abc.jvm;

/**
 * @Author Administrator
 * @Date 2025/10/1 10:42
 * @Version 1.0
 */
public class DelegationExample {

    public static void main(String[] args) throws Exception {
        String className = "java.lang.String";

        // 尝试用Application ClassLoader加载String
        ClassLoader appLoader = DelegationExample.class.getClassLoader();
        Class<?> stringClass = appLoader.loadClass(className);

        System.out.println("加载的String类: " + stringClass);
        System.out.println("String类的加载器: " + stringClass.getClassLoader());
    }

}
