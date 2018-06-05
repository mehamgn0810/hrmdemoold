package pageobjects.leavetab;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AssignLeave {
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath = "//input[@id='assignleave_txtEmployee_empName']")
	WebElement empName;

	@FindBy(xpath = "//select[@id='assignleave_txtLeaveType']")
	WebElement leaveType;

	@FindBy(xpath = "//div[@id='assignleave_leaveBalance' and @class!='loading_message']")
	WebElement leaveBalance;
	
	@FindBy(xpath="//input[@id='assignleave_txtFromDate']")
	WebElement fromDate;
	
	@FindBy(id="ui-datepicker-div")
	WebElement fromDatePicker;
	
	@FindBy(xpath="//input[@id='assignleave_txtToDate']")
	WebElement toDate;
	
	@FindBy(id="ui-datepicker-div")
	WebElement toDatePicker;

	public AssignLeave(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmployeeName(String employeeName) {
		empName.sendKeys(employeeName);
	}

	public void selectLeaveType(String selectOption) {
		Select selLeaveType = new Select(leaveType);
		selLeaveType.selectByVisibleText(selectOption);
		test.log(LogStatus.INFO, "Select " + selectOption);
	}

	public boolean verifyLeaveBalance() throws IOException {
		String strBal = leaveBalance.getText();
		String[] arrBal = strBal.split("view");
		String leaveBal = arrBal[0];
		double dLeave = Double.parseDouble(leaveBal);
		if (dLeave > 0.00) {
			return true;
		} else {
			return false;
		}
	}
	
	public void selectFromDate(int date) throws IOException {
		fromDate.clear();
		fromDate.click();
		fromDatePicker.findElement(By.xpath("//a[text()="+date+"]")).click();
	}
	
	public void selectToDate(int date) throws IOException {
		toDate.clear();
		toDate.click();
		toDatePicker.findElement(By.xpath("//a[text()="+date+"]")).click();
	}


}
