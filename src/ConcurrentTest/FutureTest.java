package ConcurrentTest;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 统计有多少个文件包含关键字
 */
public class FutureTest {
    public static void main(String[] args) {
        try(Scanner in=new Scanner(System.in)){
            System.out.println("Enter base directory");
            String directory=in.nextLine();
            System.out.println("Enter keyword");
            String keyword=in.nextLine();

            MatchCounter counter=new MatchCounter(new File(directory),keyword);
            FutureTask<Integer> task=new FutureTask<>(counter);
            Thread t = new Thread(task);
            t.start();
            try {
                System.out.println(task.get()+"matching files");
            } catch (InterruptedException e) {

            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
