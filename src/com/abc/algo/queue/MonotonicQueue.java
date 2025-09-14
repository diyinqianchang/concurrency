package com.abc.algo.queue;

import java.util.LinkedList;

/**
 * @Author Administrator
 * @Date 2025/9/14 15:36
 * @Version 1.0
 */
public class MonotonicQueue {

    LinkedList<Integer> queue = new LinkedList<>();

    public void push(int n) {
        while (!queue.isEmpty() && queue.getLast() < n){
            queue.pollLast();
        }
        queue.addLast(n);
    }

    public void pop(int n) {
        if (!queue.isEmpty() && queue.getFirst() == n){
            queue.pollFirst();
        }
    }

    public int max() {
        if (queue.isEmpty()) return 0;
        return queue.getFirst();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "MonotonicQueue{" +
                "queue=" + queue +
                '}';
    }
}
