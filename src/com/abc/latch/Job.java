package com.abc.latch;

/**
 * @Author Administrator
 * @Date 2026/5/13 15:34
 * @Version 1.0
 */
public class Job implements Comparable<Job>{

    private String name;
    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public int compareTo(Job o) {
        return o.priority - this.priority;
    }
}
