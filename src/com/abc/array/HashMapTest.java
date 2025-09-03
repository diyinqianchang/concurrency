package com.abc.array;

import cn.hutool.core.lang.Opt;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2025/7/30 21:49
 * @Version 1.0
 */
public class HashMapTest {

    public static void main(String[] args) throws Exception {




//        HashMap<Object, Object> map = new HashMap<>();
//
//        Student student = null; //new Student(1,null);
//        String s = Opt.ofNullable(student).map(Student::getName).get();
//        System.out.println(s);
//        boolean present = Optional.ofNullable(student).map(Student::getName).isPresent();
//        System.out.println(present);

        Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);


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
