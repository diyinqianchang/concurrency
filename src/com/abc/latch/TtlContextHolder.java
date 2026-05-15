package com.abc.latch;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.security.PrivilegedAction;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Administrator
 * @Date 2026/5/13 17:50
 * @Version 1.0
 */
public class TtlContextHolder {

    private static final TransmittableThreadLocal<String> CONTEXT =
            new TransmittableThreadLocal<String>(){
                @Override
                public String copy(String parentValue) {
                    return parentValue + " copy";
                }
            };

    private static final ExecutorService TTL_EXECUTOR_SERVICE;
    static {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10), new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setCorePoolSize();
//        executor.setMaximumPoolSize();
        TTL_EXECUTOR_SERVICE = TtlExecutors.getTtlExecutorService(executor);
    }

    public static void main(String[] args) throws Exception {

//        try {
//            CONTEXT.set("value-set-in-parent");
//            TTL_EXECUTOR_SERVICE.submit(() -> {
//                System.out.println("value in child thread: " + CONTEXT.get());
//                CONTEXT.set("value-set-in-child");
//                System.out.println("value in child thread: " + CONTEXT.get());
//            }).get();
//
//            Future<String> future = TTL_EXECUTOR_SERVICE.submit(() -> {
//                System.out.println("value in child thread2: " + CONTEXT.get());
//                return "Success";
//            });
//            String s = future.get();
//            System.out.println("result: " + s);
//            System.out.println("value in parent thread: " + CONTEXT.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            CONTEXT.remove();
//            TTL_EXECUTOR_SERVICE.shutdown();
//        }
//
//        new PriorityBlockingQueue<>();
////        new FutureTask<>();
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        Callable<Object> callable = java.util.concurrent.Executors.callable((PrivilegedAction<?>) () -> {
            return "callable";
        });
        Object call = callable.call();
        System.out.println(call);

        ReentrantLock lock = new ReentrantLock();

        Condition condition = lock.newCondition();


    }

}
