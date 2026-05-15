package com.abc.array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Administrator
 * @Date 2025/11/1 13:03
 * @Version 1.0
 */
public class ListTest {

    public static void main(String[] args) {
        // 模拟获取用户信息
//        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
//            return "用户: 张三";
//        });
//
//// 模拟获取订单信息
//        CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(() -> {
//            return "订单: 12345";
//        });
//
//// 组合两个异步任务的结果
//        CompletableFuture<String> combinedFuture = userFuture.thenCombine(orderFuture,
//                (user, order) -> user + ", " + order);
//
//        combinedFuture.thenAccept(result -> System.out.println("组合结果: " + result));
//
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务1: 获取用户ID");
//            return 1001;
//        }).thenApply(userId -> {
//            System.out.println("任务2: 根据用户ID查询用户信息");
//            return "用户信息 for " + userId;
//        }).thenApply(userInfo -> {
//            System.out.println("任务3: 处理用户信息");
//            return "处理后的: " + userInfo;
//        }).thenAccept(finalResult -> {
//            System.out.println("最终结果: " + finalResult);
//        }).exceptionally(ex -> {
//            System.out.println("异常处理: " + ex.getMessage());
//            return null;
//        });
//
//        ThreadLocal<String> ts = new ThreadLocal<>();
//        ts.set("ded");
//        ts.get();
//        ts.remove();
//
//        ReentrantLock lock = new ReentrantLock();

        try (FileInputStream fis = new FileInputStream("test.txt")) {
            fis.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);



    }

}
