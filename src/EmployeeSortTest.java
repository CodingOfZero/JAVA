import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args){
        Employee_person[] staff=new Employee_person[3];

        staff[0]=new Employee_person("Tom",80000,2018,6,20);
        staff[1]=new Employee_person("Dick",60000,2018,6,20);
        staff[2]=new Employee_person("Harry",70000,2018,6,20);

        Arrays.sort(staff);
        for(Employee_person e:staff)
            System.out.println("name="+e.getName()+",salary="+e.getSalary());

    }

}
