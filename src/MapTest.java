import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args){
        Map<String,Employee> staff=new HashMap<>();
        staff.put("144-25-5464",new Employee("Amy Lee"));
        staff.put("567-24-2546",new Employee("Harry Hacker"));
        staff.put("157-62-7935",new Employee("Gary Cooper"));
        staff.put("456-62-5527",new Employee("Francesca Cruz"));

        System.out.println(staff);

        staff.remove("567-24-2546");

        System.out.println("456-62-5527 原先对应的值为："+staff.put("456-62-5527",new Employee("Francesca Miller")));
        System.out.println("456-62-5527 现在对应的值为："+staff.get("456-62-5527"));

        System.out.println("157-62-7935 对应的值为： "+staff.get("157-62-7935"));

        staff.forEach((k,v)->System.out.println("key="+k+",value"+v));
    }
}
