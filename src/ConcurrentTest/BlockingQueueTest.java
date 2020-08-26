package ConcurrentTest;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 输出某个目录下所有文件包含关键字的行
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE=10;
    private static final int SEARCH_THREADS=100;//100个搜索线程
    private static final File Dummy=new File("");
    private static BlockingQueue<File> queue=new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try(Scanner in=new Scanner(System.in)){
            System.out.println("Enter base directory");
            String directory=in.nextLine();
            System.out.println("Enter keyword");
            String keyword=in.nextLine();

            Runnable enumerator=()->{
                try {
                    enumerate(new File(directory));
                    queue.put(Dummy);//为了终止程序
                } catch (InterruptedException e) {

                }
            };
            new Thread(enumerator).start();//开始线程
            for(int i=1;i<=SEARCH_THREADS;i++){
                Runnable searcher=()->{
                    try {
                        boolean done=false;
                        while (!done){
                            File file=queue.take();
                            if(file==Dummy){//为了终止程序
                                queue.put(Dummy);
                                done=true;
                            }else
                                search(file,keyword);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }catch (InterruptedException e){

                    }
                };
                new Thread(searcher).start();
            }
        }
    }
    /**
     * 递归遍历全部文件与文件夹，如果是文件夹，递归下去，文件放入阻塞队列中
     * @param directory
     * @throws InterruptedException
     */
    public static void enumerate(File directory) throws InterruptedException {
        File[] files=directory.listFiles();
        for(File file:files){
            if(file.isDirectory())
                enumerate(file);
            else
                queue.put(file);
        }
    }

    public static void search(File file,String keyWord) throws IOException {
        try(Scanner in=new Scanner(file,"UTF-8")){
            int lineNumber=0;
            while (in.hasNextLine()){
                lineNumber++;
                String line=in.nextLine();
                if(line.contains(keyWord))
                    System.out.printf("%s:%d:%s\n",file.getPath(),lineNumber,line);
            }
        }
    }

}
