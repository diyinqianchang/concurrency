package com.abc.latch;

import java.util.concurrent.*;

/**
 * @Author Administrator
 * @Date 2025/9/28 22:12
 * @Version 1.0
 */
public class BasicSemaphoreDemo {

    private static final int PERMITS = 3; // 同时允许3个线程访问
    private static final Semaphore semaphore = new Semaphore(PERMITS);

    public static void main(String[] args) {
        // 创建10个线程竞争访问资源
        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("线程 " + threadId + " 尝试获取许可证...");
                    semaphore.acquire(); // 获取许可证
                    int permits = semaphore.availablePermits();
                    System.out.println("线程 " + threadId + " 获得许可证，开始访问资源" +
                            " (可用许可证: " + permits + ")");

                    // 模拟资源访问
                    Thread.sleep(2000);

                    System.out.println("线程 " + threadId + " 释放许可证" + " (可用许可证: " + permits + ")");
                    semaphore.release(); // 释放许可证

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

//        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);


    }

}
