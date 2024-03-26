import javax.swing.JOptionPane;
/**
 * This example use the System class to retrive some info about the system.
 * Then with the help a JOptionPane the output appear in a window.
 */
public class SystemInfoPop {
	public static void main (String[] args) {
		System.getProperties();
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		String osArch = System.getProperty("os.arch");
	    JOptionPane.showMessageDialog(null,"Os: " + osName + osVersion + "\n" + "Arch: " + osArch);
	}
}
