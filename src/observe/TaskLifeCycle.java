package observe;

public interface TaskLifeCycle<T> {

    void onStart(Thread thread);

    void onRunning(Thread thread);

    void onFinish(Thread thread,T result);

    void onError(Thread thread,Exception e);

    class EmptyLifeCycle<T> implements TaskLifeCycle<T>{
        @Override
        public void onStart(Thread thread) {
            System.out.println("EmptyLifeCycle start");
        }

        @Override
        public void onRunning(Thread thread) {
            System.out.println("EmptyLifeCycle onRunning");
        }

        @Override
        public void onFinish(Thread thread, T result) {
            System.out.println("EmptyLifeCycle onFinish : "+ result.toString());
        }

        @Override
        public void onError(Thread thread, Exception e) {
            System.out.println("EmptyLifeCycle onError");
        }
    }

}
