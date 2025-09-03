package com.abc.rw;

public interface Lock {

    void lock() throws InterruptedException;

    void unlock();

}
