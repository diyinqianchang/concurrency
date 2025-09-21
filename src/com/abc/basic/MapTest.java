package com.abc.basic;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Author Administrator
 * @Date 2025/9/17 21:12
 * @Version 1.0
 */
public class MapTest {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(test());

        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//
//        Hashtable<Integer,Integer> table = new Hashtable<>();
//        table.put(1,1);
//
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        Map<Object, Object> map = Collections.synchronizedMap(objectObjectHashMap);
//        map.put(1,1);
//
//        StringBuilder sb = new StringBuilder();
//        StringBuffer sb2 = new StringBuffer();
//        sb2.append("1");

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        String s1 = "a";
        String s2 = s1+"b";
        String s3 = "a"+"b";
        System.out.println(s2=="ab");
        System.out.println(s3=="ab");


        ConcurrentSkipListMap map = new ConcurrentSkipListMap();

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1,1);

        WeakHashMap<String,String> weakHashMap = new WeakHashMap();
        weakHashMap.put(new String("1"),"1");


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
