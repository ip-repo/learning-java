import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
/**
 * This exmaple show how to do a task every 2 seconds using the Timer class.
 * The task is to beep every to 2 seconds.
 * The beep sound come from awt.Toolkit.
 */
public class TimerTaskExample {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // Schedule the task to run every 2 seconds
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Toolkit.getDefaultToolkit().beep();
            }
        }, 0,  2000); // 2 seconds in milliseconds
    }
}
