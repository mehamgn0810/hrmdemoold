package pageobjects.pimtab;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class PIMCommons {

	WebDriver driver;
	ExtentTest test;
	
	@FindBy(id="menu_pim_addEmployee")
	WebElement addEmployee;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement employeeList;
	
	@FindBy(id="menu_core_viewDefinedPredefinedReports")
	WebElement reports;
	
	public PIMCommons(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddEmployee() throws IOException {
		addEmployee.click();
	}
	
	public void clickEmployeeList() throws IOException {
		employeeList.click();
	}
	
	public void clickReports() throws IOException {
		reports.click();
	}
	
	

}
