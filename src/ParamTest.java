/**
 * This program demonstrates parameter passing in Java
 * java中方法参数使用情况
 * 一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）
 * 一个方法可以改变一个对象参数的状态
 * 一个方法不能让对象参数引用一个新的对象
 */
public class ParamTest {//java实际上采用值传递（call by value）
    public static void main(String[] args){
        /*
        *Test 1:Methods can't modify numeric parameters
        */
        System.out.println("Testing tripleValue: ");
        double percent=10;
        System.out.println("Before percent="+percent);
        tripleValue(percent);
        System.out.println("After: percent="+percent);
        /*
         *Test 2:Methods can change the state of object  parameters
        */
        System.out.println("\nTesting tripleSalary:");
        Employee harry=new Employee("Harry",50000,2019,2,1);
        System.out.println("Before: salary="+harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary="+harry.getSalary());
        /*
         *Test 3:Methods can't attach new objects to object  parameters
         * 对象引用是按值传递的
        */
        System.out.println("\nTesting swap:");
        Employee a=new Employee("Alice",70000,2019,1,2);
        Employee b=new Employee("Bob",60000,2019,1,2);
        System.out.println("Before: a="+a.getName());
        System.out.println("Before: b="+b.getName());
        swap(a,b);
        System.out.println("After: a="+a.getName());
        System.out.println("After: b="+b.getName());
    }
    public static void tripleValue(double x){//doesn't work
        x=3*x;
        System.out.println("End of method: x= "+x);
    }
    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
        System.out.println("End of method: salary="+x.getSalary());
    }
    public static void swap(Employee x,Employee y){
        Employee temp=x;
        x=y;
        y=temp;
        System.out.println("End of method x="+x.getName());
        System.out.println("End of method y="+y.getName());
    }

}
