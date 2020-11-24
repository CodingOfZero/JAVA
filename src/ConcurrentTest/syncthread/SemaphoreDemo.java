package ConcurrentTest.syncthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    //参数为base的值（由自己定）,如果想使M个线程同步，则acquire方法里面的参数应该为base+M
    //以下示例使两个线程同步
    private static Semaphore semaphore=new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread()+"task1....");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread()+"task2....");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("wait all child thread over");
        semaphore.acquire(4);
        System.out.println("all child thread over!");
        pool.shutdown();
    }
}
