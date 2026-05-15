package com.abc.jvm;

/**
 * @Author Administrator
 * @Date 2025/10/1 18:00
 * @Version 1.0
 */
public class LocalVariableTest {
    public static void main(String[] args) {

        test();

    }

    public static void test() {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);
    }

    public void test2() {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);
    }
}
