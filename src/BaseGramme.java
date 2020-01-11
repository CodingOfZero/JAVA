import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

//import static java.lang.Math.*;//这里得加static，为什么？
public class BaseGramme {
    public static final double CM_PER=2.54;//关键字static final设置类常量，可在多个方法中使用
    public static void main(String[] args) throws IOException {
//double类型
        //可用十六进制表示浮点数值，在十六进制中，使用p表示指数，尾数使用十六进制，指数采用十进制，指数的基数是2
        double i=0x1.0p-3;
        System.out.println(0x1.0p-3);
        //可以使用Double.isNaN(double v)来判断一个double型是否为一个数
        //整数被0除将产生一个异常，浮点数被0除将会得到无穷大或NaN结果
        double a=0.0/0.0,b1=3.0/0.0;
        if(Double.isNaN(a))
            System.out.println("a 不是一个数字");
        if(Double.isInfinite(b1))
            System.out.println("b为正无穷");
        //Look inside c:/users  注意注释中的Unicode转移，比如前面斜杠加u会报错,
        //Unicode转义序列会在解析代码之前得到处理。
        //整型值与布尔值之间不能进行相互转换；
        //java中不区分变量声明与定义
        final double CM_PER_INCH=2.5;//常量名全大写
 //Math类
        // floorMod方法解决有关整数余数问题
        int position=3,adjustment=-4;
        int nowposition_1=(position+adjustment)%12;
        int nowposition_2=Math.floorMod(position+adjustment,12);//时间调整问题
        System.out.println(nowposition_1);
        System.out.println(nowposition_2);
        //round方法，可以对浮点数进行舍入运算，得到最接近的整数,返回类型为long
        double x_round=9.997;
        int x_round_1=(int) Math.round(x_round);
        System.out.println(x_round_1);
//String不可变字符串
        //substring方法从一个较大的字符串中提取出一个子串
        String greeting_1="Hello";
        String s_greeting=greeting_1.substring(0,3);
        System.out.println(s_greeting);
        //任何一个Java对象都可以转换为字符串，使用+拼接，常用在输出语句中
        int age_1=13;
        System.out.println("The age is "+age_1);
        //静态join方法，可以把多个字符串放在一起，用一个定界符分隔
        String all=String.join("/","S","M","L","XL");
        System.out.println(all);
        //equals方法检测两个字符串是否相等，不能使用==，这只能够确定是否放置在同一个位置上
        String he="hello";
        boolean t_1="hello".equals(he);
        System.out.println("is true or false :"+t_1);
        //只有字符串常量是共享的，而+或substring等操作产生的结果并不共享

        String greeting="  Hello\uD835\uDD46  ";
        int n=greeting.length();//代码单元,此时n=7
        int cpct=greeting.codePointCount(0,greeting.length());//实际的长度，即码点数量，cpct=6
        System.out.println("字符串为："+greeting);
        System.out.println("代码单元有："+n);
        System.out.println("字符串实际的长度（即码点数量）为："+cpct);
        //返回位置n的代码单元，一般不使用。
        char t=greeting.charAt(5);
        System.out.println(t);
        //得到第i个码点
        int index=greeting.offsetByCodePoints(0,4);
        int cp=greeting.codePointAt(index);
        System.out.println(cp);
        //想遍历一个字符串，并且依次查看每一个码点，使用codePoints方法，生成一个int值的“流”，每个int值对应一个码点。
        int[] codePoints_1=greeting.codePoints().toArray();
        //将一个码点数组转换为一个字符串，使用构造函数
        String str_greeting=new String(codePoints_1,0,codePoints_1.length);
        System.out.println("str_greeting is :"+str_greeting);
        //去除头部和尾部空格
        String greeting_trim=greeting.trim();
        System.out.println("greeting_trim is :"+greeting_trim);

        //由大量较短的字符串构建字符串，
        StringBuilder b=new StringBuilder();//先构建一个空的字符串构建器，然后需要时，每次添加一部分内容
        char c='i';
        String s="i try";
        b.append(s);
        b.append(c);
        String completedstring=b.toString();
        System.out.println("构建后的字符串为："+completedstring);
        b.delete(0,2);
        System.out.println(b);
//Scanner类定义在java.util包中
//        //首先先构造一个Scanner对象，并与"标准输入流"System.in关联
        Scanner in=new Scanner(System.in);
//
//        //读取一整行，包括空格
//        System.out.println("What is your name?");
//        String name=in.nextLine();
//        //读取单个部分，以空白符作为分隔符
//        String firstinput=in.next();//单个词
//        System.out.println(firstinput);
        System.out.println("How old are you?");
        int age=in.nextInt();//一个整数
//        System.out.println("Hello "+name+" Next year,you'll be "+(age+1));
//        double dou=in.nextDouble();//浮点数
//        System.out.println(dou);
//        //检测后续是否还存在其他单词，整数，浮点数
//        boolean f_hasnext=in.hasNext();
//        System.out.println(f_hasnext);
//        boolean f_hasnextint=in.hasNextInt();
//        System.out.println(f_hasnextint);

        //console
        /*Console cons=System.console();
        if(cons!=null){//只能用在标准输入、输出流未被重定向的原始控制台中使用，在其他 IDE 的控制台是用不了的
            String username=cons.readLine("User name: ");
            char[] passe=cons.readPassword("Password: ");
            System.out.println(username);
            for(int i=0;i<passe.length;i++){
                System.out.print(passe[i]);
            }
            System.out.println();
        }else{
            System.out.printf("%,.2f",10000.0/3.0);
        }*/
//格式化输出
        System.out.printf("hello, %s .Next year youj'll be %d\n","li",10);
        //可以使用静态String.format方法创建一个格式化的字符串，而不打印输出;
        String message_format=String.format("hello, %s .Next year youj'll be %d","li",10);
        System.out.println("静态方法String.format: "+message_format);
        String dir=System.getProperty("user.dir");
        System.out.println(dir);
//文件操作
        Scanner in_file=new Scanner(Paths.get("./myfile.txt"),"UTF-8");
        String in_file_next=in_file.next();
        System.out.println(in_file_next);
//        PrintWriter out_file=new PrintWriter("./myfile.txt");//没得到预想结果
//        out_file.write(1234);
//for循环
        //见BigInteger.java
//数组
        int[] a_int=new int[age];//数字长度不要求常量,与C++区别,这里的n借用前面定义要输入的age
        //见ArraySort.java
        //多维数组见TwoArrays.java
        //不规则数组见IrregularArray.java （杨辉三角）
//静态域与静态方法
        //见StaticTest.java
//方法参数
        //见ParamTest.java
//对象构造
        // 通过在构造器第一行使用this(...)，这个构造器可以调用同一个类的另一个构造器，
        // 对于公共的构造器代码部分可以只编写一次
//抽象类
        //见PersonTest.java
        //见Person.java（抽象类）Employee_person.java  Student_person.java为子类
//泛型数组列表
        ArrayList<Integer> arrayList_int=new ArrayList<>(100);//可以指定初始容量，并非已经分配
        System.out.println("此时数组列表包含的实际元素数目为："+arrayList_int.size());//结果应该为0
        //add()添加，get()获取，set()修改，（必须有内容）remove删除
//可变参数
        //允许将一个数组传递给可变参数方法的最后一个参数
        System.out.println(max(3.1,40.4,-5.0));
//枚举类
        //见EnumTest.java
//反射
        //见ReflectionTest.java，输出类全部信息
        //见ObjectAnalyzerTest.java，ObjectAnalyzer.java，可供任意类使用的通用toString方法，
        //其中使用getDeclaredFields获得所有的数据域，然后使用setAccessible将所有的域设置为可访问，对于每个域获得名字和值
        //见CopyOfTest.java,使用反射编写泛型数组代码
        //见MethodTableTest.java,调用任意方法，最好使用接口以及lambda表达式。

//接口
        //见TimerTest.java
        //见EmployeeSortTest.java   Employee_person.java实现了接口Comparable
        //见CloneTest.java 对象克隆
//Lambda表达式
        //见LambdaTest.java
//内部类
        //见InnerClassTest.java
//异常
        //打印堆栈轨迹,见StackTraceTest.java
//集合
        //链表：见LinkedListTest.java
        //散列集：见SetTest.java
    }
    //可变参数
    public static double max(double...values){
        double largest=Double.NEGATIVE_INFINITY;
        for(double v:values) if(v>largest) largest=v;
        return largest;
    }

}
