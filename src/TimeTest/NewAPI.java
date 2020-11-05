package TimeTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class NewAPI {
    public static void main(String[] args) {
        //LocalDateTime无法与时间戳进行转换，因为LocalDateTime没有时区，无法确定某一时刻
//        LocalDate date=LocalDate.now();
//        LocalTime time=LocalTime.now();
//        //由于执行下面代码需要时间，因此秒数会有差异
//        String[] id = TimeZone.getAvailableIDs();
//        Arrays.stream(id).forEach(item->System.out.println(item));
//        LocalDateTime dateTime=LocalDateTime.now();
//
//        System.out.println(date);
//        System.out.println(time);
//        System.out.println(dateTime);
//        System.out.println("-----------------------------------------------");
//        //需要相同时间时
//        LocalDateTime dt=LocalDateTime.now();
//        System.out.println(dt);
//        System.out.println("-----------------------------------------------");
//        String[] ids = TimeZone.getAvailableIDs();
//        Arrays.stream(ids).forEach(item->System.out.println(item));
//        LocalTime dtime=dt.toLocalTime();
//        System.out.println(dtime);
//        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        System.out.println(dtf.format(LocalDateTime.now()));
//        LocalDateTime ldt=LocalDateTime.parse("2019/02/12 19:33:31",dtf);
//        System.out.println(ldt);
//
//
//        //对日期时间进行加减的链式调用
//        LocalDateTime dt=LocalDateTime.of(2020,10,26,10,23,44);
//        System.out.println(dt);
//
//        LocalDateTime dt2 = dt.plusDays(5).minusHours(3).minusMinutes(3);
//        System.out.println(dt2);
//
//        LocalDateTime dt3 = dt2.minusMonths(1);
//        System.out.println(dt3);
//        //对日期和时间进行调整则使用withXxx()方法
//        LocalDateTime dt4=dt2.withHour(23);
//        System.out.println(dt4);
//
//        // 本月第一天0:00时刻:
//        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
//        System.out.println(firstDay);
//
//        // 本月最后1天:
//        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
//        System.out.println(lastDay);
//
//        // 下月第1天:
//        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
//        System.out.println(nextMonthFirstDay);
//
//        // 本月第1个周一:
//        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
//        System.out.println(firstWeekday);
//
//        LocalDate sunDayFour=LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.SUNDAY));
//        System.out.println(sunDayFour);
//
//        //两个时刻之间的时间间隔
//        LocalDateTime start=LocalDateTime.of(2020,9,15,12,1,0);
//        LocalDateTime end=LocalDateTime.of(2020,9,15,12,6,0);
//        Duration between = Duration.between(start, end);
//        System.out.println(between);
//        //P...T之间表示日期间隔，T后面表示时间间隔
//        Period p=LocalDate.of(2020,9,15).until(LocalDate.of(2020,9,20));
//        System.out.println(p);


        //ZonedDateTime
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
        System.out.println(zbj);
        System.out.println(zny);

        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        ZonedDateTime z = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime b = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println(z);
        System.out.println(b);

        // 以中国时区获取当前时间:
        ZonedDateTime j = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        // 转换为纽约时间:
        ZonedDateTime y = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(j);
        System.out.println(y);

        //某航线从北京飞到纽约需要13小时20分钟，请根据北京起飞日期和时间计算到达纽约的当地日期和时间。
        LocalDateTime beijing=LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hour=13;
        int minutes=20;
        LocalDateTime result=beijing.atZone(ZoneId.of("Asia/Shanghai")).withZoneSameInstant(ZoneId.of("America/New_York")).plusHours(hour).plusMinutes(minutes).toLocalDateTime();
        System.out.println(beijing+"->"+result);

        //DateTimeFormatter不但是不变对象，它还是线程安全的
        //Instant 可获取高精度的时间戳
        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();
        int nano = now.getNano();
        System.out.println(epochSecond);
        System.out.println(nano);
    }
}
