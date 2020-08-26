package ConcurrentTest;

public class synchBank {
    public static final int  COUNTS=10;//10个账户
    public static final double INITIAL_BALANCE=1000;//每个账户初始金额
    public static final double MAX_AMOUNT=1000;
    public static final int DELAY=10;

    public static void main(String[] args) {
        //BankConcurrentBySynchronized bank=new BankConcurrentBySynchronized(COUNTS,INITIAL_BALANCE);

        BankConcurrentByLock bank=new BankConcurrentByLock(COUNTS,INITIAL_BALANCE);
        for(int i=0;i<COUNTS;i++){
            int fromAccount=i;
            Runnable r=()->{
              try{
                  while (true){
                      int toAccount=(int)(bank.size()*Math.random());
                      double amount=MAX_AMOUNT*Math.random();
                      bank.transfer(fromAccount,toAccount,amount);
                      Thread.sleep((int)(DELAY*Math.random()));
                  }
              } catch (InterruptedException e) {

              }
            };
            Thread t=new Thread(r);
            t.start();
        }
    }
}
