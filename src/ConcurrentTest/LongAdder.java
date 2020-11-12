package ConcurrentTest;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

/**
 * 三种累加器
 */
public class LongAdder {
    private static AtomicLong atomicLong=new AtomicLong();
    //JDK8新增
    private static java.util.concurrent.atomic.LongAdder  longAdder=new java.util.concurrent.atomic.LongAdder();
    private static LongAccumulator longAccumulator=new LongAccumulator(new LongBinaryOperator() {
        @Override
        public long applyAsLong(long left, long right) {
            return left*right;
        }
    },1);


    private static int[] arrayOne=new int[]{0,1,2,3,0,5,0};
    private static int[] arrayTwo=new int[]{1,1,0,3,7,5,0};

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int item:arrayOne){
                    if(0==item){
                        longAdder.increment();
                        atomicLong.incrementAndGet(); //AtomicLong
                        longAccumulator.accumulate(2L);
                    }
                }
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int item:arrayTwo){
                    if(0==item){
                        longAdder.increment();
                        atomicLong.incrementAndGet();//AtomicLong
                        longAccumulator.accumulate(2L);
                    }
                }
            }
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(atomicLong.get());
        System.out.println(longAdder.sum());
        System.out.println(longAccumulator.get());
    }
}
