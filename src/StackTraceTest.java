import java.util.*;

/**
 *A program that display a trace feature of a recursive method call.
 *  */
public class StackTraceTest {
    public static int factorial(int n){
        System.out.println("factorial("+n+"):");
        Throwable t=new Throwable();
        StackTraceElement[] frames=t.getStackTrace();
        for(StackTraceElement f:frames)
            System.out.println(f);
        //所有线程堆栈轨迹
        /*Map<Thread,StackTraceElement[]> map=Thread.getAllStackTraces();
        for(Thread t1:map.keySet()){
            StackTraceElement[] frame=map.get(t1);
            for(StackTraceElement f:frame)
                System.out.println(f);
        }*/

        int r;
        if(n<=1) r=1;
        else r=n*factorial(n-1);

        System.out.println("return "+r);
        return r;


    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=in.nextInt();
        factorial(n);
    }
}
