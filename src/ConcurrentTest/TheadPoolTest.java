package ConcurrentTest;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * 测试线程池
 * MatchCounterByPool
 */
public class TheadPoolTest {
    public static void main(String[] args) {
        try(Scanner in=new Scanner(System.in)) {
            System.out.println("Enter base directory");
            String directory = in.nextLine();
            System.out.println("Enter keyword");
            String keyword = in.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();

            MatchCounterByPool counter=new MatchCounterByPool(new File(directory),keyword,pool);
            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get()+"matching files");
            }catch (ExecutionException e){
                e.printStackTrace();
            }catch (InterruptedException e){

            }
            pool.shutdown();

            int largestPoolSize=((ThreadPoolExecutor)pool).getLargestPoolSize();
            System.out.println("largest pool size="+largestPoolSize);
        }
    }
}
