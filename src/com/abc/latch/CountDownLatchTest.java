package com.abc.latch;

import java.util.concurrent.Semaphore;

/**
 * @Author Administrator
 * @Date 2025/9/28 21:43
 * @Version 1.0
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        java.util.concurrent.CountDownLatch startSignal = new java.util.concurrent.CountDownLatch(1); // 开始信号
        java.util.concurrent.CountDownLatch doneSignal = new java.util.concurrent.CountDownLatch(threadCount); // 完成信号

        for(int i = 0;i<threadCount;i++){
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("线程 " + threadId + " 等待开始信号...");
                    startSignal.await(); // 等待开始信号

                    // 执行测试操作
                    System.out.println("线程 " + threadId + " 开始执行");
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println("线程 " + threadId + " 执行完成");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    doneSignal.countDown();
                }
            }).start();
        }

        Thread.sleep(1000); // 给线程创建时间
        System.out.println("=== 发出开始信号 ===");
        startSignal.countDown(); // 同时启动所有线程

        doneSignal.await(); // 等待所有线程完成
        System.out.println("=== 所有线程执行完成 ===");


    }

//    private static final int WORKER_COUNT = 5;
//
//    public static void main(String[] args) throws InterruptedException {
//        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(WORKER_COUNT);
//
//        // 创建并启动工作线程
//        for (int i = 0; i < WORKER_COUNT; i++) {
//            final int workerId = i;
//            new Thread(() -> {
//                try {
//                    // 模拟工作耗时
//                    Thread.sleep((long) (Math.random() * 3000));
//                    System.out.println("工作线程 " + workerId + " 完成任务");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    latch.countDown(); // 重要：在finally中调用
//                }
//            }).start();
//        }
//
//        System.out.println("主线程等待所有工作线程完成...");
//        latch.await(); // 阻塞直到计数器归零
//        System.out.println("所有工作线程已完成，主线程继续执行");
//    }

}
