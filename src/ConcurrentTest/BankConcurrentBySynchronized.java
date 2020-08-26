package ConcurrentTest;

import java.util.Arrays;

/**
 * 同步,方式为synchronized
 */
public class BankConcurrentBySynchronized {
    private final double[] accounts;
    public BankConcurrentBySynchronized(int n, double initialBalance){
        accounts=new double[n];
        Arrays.fill(accounts,initialBalance);
    }
    public synchronized void transfer(int from,int to,double amount){

        if(accounts[from]<amount) return;
        System.out.println(Thread.currentThread());
        accounts[from]-=amount;
        System.out.printf("%10.2f from %d to %d\n",amount,from,to);
        accounts[to]+=amount;
        System.out.printf("Total Balance :%10.2f\n",getTotalBalance());
    }
    public synchronized double getTotalBalance(){
        double sum=0;
        for(double a:accounts)
            sum+=a;
        return sum;
    }

    public int size(){
        return accounts.length;
    }

}
