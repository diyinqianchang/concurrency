package observe;

import java.util.concurrent.TimeUnit;

public class ObservableTest {

    public static void main(String[] args) {

        Observable observableThread = new ObservableThread<String>(new MyTask());
        observableThread.start();
    }
}
