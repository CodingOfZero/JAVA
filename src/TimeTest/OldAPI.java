package TimeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 旧的API
 * 定义在java.util这个包里面，主要包括Date、Calendar和TimeZone这几个类；
 * Month Week的常量设计反人类
 */
public class OldAPI {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        //它不能转换时区，除了toGMTString()可以按GMT+0:00输出外，Date总是以当前计算机系统的默认时区为基础进行输出。
        // 此外，我们也很难对日期和时间进行加减，计算两个日期相差多少天，计算某个月第一个星期一的日期等。
        Date date=new Date();
        System.out.println(date.getTime());

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        //可以用于获取并设置年、月、日、时、分、秒，它和Date比，主要多了一个可以做简单的日期和时间运算的功能。
        Calendar calendar=Calendar.getInstance();
        int i = calendar.get(Calendar.YEAR);
        System.out.println("year:"+i);
        System.out.println(calendar.getTime());


        //
        TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York"); // 纽约时区
        System.out.println(tzDefault.getID()); // Asia/Shanghai
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York

        //列出当前时区
//        String[] id = TimeZone.getAvailableIDs();
//        Arrays.stream(id).forEach(System.out::println);


        // 当前时间:
        Calendar c = Calendar.getInstance();
        // 清除所有:
        c.clear();
        // 设置为北京时区:
        c.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 设置年月日时分秒:
        c.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
        // 显示时间:
        DateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        s.setTimeZone(TimeZone.getTimeZone("America/New_YosetTimeZonerk"));
        System.out.println(sdf.format(c.getTime()));
    }
}
