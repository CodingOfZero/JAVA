package ConcurrentTest;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制的弱一致性
 * 测试迭代器的弱一致性
 */
public class CopyOnWriteTest {

    private static CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("My");
        arrayList.add("name");
        arrayList.add("is");
        arrayList.add("linda");

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.remove(3);
                arrayList.add("Tom");
                arrayList.set(0,"Yours");
                System.out.println("child thread iterator.....");
                Iterator<String> iterator = arrayList.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
            }
        });
        //保证在修改线程启动前获得迭代器
        Iterator<String> iterator = arrayList.iterator();

        thread.start();

        //等待线程执行完毕
        thread.join();
        //遍历
        System.out.println("main thread iterator.....");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
