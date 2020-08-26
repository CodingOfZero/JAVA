import java.util.*;

public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts=new TreeSet<>();//为什么不用TreeSet，而是使用SortedSet，是由于接口吗？
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);//按照部件编号排序

        //使用一个定制的比较器来排序
        NavigableSet<Item> sortByDescription=new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

        //集合转换为数组
//        List<Integer> list = new LinkedList<>();
//        list.add(23);
//        list.add(34);
//        Integer[] k = list.toArray(new Integer[0]);
//        for (int l : k)
//            System.out.println(l);


    }
}