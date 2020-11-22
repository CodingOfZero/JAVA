package ConcurrentTest;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS条件变量
 */
public class ConditonObject {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock=new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try{
                    System.out.println("begin wait");
                    condition.await();
                    System.out.println("end wait");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        reentrantLock.lock();
        try{
            System.out.println("begin signal");
            condition.signal();
            System.out.println("end signal");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }
}
