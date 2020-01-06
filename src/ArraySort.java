import java.util.Arrays;
import java.util.Scanner;
public class ArraySort {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("input n");
        int n=in.nextInt();
        //存放抽的数值
        int[] numbers=new int[n];
        for(int i=0;i<numbers.length;i++)
            numbers[i]=i+1;
        //抽的次数为k，结果存放在result中
        System.out.println("input k");
        int k=in.nextInt();
        int[] result=new int[k];
        //Math.random()方法将返回一个0到1之间的随机浮点数（包含0，不包含1），用n乘以可以得到从0到n-1之间一个随机数
        for(int i=0;i<result.length;i++){
            int r=(int)(Math.random()*n);
            result[i]=numbers[r];
            //以下两句，防止抽到相同的
            numbers[r]=numbers[n-1];
            n--;
        }
        //排序输出
        Arrays.sort(result);
        for(int i:result)
            System.out.println(i);
    }
}
