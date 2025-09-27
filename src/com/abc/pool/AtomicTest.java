package com.abc.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author Administrator
 * @Date 2025/9/23 20:34
 * @Version 1.0
 */
public class AtomicTest {

    public static void main(String[] args) {
//        AtomicStampedReference<Integer> ref = new AtomicStampedReference<>(1,0);
//
//        LongAdder longAdder = new LongAdder();
//
//        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//        threadLocal.set(1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.
//
//        Thread thread = new Thread();
//        thread.isInterrupted();
//        thread.interrupt();
    }

}
