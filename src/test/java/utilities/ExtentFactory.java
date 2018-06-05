package utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	public static ExtentReports getInstance() {
		ExtentReports report;
		String path = "C:\\Users\\MEHAVARNAN\\git\\hrmdemo\\extentreports\\report.html";
		report = new ExtentReports(path, true);
		report.addSystemInfo("Selenium Version", "3.11");
		report.addSystemInfo("Platform", "Windows10");
		return report;
	}

}