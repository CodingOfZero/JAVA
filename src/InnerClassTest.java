
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class InnerClassTest {
    public static void main(String[] args){
        TalkingClock clock=new TalkingClock(1000,true);
        clock.start();

        //keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null,"Quit program? ");
        System.exit(0);
    }


}
/**
 * A clock that prints the time in regular intervals
 * */
class TalkingClock{
    private int interval;
    private boolean beep;
    /**
     * Constructs a talking clock
     * @param interval the interval between message(in milliseconds)
     * @param beep true if the clock should beep
     * */
    public TalkingClock(int interval,boolean beep){
        this.interval=interval;
        this.beep=beep;
    }
    /**
     * Starts the clock
     * */
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
}
