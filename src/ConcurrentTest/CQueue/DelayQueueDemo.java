package ConcurrentTest.CQueue;


import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue
 */
public class DelayQueueDemo {
    static public class DelayTask implements Delayed{
        private final long delayTime;//延迟时间
        private final long expire;//终止时间
        private String taskName;

        public DelayTask(long delayTime, String taskName) {
            this.delayTime = delayTime;
            this.expire=System.currentTimeMillis()+delayTime;
            this.taskName = taskName;
        }

        /**
         * 剩余时间=到期时间-当前时间
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        /**
         * 优先级队列中的优先级规则
         * @param o
         * @return
         */
        @Override
        public int compareTo(Delayed o) {
            return (int)(this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public java.lang.String toString() {
            return "DelayTask{" +
                    "delayTime=" + delayTime +
                    ", expire=" + expire +
                    ", taskName=" + taskName +
                    '}';
        }
    }

    public static void main(String[] args) {
        DelayQueue<DelayTask> delayTasks=new DelayQueue<>();
        //创建延迟任务
        Random random=new Random();
        for(int i=0;i<10;i++){
            delayTasks.offer(new DelayTask(random.nextInt(500),"task: "+i));
        }
        //依次取出任务
        DelayTask task=null;
        for(;;){
            while ((task=delayTasks.poll())!=null){
                System.out.println(task.toString());
            }
        }
    }
}
