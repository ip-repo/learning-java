import java.io.Console;
/**
 * This class is an example of using Console to collect a passowrd from user.
 * This example also show how to use ansi to print a colored output.
 */
public class ConsoleExample {
    //ansi color constants
    public static final String ANSI_RESET = "\u001B[0m"; //add at the end of a colored string to reset.
    public static final String ANSI_YELLOW = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
        public static void main (String[] args) {
        //create a console and ask the user a password
        Console console = System.console();
        char[] password = console.readPassword(ANSI_YELLOW + "Enter password: " + ANSI_RESET);
        console.printf(ANSI_RED + "You entered: %s%n", String.valueOf(password) +   ANSI_RESET);
        }
}
