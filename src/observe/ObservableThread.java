package observe;

public class ObservableThread<T> extends Thread implements Observable{



    private final TaskLifeCycle<T> lifeCycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObservableThread(Task task){
        this(new TaskLifeCycle.EmptyLifeCycle(),task);
    }

    public ObservableThread(TaskLifeCycle lifeCycle,Task task){
        super();
        if (task == null){
            throw new IllegalArgumentException("The task is required.");
        }
        this.lifeCycle = lifeCycle;
        this.task = task;
    }

    @Override
    public void run() {
        this.update(Cycle.STARTED,null,null);
        try {
            this.update(Cycle.RUNNING,null,null);
            T result = this.task.call();
            this.update(Cycle.DONE,result,null);
        }catch (Exception e){
            this.update(Cycle.ERROR,null,e);
        }
    }

    private void update(Cycle cycle,T result,Exception e){
        this.cycle = cycle;
        if (lifeCycle == null){
            return;
        }
        try {
            switch (cycle){
                case STARTED:
                    this.lifeCycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifeCycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifeCycle.onFinish(currentThread(),result);
                    break;
                case ERROR:
                    this.lifeCycle.onError(currentThread(),e);
                    break;
            }
        }catch (Exception ex){
            if (cycle == Cycle.ERROR){
                throw ex;
            }
        }
    }

    @Override
    public Cycle getCycle() {
        return cycle;
    }
}
