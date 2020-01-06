import java.time.DayOfWeek;
import java.time.LocalDate;
//用来表示时间点的Date类，用来进行日历表示法的LocalDate类
public class CalendarTest {
    public static void main(String[] args){

        LocalDate date=LocalDate.now();//工厂方法
        int month=date.getMonthValue();
        int today=date.getDayOfMonth();

        date=date.minusDays(today-1);//月份第一天,minusDays(int n)生成当前日期之后或之前n天的日期,正数为之前

//        date=date.minusDays(-1);
//        System.out.println(month+"月"+today+"日");
//        System.out.println(date.getMonthValue()+"月"+date.getDayOfMonth());

        DayOfWeek weekday=date.getDayOfWeek();//得到当前日期是星期几
        int value=weekday.getValue();//得到1到7之间的一个数，1表示星期一

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for(int i=1;i<value;i++)
            System.out.print("   ");
        while(date.getMonthValue()==month){
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth()==today)
                System.out.print("*");
            else
                System.out.print(" ");
            date=date.plusDays(1);//距当前对象指定天数的一个新日期，并没有修改原先的，生成了一个新对象
            if(date.getDayOfWeek().getValue()==1) System.out.println();
        }
        if(date.getDayOfWeek().getValue()!=1) System.out.println();
    }
}
