package pageobjects.leavetab;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class LeaveCommons {
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(id="menu_leave_assignLeave")
	WebElement assignLeave;
	
	@FindBy(id="menu_leave_viewLeaveList")
	WebElement leaveList;

	public LeaveCommons(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAssignLeave() throws IOException {
		assignLeave.click();
	}
	
	public void clickLeaveList() throws IOException {
		leaveList.click();
	}

}
