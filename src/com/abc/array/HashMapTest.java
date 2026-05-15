package com.abc.array;

;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2025/7/30 21:49
 * @Version 1.0
 */
public class HashMapTest {

    public static void main(String[] args) throws Exception {



//        HashMap<String, String> map = new HashMap<>();
//        map.put("1","1");
//
//        Student student = null; //new Student(1,null);
//        String s = Opt.ofNullable(student).map(Student::getName).get();
//        System.out.println(s);
//        boolean present = Optional.ofNullable(student).map(Student::getName).isPresent();
//        System.out.println(present);

//        Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream()
//                .filter(i -> i % 2 == 0)
//                .forEach(System.out::println);
//        TreeMap<String, String> treeMap = new TreeMap<>();
//        treeMap.put("1","1");
//        treeMap.put("2",null);
//        treeMap.put("3","3");

        ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>();
        map1.put("1","1");
        map1.size();
//
//        map1.putIfAbsent("a","q");
//        map1.computeIfAbsent("b",k->"q");
//        System.out.println(map1);


//        HashSet<String> set = new HashSet<>();
//        set.add("1");

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        for (String s : map.keySet()){
            System.out.println(map.get(s));
        }
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        executorService.execute(()->{
            System.out.println("开始执行");
        });

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("1");
        System.out.println(threadLocal.get());

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("1","1");





//        try(FileOutputStream fos = new FileOutputStream("stu.txt");) {
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(student);
//        }

//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
//        executorService.schedule(()->{
//            System.out.println("开始执行");
//        }, 1, TimeUnit.SECONDS);
//
//        executorService.schedule(()->{
//            System.out.println("结束执行");
//        }, 1, TimeUnit.SECONDS);
//
//        executorService.shutdown();
//        Thread.sleep(3000);
//        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(map);
//        objectObjectMap.put(1,1);


//        List<Integer> list1 = Arrays.asList(1, 209, 386, 679, 431, 55, 987);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        long l = System.currentTimeMillis();
//        System.out.println(l);
//        List<Integer> collect = list.parallelStream().filter(i -> list1.contains(i)).sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
//        System.out.println(collect);
//        System.out.println(System.currentTimeMillis() - l);


//      Thread.isInterrupted();



//        try (FileInputStream fis = new FileInputStream("stu.txt")){
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            Student o = (Student)ois.readObject();
//            System.out.println(o);
//        }catch (Exception e){
//            System.out.println(e);
//        }




    }

}
