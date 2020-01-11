
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetTest {
    public static void main(String[] args){
        Set<String> words=new HashSet<>();
        long totaltime=0;
        try (Scanner in=new Scanner(System.in)){
            while (in.hasNext()){
                String word=in.next();
                long calltime=System.currentTimeMillis();
                words.add(word);
                calltime=System.currentTimeMillis()-calltime;
                totaltime+=calltime;
            }
        }
        Iterator<String> iter=words.iterator();
        for(int i=1;i<=20&&iter.hasNext();i++){
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size()+"distinct words."+totaltime+"milliseconds");
    }
}
