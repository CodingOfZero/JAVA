package ConcurrentTest;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
    //子线程可以访问父线程设置的本地变量
    private static ThreadLocal<String> shardNumber=new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(996);
        shardNumber.set("father shared");
        System.out.println("main thread number is "+threadLocal.get());
        System.out.println("main thread string is "+shardNumber.get());
        shardNumber.remove();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(777);
                System.out.println("child thread number is " + threadLocal.get());
                System.out.println("child thread String is " + shardNumber.get());
            }
        });
        thread.start();
        Thread.sleep(3000);
        System.out.println("main thread finish");
    }
}
