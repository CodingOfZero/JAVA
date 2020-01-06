import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static void main(String[] args){
        int[] a={1,2,3};
        a=(int[])goodCopyOf(a,10);//整型数组类型int[]可以被转换成Object,而不能转换成对象数组
        System.out.println(Arrays.toString(a));

        String[] b={"Tom","Dick","Harry"};
        b=(String[])goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b=(String[])badCopyOf(b,10);

    }
    /**
     * This method attempts to grow an array by allocating a new array and copying all elements.
     * @param a the array to grow
     * @param newlength the new length
     * @return a larger array that contains all elements of a. However,the returned array has
     * type Object[],not the same type as a.
     * */
    public static Object[] badCopyOf(Object[] a,int newlength){
        Object[] newArray=new Object[newlength];//此处有问题，
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newlength));
        return newArray;
    }
    /**
     * This method  grows an array by allocating a new array of the same type and copying all elements.
     * @param a the array to grow. This can be an object array or a primitive type array
     * @return a larger array that contains all elements of a.
     * */
    public static Object goodCopyOf(Object a,int newlength){//应声明为Object类型，而非对象型数组（Object[]）
        Class cl=a.getClass();//首先获得a数组的类对象
        if(!cl.isArray()) return null;//确认它是一个数组
        Class componentType=cl.getComponentType();//使用Class类的getComponentType方法确定数组对应的类型
        int length= Array.getLength(a);//获得数组长度
        Object newArray=Array.newInstance(componentType,newlength);//创建与原数组类型相同的新数组
        System.arraycopy(a,0,newArray,0,Math.min(length,newlength));
        return newArray;
    }
}
