import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.MouseInfo;
import java.awt.Point;
/**
 * This example use a timer to save mouse position to a csv file.
 * The new mouse position is being appended to the csv file every 1 second.
 */

public class MousePositionCsv {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // Schedule the task to run every 2 seconds
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
				//get current Mouse location.
                Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
            
				int x = (int) mouseLocation.getX();
				int y = (int) mouseLocation.getY();
				// Mouse position will be saved to a csv file named 'mouse-coordiantes'.
				String fileName = "mouse-coordiantes.csv";
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentDate = dateFormat.format(new Date());
				
				try {
					// Create a FileWriter in append mode
					FileWriter fw = new FileWriter(fileName, true);
					// Write the data to the CSV file
					fw.append(String.format("%d,%d,%s\n", x, y, currentDate));
		
					// Close the FileWriter
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

        
            }
        }, 0,  1000); // 1 second in milliseconds
    }
}
