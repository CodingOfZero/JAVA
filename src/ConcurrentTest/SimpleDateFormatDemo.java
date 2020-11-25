package ConcurrentTest;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDateFormatDemo {
    //SimpleDateFormat是线程不安全的，以下例子为多个线程共用同一个实例，会抛出异常
//    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    public static void main(String[] args) {
//        for(int i=0;i<20;i++){
//            Thread thread=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(sdf.parse("2017-12-13 15:17:22"));
//                    }catch (ParseException e){
//                        e.printStackTrace();
//                    }
//                }
//            });
//            thread.start();
//        }
//    }
    //其中一种解决办法使用ThreadLocal
    private static ThreadLocal<SimpleDateFormat> sdf=new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

//        private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(sdf.get().parse("2017-12-13 15:17:22"));
                    }catch (ParseException e){
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
