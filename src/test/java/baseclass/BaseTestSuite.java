package baseclass;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ExtentFactory;

public class BaseTestSuite {
	
	protected WebDriver driver;
	protected ExtentReports report;
	protected ExtentTest test;
	

	@BeforeClass
	public void beforeClass() {
		report = ExtentFactory.getInstance();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		Test xtest = method.getAnnotation(Test.class);
		test = report.startTest(xtest.testName());
	}

	@AfterMethod
	public void afterMethod() {
		report.endTest(test);
		report.flush();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
