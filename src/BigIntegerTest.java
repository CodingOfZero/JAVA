import java.math.*;
import java.util.*;
/**
 *This program demonstrates a <code>for</code> loop.
 * @version 1.20 2020-1-2
 * @author hu
 * */
public class BigIntegerTest {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("How many numbers do you need to draw?");
        int k=in.nextInt();
        System.out.println("What is the highest number you can draw?");
        int n=in.nextInt();
        //使用静态valueOf方法可以将普通的数据转换为大数值
        BigInteger lotteryOdds= BigInteger.valueOf(1);
        for(int i=1;i<=k;i++){
            lotteryOdds=lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        }
        System.out.println("Your odds are 1 in "+lotteryOdds+". Good luck!");
    }
}
