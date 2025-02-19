package main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        new Main().run();
    }

    private void run() {

        try {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            ExecutorService executor = Executors.newFixedThreadPool(4);
            for (int i = 0; i < 100; i++) {
                executor.execute(new MyWorker());
                executor.execute(this::bar);
            }
            executor.shutdown();
            executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void bar() {

    }

    class MyWorker implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep((long)(Math.random() * 1000));
                System.out.println(Thread.currentThread().getId() + " Terminated");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class MyCallWorker implements Callable<Integer> {


        @Override
        public Integer call() throws Exception {
            return 42;
        }
    }
}