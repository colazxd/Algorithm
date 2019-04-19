package interview;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> waitNotifyExample.after());
        executorService.execute(()-> waitNotifyExample.before());

    }
}

