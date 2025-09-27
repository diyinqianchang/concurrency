package com.abc.pool;

/**
 * @Author Administrator
 * @Date 2025/9/24 21:54
 * @Version 1.0
 */
public class ActiveLock {

    static class ShareResource{

        private Worker owner;

        public Worker getOwner() {
            return owner;
        }

        public void setOwner(Worker owner) {
            this.owner = owner;
        }
    }

    static class Worker{
        private String name;
        private boolean active;

        public boolean isActive() {
            return active;
        }

        public Worker(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        public synchronized void work(ShareResource resource,Worker otherWorker){
            while (active){
                if (resource.getOwner()!=this){
                    System.out.println(name + ": 资源被 " + resource.getOwner().name + " 占用，我等待一下");
                    try {
                        wait(100); // 等待一段时间
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }
                if (otherWorker.isActive()){
                    System.out.println(name + ": " + otherWorker.name + " 也在等待，我让一下");
                    resource.setOwner(otherWorker); // 把资源让给其他Worker
                    continue;
                }
                System.out.println(name + ": 正在使用资源");
                active = false;
                resource.setOwner(otherWorker);
            }
        }
    }


    public static void main(String[] args) {
        final ShareResource resource = new ShareResource();
        Worker worker1 = new Worker("worker1",true);
        Worker worker2 = new Worker("worker2",true);
        resource.setOwner(worker1);

        Thread t1 = new Thread(()->{
            worker1.work(resource,worker2);
        });
        Thread t2 = new Thread(()->{
            worker2.work(resource,worker1);
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(10000);
            worker1.active = false;
            worker2.active = false;
            t1.interrupt();
            t2.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
