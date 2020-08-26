package ConcurrentTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * 通过线程池实现计数
 */
public class MatchCounterByPool implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounterByPool(File directory, String keyword, ExecutorService pool){
        this.directory=directory;
        this.keyword=keyword;
        this.pool=pool;
    }

    @Override
    public Integer call()  {
        count=0;
        try {
            File[] files=this.directory.listFiles();
            List<Future<Integer>> results=new ArrayList<>();

            for(File file:files){
                if(file.isDirectory()){
                    MatchCounterByPool counter=new MatchCounterByPool(file,keyword,pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else{
                    if(search(file)) count++;
                }
            }

            //计算结果
            for(Future<Integer> result:results){
                try{
                    count+=result.get();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }
            }
        }catch (InterruptedException e){}
        return count;
    }

    public boolean search(File file)  {
        try {
            try(Scanner in=new Scanner(file,"UTF-8")){
                boolean found=false;
                while (!found&&in.hasNextLine()){
                    String line=in.nextLine();
                    if(line.contains(this.keyword))
                        found=true;
                }
                return found;
            }
        }catch (IOException e){
            return false;
        }
    }
}
