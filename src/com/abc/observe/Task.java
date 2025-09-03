package com.abc.observe;


@FunctionalInterface
public interface Task <T>{

    T call();
}
