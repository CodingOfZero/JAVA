package ConcurrentTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadMethod {
    //继承Thread类
    public static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("ThreadA ...");
        }
    }
    //Runnable接口
    public static class RunnableTask implements Runnable{
        @Override
        public void run() {
            System.out.println("RunnableTask ...");
        }
    }
    //创建任务类
    public static class CallerTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyThread myThread = new MyThread();
        myThread.start();

        RunnableTask runnableTask = new RunnableTask();
        new Thread(runnableTask).start();

        //创建异步任务
        FutureTask<String> task=new FutureTask<>(new CallerTask());
        new Thread(task).start();
        try{
            String result=task.get();
            System.out.println(result);
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
