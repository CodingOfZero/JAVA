package ConcurrentTest.syncthread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(2);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+"step1....");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"step2....");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"step3....");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+"step1....");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"step2....");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+"step3....");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pool.shutdown();
    }
}
