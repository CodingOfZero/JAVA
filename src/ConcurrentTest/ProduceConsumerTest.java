package ConcurrentTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceConsumerTest {
    private static ReentrantLock reentrantLock=new ReentrantLock();
    private static Condition notFull=reentrantLock.newCondition();
    private static Condition notEmpty=reentrantLock.newCondition();

    private static Queue<String> queue=new LinkedBlockingQueue<String>();
    private static int QUEUESIZE=10;

    public static class Producer implements Runnable{
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                //使用while防止虚假唤醒
                //队列满了，则等待
                while (queue.size()==QUEUESIZE){
                    notEmpty.await();
                }
                System.out.println("正在生产中....");
                queue.add("小饼干");
                notFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static class Consumer implements Runnable{

        @Override
        public void run() {
            reentrantLock.lock();
            try {
                while (queue.size()==0){
                    notFull.await();
                }
                String poll = queue.poll();
                System.out.println("吃了一块"+poll+"...");
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Thread thread1=new Thread(producer);
        Thread thread2=new Thread(consumer);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}
