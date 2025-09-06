package com.abc.algo;

/**
 * @Author Administrator
 * @Date 2025/9/3 23:00
 * @Version 1.0
 */
public class Sushu {

    public static void main(String[] args) {

        int count = 0;
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime2(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }



}
