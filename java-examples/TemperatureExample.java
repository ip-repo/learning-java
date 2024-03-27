import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * To run this program you need to have admin privileges.
 * This example show how to use ProcessBuilder to execute a command.
 * The MSAcpi_ThermalZoneTemperature class provides information about thermal zones in a computer system
 * The command being executed retrive the Thermal zone current temperature.
 * The the ouput will be in celsius.
 */

public class TemperatureExample {
    public static void main(String[] args) {
        // The program attempt to execute a wmic command
        try {
            // Create an operating system process.
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "wmic", "/namespace:\\\\root\\wmi", "PATH",
                    "MSAcpi_ThermalZoneTemperature", "get", "CurrentTemperature"
            );

            Process process = processBuilder.start();
            // The buffer is used to retrive process output in order to able to format it.
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            int linesCounter = 0;
            // Finding the temperature line in the output and converting it to celsius.
            while ((line = reader.readLine()) != null) {
                // Assuming the second line contains the temperature value
                if (linesCounter == 2) {
                    int curTemp = Integer.parseInt(line.strip());
                    double celsiusTemp = (curTemp / 10.0) - 273.15;
                    System.out.println("Current thermal zone temperature: " + celsiusTemp  + " celsius");
                    break;
                }
                linesCounter++;
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Could not find thermal zone temperature.");

        }
    }
}
