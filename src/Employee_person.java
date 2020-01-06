import java.time.LocalDate;

public class Employee_person extends Person{
    private double salary;
    private LocalDate hireDay;
    public Employee_person(String name,double salary,int year,int month,int day){
        super(name);
        this.salary=salary;
        hireDay=LocalDate.of(year,month,day);
    }
    public double getSalary(){
        return salary;
    }
    public LocalDate getHireDay(){
        return hireDay;
    }
    public String getDescription(){
        return String.format("an employee with a salary of $%.2f",salary);
    }
    public void raiseSalary(double byPercent){
        double raise=this.salary*byPercent/100;//this表示隐式参数，此风格可将实例域与局部变量明显区分开来
        this.salary+=raise;
    }
    public String toString(){
        return getClass().getName()+"[name="+super.getName()+",salary="+salary+",hireDay="+hireDay+"]";
    }
}
