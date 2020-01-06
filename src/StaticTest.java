import java.time.LocalDate;
/**
 *This program demonstrates static methods
 */
public class StaticTest {
    public static void main(String[] args){//静态的main方法，不对任何对象进行操作
        Employee[] staff=new Employee[3];

        staff[0]=new Employee("Tom",40000,2018,6,20);
        staff[1]=new Employee("Dick",60000,2018,6,20);
        staff[2]=new Employee("Harry",70000,2018,6,20);

        for(Employee e:staff){
            e.setId();
            e.raiseSalary(5);
        }
        for(Employee e:staff){
            System.out.println("name: "+ e.getName()+" id: "+e.getId()+" salary="+e.getSalary()+" hireDay="+
                    e.getHireDay());
        }
        int n=Employee.getNextId();//注意并非是staff[0]之类的对象
        System.out.println("Next available id= "+n);
    }

}
class Employee{
    private static int nextId=1;//属于类且不属于类对象的变量
    private String name;//实例域
    private double salary;
    private int id;
    private LocalDate hireDay;
    public Employee(String n,double s,int year,int month,int day){
        name=n;
        salary=s;
        id=0;
        hireDay=LocalDate.of(year,month,day);
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return  salary;
    }
    public LocalDate getHireDay(){
        return hireDay;
    }
    /*public Date getHireDay(){//不要编写返回引用可变对象的访问器方法,Date类有一个更改器方法
        return hireDay;         //若需要返回一个可变数据域的拷贝，应该使用clone
        return (Date) hireDay.clone();//OK
    }*/
    public int getId(){
        return id;
    }
    public void setId(){
        id=nextId;
        nextId++;
    }
    public static int getNextId(){//Employee静态方法不能访问Id实例域（由于它不能操作对象），
                                // 可以访问自身类中的静态域
        return  nextId;
    }
    public void raiseSalary(double byPercent){
        double raise=this.salary*byPercent/100;//this表示隐式参数，此风格可将实例域与局部变量明显区分开来
        this.salary+=raise;
    }
    public static void main(String[] args){
        Employee e=new Employee("Harry",50000,2019,3,1);
        System.out.println(e.getName()+" "+e.getSalary());
    }

}