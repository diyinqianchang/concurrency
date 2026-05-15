package com.abc.basic;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Author Administrator
 * @Date 2025/9/17 21:12
 * @Version 1.0
 */
public class MapTest {

    public static void main(String[] args) {
//        System.out.println("Hello World");
        System.out.println(test());
//
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//
//        Hashtable<Integer,Integer> table = new Hashtable<>();
//        table.put(1,1);
//        table.keys();
////
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("1",1);
//        hashMap.put("2",1);
//        hashMap.keySet();
//        hashMap.entrySet();
//        Integer o = hashMap.get("1");
//        System.out.println(o);
//        System.out.println(1<<30);

//        Map<Object, Object> map = Collections.synchronizedMap(objectObjectHashMap);
//        map.put(1,1);
//
//        StringBuilder sb = new StringBuilder();
//        StringBuffer sb2 = new StringBuffer();
//        sb2.append("1");

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,1);
//
//        String s1 = "a";
//        String s2 = s1+"b";
//        String s3 = "a"+"b";
//        System.out.println(s2=="ab");
//        System.out.println(s3=="ab");
//
//
//        ConcurrentSkipListMap map = new ConcurrentSkipListMap();
//
//        LinkedHashMap linkedHashMap = new LinkedHashMap();
//        linkedHashMap.put(1,1);
//
//        WeakHashMap<String,String> weakHashMap = new WeakHashMap();
//        weakHashMap.put(new String("1"),"1");

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1","1");

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "hello world";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello ZGL";
        });
        CompletableFuture<String> future2_2 = CompletableFuture.supplyAsync(() -> {
            return "hello XXQ";
        });

        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future2, future2_2);
        CompletableFuture<String> future3 = future1.thenCombine(anyOf, (a,b)->{
            return a+" "+b;
        });
        System.out.println(future3.join());




    }

    static int test(){
        int x = 1;
        try {
            return x;
        }finally {
            ++x;
        }
    }

}
