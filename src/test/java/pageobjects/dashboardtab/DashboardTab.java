package pageobjects.dashboardtab;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class DashboardTab {

	WebDriver driver;
	ExtentTest test;

	@FindBy(xpath="//img[@src='/webres_5786257bd7c8a5.72130757/orangehrmLeavePlugin/images/ApplyLeave.png']")
	WebElement assignLeave;

	public DashboardTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAssignLeave() throws IOException {
		assignLeave.click();
	}

}
