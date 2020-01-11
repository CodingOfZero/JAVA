import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args){
        PriorityQueue<LocalDate> p=new PriorityQueue<>();
        p.add(LocalDate.of(1906,12,9));
        p.add(LocalDate.of(1815,12,10));
        p.add(LocalDate.of(1903,12,3));
        p.add(LocalDate.of(1910,6,22));
        System.out.println("Iterating over elements:...");//迭代并不是按照元素的排列顺序访问
        for(LocalDate t:p)
            System.out.println(t);
        System.out.println("Removing  elements:...");
        while (!p.isEmpty())
            System.out.println(p.remove());//删除总是删除剩余元素中最小的那个
    }
}
