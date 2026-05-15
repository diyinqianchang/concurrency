package com.abc.jvm;

/**
 * @Author Administrator
 * @Date 2025/10/1 10:48
 * @Version 1.0
 */
public class CustomLoaderDemo {

    public static void main(String[] args) throws Exception {
        String classPath = "myclasses"; // 自定义类路径
        String className = "com.abc.jvm.sample.MyClass";

        // 创建自定义类加载器
        CustomClassLoader customLoader = new CustomClassLoader(classPath);

        // 加载类
        Class<?> myClass = customLoader.loadClass(className);

        System.out.println("类: " + myClass.getName());
        System.out.println("类加载器: " + myClass.getClassLoader());
        System.out.println("父类加载器: " + myClass.getClassLoader().getParent());

        // 创建实例
        Object instance = myClass.newInstance();
        System.out.println(instance);
    }
}
