package com.abc.basic;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Administrator
 * @Date 2025/9/20 17:07
 * @Version 1.0
 */
public class ListTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
//        list.remove(0);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.get(0);

        ListIterator<String> iterator = list.listIterator();
        Iterator<String> iterator1 = list.iterator();

        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.remove(0);



        System.out.println(10>>1);

        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(10);
        strings.poll();

        CopyOnWriteArrayList<String> strings1 = new CopyOnWriteArrayList<>();
        strings1.add("1");
        strings1.get(0);
        strings1.listIterator();

        Comparable<String> stringComparable = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };



        Stack<String> stack = new Stack<>();

        Properties properties = new Properties();

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(10);
        blockingQueue.add("1");
        blockingQueue.offer("1");
//        blockingQueue.put("1");
        Collections.unmodifiableList( list);
        TreeSet<String> treeSet = new TreeSet<>();

        ReentrantLock reentrantLock = new ReentrantLock(true);
        Condition condition = reentrantLock.newCondition();
//        condition.await();
        reentrantLock.lock();
        reentrantLock.unlock();
//        reentrantLock.tryLock(1, TimeUnit.SECONDS);

    }

}
