import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
/**
 * 打印一个类的全部信息
 * 输入一个类名后，输出类的所有的方法和构造器的签名，以及全部域名
 * */
public class ReflectionTest {
    public static void main(String[] args){
         String name;
         if(args.length>0) name=args[0];//命令行
         else{
             Scanner in=new Scanner(System.in);
             System.out.println("Enter class name(e.g. java.util.Date): ");
             name=in.next();
         }
         try {
             Class cl=Class.forName(name);//获取Class对象
             Class supercl=cl.getSuperclass();//获取超类
             String modifiers= Modifier.toString(cl.getModifiers());//获取修饰符public/private ...
             if(modifiers.length()>0) System.out.print(modifiers+" ");
             System.out.print("class "+name);
             if(supercl!=null&&supercl!=Object.class)System.out.print(" extends "+supercl.getName());//打印超类

             System.out.print("\n{\n");
             //打印构造器
             printConstructors(cl);
             System.out.println();
             //打印方法
             printMethods(cl);
             System.out.println();
             //打印域
             printFields(cl);
             System.out.println();

             System.out.print("}");

         }catch (ClassNotFoundException e){
             e.printStackTrace();
         }
         System.exit(0);
    }
    /**
     * Prints all Constructors of a class
     * @param cl a class
     * */
    public static void printConstructors(Class cl){
        Constructor[] constructors=cl.getDeclaredConstructors();//获取类中声明的全部构造器

        for(Constructor c:constructors){
            System.out.print("  ");

            String modifiers= Modifier.toString(c.getModifiers());//获取修饰符
            if(modifiers.length()>0) System.out.print(modifiers+" ");

            String name=cl.getName();//获取构造器名
            System.out.print(name+"(");

            Class[] paramTypes=c.getParameterTypes();//返回一个用于描述参数类型的Class对象数组
            for(int j=0;j<paramTypes.length;j++){
                if(j>0)System.out.print(",");
                System.out.print(paramTypes[j].getName());//获取参数类型名
            }
            System.out.print(")");
            System.out.println();
        }
    }
    /**
     * Prints all methods of a class
     * @param cl a class
     * */
    public static void printMethods(Class cl){
        Method[] methods=cl.getMethods();

        for(Method m:methods){
            System.out.print("  ");

            String modifiers= Modifier.toString(m.getModifiers());//获取修饰符
            if(modifiers.length()>0) System.out.print(modifiers+" ");

            Class retType=m.getReturnType();//获取返回类型
            String name=m.getName();
            System.out.print(retType.getName()+" "+name+"(");

            Class[] paramTypes=m.getParameterTypes();//返回一个用于描述参数类型的Class对象数组
            for(int j=0;j<paramTypes.length;j++){
                if(j>0)System.out.print(",");
                System.out.print(paramTypes[j].getName());//获取参数类型名
            }
            System.out.print(");");
            System.out.println();
        }

    }
    /**
     * Prints all fields of a class
     * @param cl a class
     * */
    public static void printFields(Class cl){
        Field[] fields=cl.getFields();

        for(Field f:fields){
            System.out.print("  ");

            String modifiers= Modifier.toString(f.getModifiers());//获取修饰符
            if(modifiers.length()>0) System.out.print(modifiers+" ");

            Class type=f.getType();
            String name=f.getName();
            System.out.print(type.getName()+" "+name+";");
            System.out.println();
        }

    }
}
