package baseclass;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageobjects.LoginPage;
import pageobjects.TabMenu;
import utilities.ExtentFactory;

public class BaseTestSuite_Grid {

	protected WebDriver driver;
	protected ExtentReports report;
	protected ExtentTest test;
	protected String nodeUrl;
	
	protected LoginPage lp;
	protected TabMenu tm;

	@Parameters({"browser", "version", "platform"})
	@BeforeClass
	public void beforeClass(String browser, String version, String platform) throws Exception {
		report = ExtentFactory.getInstance();
		
		driver = getDriverInstance(browser, version, platform);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}

	public WebDriver getDriverInstance(String browser, String version, String platform) throws MalformedURLException {
		nodeUrl = "http://192.168.2.37:5555/wd/hub";
		driver = null;

		DesiredCapabilities caps = new DesiredCapabilities();

		// platform
		if (platform.equalsIgnoreCase("linux")) {
			caps.setPlatform(Platform.LINUX);
		} else if (platform.equalsIgnoreCase("windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}

		// browser
		if(browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}else if(browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		
		//caps.setVersion(version);
		driver = new RemoteWebDriver(new URL(nodeUrl), caps);

		return driver;
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
