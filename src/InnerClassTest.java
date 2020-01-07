
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class InnerClassTest {
    public static void main(String[] args){
        //内部类
        //TalkingClock clock=new TalkingClock(1000,true);
        //clock.start();

        //匿名内部类
        TalkingClock clock=new TalkingClock();
        clock.start(1000,true);


        //keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null,"Quit program? ");
        System.exit(0);
    }


}
/**
 * A clock that prints the time in regular intervals
 * */
//内部类示例
/*class TalkingClock{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval,boolean beep){
        this.interval=interval;
        this.beep=beep;
    }
    public void start(){
        ActionListener listener=new TimePrinter();
        Timer t=new Timer(interval,listener);
        t.start();
    }
    public class TimePrinter implements ActionListener{
        public void actionPerformed(ActionEvent event){
            System.out.println("At the tone, the time is "+new Date());
            if(beep)Toolkit.getDefaultToolkit().beep();
        }
    }

}*/
//局部内部类示例
class TalkingClock{
    /**
     * Constructs a talking clock
     * @param interval the interval between message(in milliseconds)
     * */

    /**
     * Starts the clock
     * */
//局部内部类可以访问局部变量beep,TimePrinter类会在释放beep域之前将它用start方法的局部变量进行备份
    /*public void start(int interval,boolean beep){
        class TimePrinter implements ActionListener{//局部内部类，无修饰符
            public void actionPerformed(ActionEvent event){
                System.out.println("At the tone, the time is "+new Date());
                if(beep)Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener=new TimePrinter();
        Timer t=new Timer(interval,listener);
        t.start();
    }*/

    public void start(int interval,boolean beep){
        //匿名内部类
        ActionListener listener=new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.out.println("At the tone, the time is "+new Date());
                if(beep)Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t=new Timer(interval,listener);
        t.start();
    }
}