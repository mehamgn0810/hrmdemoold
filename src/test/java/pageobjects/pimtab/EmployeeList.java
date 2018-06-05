package pageobjects.pimtab;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class EmployeeList {

	WebDriver driver;
	ExtentTest test;

	@FindBy(xpath = "//input[@id='empsearch_employee_name_empName' and @class!='ac_loading']")
	WebElement empName;

	@FindBy(xpath = "//input[@id='searchBtn']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@id='search-results']//tbody//tr")
	List<WebElement> searchResults;

	@FindBy(xpath = "//div[@id='search-results']//tbody//tr//td[3]//a")
	WebElement srchRsltFName;

	@FindBy(xpath = "//div[@id='search-results']//tbody//tr//td[4]//a")
	WebElement srchRsltLName;

	public EmployeeList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmployeeName(String employeeName) throws IOException {
		empName.clear();
		empName.sendKeys(employeeName);
	}

	public void clickSearchButton() throws IOException {
		searchBtn.click();
	}

	public void verifyEmployeeExists(String employeeName) throws IOException {

		boolean found = false;

		for (@SuppressWarnings("unused")
		WebElement element : searchResults) {
			String fName = srchRsltFName.getText();
			String LName = srchRsltLName.getText();
			if (employeeName.equalsIgnoreCase(fName + " " + LName)) {
				found = true;
				break;
			}
		}
		if (!found) {
		}
	}

}
