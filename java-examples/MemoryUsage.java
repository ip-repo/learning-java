import java.util.Timer;
import java.util.TimerTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/** 
* This example use a timer to execute a 'systeminfo' command on windows to fetch RAM information.
* The timer is set to check for updated memory information evry half a second.
* Different hardware will produce different results so it might be better for you to set a slower execution rate.
*/
public class MemoryUsage {
	static double totalMemSizeMb;
	static double totalMemSizeGb;
	static double availMemSizeMb;
	static double availMemSizeGb;
	static int counter = 0;
	static final String ANSI_RESET = "\u001B[0m"; 
  	static final String ANSI_GREEN_BOLD = "\u001B[0;102m";
	static final String ANSI_RED_BOLD = "\u001B[0;101m";
	static final int lineSize = 40;
	
	public static void main(String[] args) {
		try {
			// This process fetch the total memory size.
			ProcessBuilder processBuilderTM = new ProcessBuilder("cmd.exe", "/c", "systeminfo | find \"Total Physical Memory\"");
			Process processTM = processBuilderTM.start();
			// The buffer is used to read to command output.
			BufferedReader readerTM = new BufferedReader(new InputStreamReader(processTM.getInputStream()));
			String totalMemoryString  = readerTM.readLine(); // Assign value to the static variable
			processTM.waitFor();
			
			// Parse output.
			String[] stringParts = totalMemoryString.split(":");
			String memoryAsNumber = stringParts[1].trim().replace(",", ""); // Remove commas and trim spaces
			
			// When the parsing of output is over we get the total size memory in mb and gb.
			totalMemSizeMb = Double.parseDouble(memoryAsNumber.split(" ")[0]);
			totalMemSizeGb = totalMemSizeMb / 1000; // Convert MB to GB.
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		// The timer task will be to get the current available memory.
		Timer timer = new Timer();
		// Schedule the task to run every half a second
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// When run is executed it will call other methods in order to update the memory information and print it to user.
				updateAvilableMemorySize();
				clearConsole();
				printMemoryInfo();	
			}
		}, 0, 500); // 500 milisecond is half a second.
	}

	public static void updateAvilableMemorySize() {
		try {
			// This process fetch the available memory size.
			ProcessBuilder processBuilderAV = new ProcessBuilder("cmd.exe", "/c", "systeminfo | find \"Available Physical Memory\"");
			Process processAV  = processBuilderAV.start();
			// The buffer is used to read to command output.
			BufferedReader readerAV = new BufferedReader(new InputStreamReader(processAV.getInputStream()));
			String availableMemoryString = readerAV.readLine();
			//Parse output
			String[] stringParts = availableMemoryString.split(":");
			String memoryAsNumber = stringParts[1].trim().replace(",", ""); // Remove commas and trim spaces
			// When the parsing of output is over we get the availbe memory size in mb and gb.
			availMemSizeMb = Double.parseDouble(memoryAsNumber.split(" ")[0]);
			availMemSizeGb = availMemSizeMb / 1000; // Convert MB to GB.
			processAV.waitFor();
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clearConsole() {
		// This method clear the output console.
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static void printMemoryInfo(){
		// This method use ansi code and print the memory information to the user.
		String lineSymbol = " ";
		String rightSymbol = " ";
		String leftSymbol = " ";
		String line = ANSI_RED_BOLD + lineSymbol.repeat(lineSize) + ANSI_RESET;
		String movingSymbolRight = " ".repeat(counter) + ANSI_GREEN_BOLD + rightSymbol + ANSI_RESET;
		String movingSymbolLeft = " ".repeat(Math.abs(lineSize - counter - 2)) + ANSI_GREEN_BOLD + leftSymbol + ANSI_RESET;
		//String memoryUsagePercentage = String.format("USAGE: %d",(availMemSizeMb / totalMemSizeMb) * 100);
		String avilMemPercent = String.format("%-20s %s","Free Memory(%):" , (float)((availMemSizeMb / totalMemSizeMb) * 100));
		String usedMemPercent = String.format("%-20s %s","Used Memory(%):" , (float)(100 - ((availMemSizeMb / totalMemSizeMb) * 100)));
		
		String gbString = String.format("%-20s %s\n%-20s %s\n%-20s %s", "Free Memory(Gb):",availMemSizeGb, "Used Memory(Gb):", (float)(totalMemSizeGb - availMemSizeGb), "Total Memory(Gb):", totalMemSizeGb);
		String mbString = String.format("%-20s %s\n%-20s %s\n%-20s %s", "Free Memory(Mb):",availMemSizeMb, "Used Memory(Mb):", (float)(totalMemSizeMb - availMemSizeMb),"Total Memory(Mb):", totalMemSizeMb);
		System.out.println(line);
		System.out.println(movingSymbolRight);
		System.out.println(line);
		System.out.println(avilMemPercent);
		System.out.println(usedMemPercent);
		System.out.println(line);
		System.out.println(mbString );
		System.out.println(line);
		System.out.println(gbString);
		System.out.println(line);
		System.out.println(movingSymbolLeft);
		System.out.println(line);

		if (counter  == lineSize  ){
			counter = 0;
		} else {
			counter++;
		}

	}
}
