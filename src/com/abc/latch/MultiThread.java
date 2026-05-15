package com.abc.latch;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author Administrator
 * @Date 2026/5/13 13:56
 * @Version 1.0
 */
public class MultiThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
//        for (ThreadInfo threadInfo : threadInfos) {
//            System.out.println("线程名：" + threadInfo.getThreadName());
//            System.out.println("线程ID：" + threadInfo.getThreadId());
//            System.out.println("线程状态：" + threadInfo.getThreadState());
//            System.out.println("线程堆栈：" + threadInfo.getStackTrace());
//            System.out.println("===========================================");
//        }

//        CompletableFuture<String> future = CompletableFuture.completedFuture("hello!")
//                .thenApply(s -> s + "world!");
//        assertEquals("hello!world!", future.get());
//// 这次调用将被忽略。
//        CompletableFuture<String> thenApply = future.thenApply(s -> s + "nice!");
//        assertEquals("hello!world!", thenApply.get());

//        CompletableFuture<String> compose = CompletableFuture.supplyAsync(() -> "hello!")
//                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "world!"));
//        System.out.println(compose.get());
//
//        new Comparator<String>(){
//          @Override
//          public int compare(String o1, String o2) {
//              return 0;
//          }
//        };
//
//
//        Deque<String> deque = new java.util.ArrayDeque<>();
//        deque.add("1");
//        deque.add("2");
//        deque.poll();
//
//        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
//        blockingDeque.add("1");
//        blockingDeque.add("2");
//        blockingDeque.poll();
//
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.poll();

        System.out.println(8>>>1);



    }

    private static void assertEquals(String s, String s1) {
        System.out.println(s1);
        if (!s.equals(s1)) {
            throw new RuntimeException("Expected: " + s + " but was: " + s1);
        }
    }

}
