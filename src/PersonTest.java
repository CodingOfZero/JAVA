
public class PersonTest {
    public static void main(String[] args){
        Person[] people=new Person[2];

        people[0]=new Employee_person("Harry Hacker",50000,1989,10,1);
        people[1]=new Student_person("Maria","computer science");

        for(Person p:people)
           System.out.println(p.getName()+","+p.getDescription());
        //p.getDescription()由于不能构造抽象类Person的对象，所以变量p永远不会引用Person对象
        System.out.println(people[0]);
    }
}
