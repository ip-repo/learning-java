import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * This example show a task being executed periodically.
 * The task that is being executed flush the dns cache.
 * The user can pass a parameter when running the program.
 *java ScheduledTaskExample <time_in_ms> : defines the period time in seconds, 60000 is one minute.
 */
public class ScheduledTaskExample {
    public static void main(String[] args) {
		// If user has passed a custome time then set it else default is 10 seconds.
        long seconds;
        if (args.length == 1) {
            seconds = Long.parseLong(args[0]);
        } else {
            seconds = 10;
        }
		// Threadpool allow to execute processes safley.
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		// This process execute a cmd command to flush the dns cache.
        ProcessBuilder processBuilder = new ProcessBuilder("ipconfig", "/flushdns");
        executor.scheduleAtFixedRate(() -> {
           try { 
			   //every time a dns flush is executed then it will be logged in the file 'log.txt'
                LocalDateTime now = LocalDateTime.now();//used to log time and date.
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = now.format(formatter);        
                Process process = processBuilder.start();
                int exitCode = process.waitFor();
			   //Log the command result.
                if (exitCode == 0) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
                        writer.write(formattedDateTime + " =-=-> Successfully flushed the DNS Resolver Cache.");
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
                        writer.write(formattedDateTime + " =-=-> Something went wrong");
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, seconds, TimeUnit.SECONDS); 
    }
}
