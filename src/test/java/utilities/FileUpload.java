package utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload {

	public static void uploadFile(String fileName) throws Exception {
		StringSelection ss = new StringSelection(
				"C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\OrangeHRM\\pictures\\" + fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void uploadFileUsingAutoIt() throws Exception {
		
		//Not sure whether AutoIt supports parameterizing. We need to create .exe file everytime
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\OrangeHRM\\AutoIt\\uploadFile.exe");
	}
}
