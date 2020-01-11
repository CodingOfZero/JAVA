import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//用1到49之间的49个Integer对象填充数组，然后，随机打乱列表，并从打乱的列表中选前6个值，排序
public class ShuffleTest {
    public static void main(String[] args){
        List<Integer> numbers=new ArrayList<>();
        for(int i=1;i<=48;i++)
            numbers.add(i);
        Collections.shuffle(numbers);
        System.out.println(numbers);
        List<Integer> winningCombination=numbers.subList(0,6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
