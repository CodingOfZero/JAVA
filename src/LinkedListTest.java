import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<String> a=new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
//        ListIterator<String> iter=a.listIterator();
//        String first=iter.next();
//        iter.remove();
//        iter.next();
//        iter.add("Juliet");
//        System.out.println(a);
//        System.out.println(first);

        List<String> b=new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aItor=a.listIterator();
        Iterator<String> bItor=b.iterator();

        while(bItor.hasNext()){
            if(aItor.hasNext()) aItor.next();
            aItor.add(bItor.next());//ListIterator有add方法，Iterator没有
        }
        System.out.println(a);

        bItor=b.iterator();
        while (bItor.hasNext()){
            bItor.next();//跳过一个
            if(bItor.hasNext()){
                bItor.next();
                bItor.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);
    }
}
