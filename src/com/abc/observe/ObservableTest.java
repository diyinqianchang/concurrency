package com.abc.observe;

public class ObservableTest {

    public static void main(String[] args) {

        Observable observableThread = new ObservableThread<String>(new MyTask());
        observableThread.start();
    }
}
