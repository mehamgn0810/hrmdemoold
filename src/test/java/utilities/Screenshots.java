package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class Screenshots {

	public static String takeScreenshot(WebDriver driver, ExtentTest test) throws IOException {

		String timeStamp = new SimpleDateFormat("HH-mm-ss").format(new Date());
		String directory = "C:\\Users\\MEHAVARNAN\\Documents\\eclipse-workspace\\hrmdemo\\Screenshots\\";
		String fileName = timeStamp + ".png";
		File destFile = new File(directory + fileName);
		TakesScreenshot ss = (TakesScreenshot) driver;
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, destFile);
		String imgPath = test.addScreenCapture(directory + fileName);
		return imgPath;
	}
	
	

}
