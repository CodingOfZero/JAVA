package ConcurrentTest;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步，方式为ReentrantLock,并使用条件对象Condition
 */
public class BankConcurrentByLock {
    private final double[] accounts;
    private Lock lock;
    private Condition sufficientFunds;

    public BankConcurrentByLock(int n, double initialBalance){
        accounts=new double[n];
        Arrays.fill(accounts,initialBalance);
        lock = new ReentrantLock();
        sufficientFunds=lock.newCondition();
    }
    public  void transfer(int from,int to,double amount) throws InterruptedException{
        lock.lock();
        try {
            while (accounts[from]<amount)
                sufficientFunds.await();
            System.out.println(Thread.currentThread());
            accounts[from]-=amount;
            System.out.printf("%10.2f from %d to %d\n",amount,from,to);
            accounts[to]+=amount;
            System.out.printf("Total Balance :%10.2f\n",getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public  double getTotalBalance(){
        lock.lock();
        try {
            double sum=0;
            for(double a:accounts)
                sum+=a;
            return sum;
        }finally {
            lock.unlock();
        }
    }

    public int size(){
        return accounts.length;
    }

}
