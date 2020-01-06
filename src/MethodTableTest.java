import java.lang.reflect.Method;

public class MethodTableTest {
    public static void main(String[] args)throws Exception{
        Method square=MethodTableTest.class.getMethod("square", double.class);//通过反射获得方法指针,(此类本身方法)
        Method sqrt=Math.class.getMethod("sqrt", double.class);//获得Math类中sqrt的方法指针

        printTable(1,10,10,square);
        printTable(1,10,10,sqrt);
    }
    public static double square(double x){
        return x*x;
    }
    /**
     * Prints a table with x- and y- values for a method
     * @param from the lower bound for the x-values
     * @param to the upper bound for the x-values
     * @param n the number of rows in the table
     * @param f a method with a double parameter and double return value*/
    public static void printTable(double from,double to, int n, Method f){
        System.out.println(f);
        double dx=(to-from)/(n-1);

        for(double x=from;x<=to;x+=dx){
            try {
                double y=(Double)f.invoke(null,x);//invoke方法,允许调用包装在当前Method对象中的方法
                System.out.printf("%10.4f|%10.4f%n",x,y);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
