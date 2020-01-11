import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.NavigableSet;
public class TreeSetTest {
    public static void main(String[] args){
        SortedSet<Item> parts=new TreeSet<>();//为什么不用TreeSet，而是使用SortedSet，是由于接口吗？
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);//按照部件编号排序

        //使用一个定制的比较器来排序
        NavigableSet<Item> sortByDescription=new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

    }


}
