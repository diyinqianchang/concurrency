package com.abc.pool;


@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);

}
