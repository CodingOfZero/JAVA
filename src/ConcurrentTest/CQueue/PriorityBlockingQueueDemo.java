package ConcurrentTest.CQueue;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    public static class DemoTask implements Comparable<DemoTask>{
        private int priority=0;
        private String taskName;

        public DemoTask(int priority, String taskName) {
            this.priority = priority;
            this.taskName = taskName;
        }

        public int getPriority() {
            return priority;
        }


        public String getTaskName() {
            return taskName;
        }

        @Override
        public int compareTo(DemoTask o) {
            return this.getPriority()-o.getPriority();
        }
        public void doSomeThing(){
            System.out.println(taskName+":"+priority);
        }
    }

    public static void main(String[] args) {
        PriorityBlockingQueue<DemoTask> pbq=new PriorityBlockingQueue<DemoTask>();
        //创建任务，并添加到队列
        Random random=new Random();
        for(int i=0;i<10;i++){
            pbq.offer(new DemoTask(random.nextInt(10),"task"+i));
        }

        while (!pbq.isEmpty()){
            DemoTask task = pbq.poll();
            if(null!=task) {
                task.doSomeThing();
            }
        }

    }
}
