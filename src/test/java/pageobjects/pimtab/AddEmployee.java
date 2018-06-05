package pageobjects.pimtab;

import static utilities.FileUpload.uploadFileUsingAutoIt;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class AddEmployee {
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(id="firstName")
	WebElement fName;
	
	@FindBy(id="lastName")
	WebElement lName;
	
	@FindBy(id="btnSave")
	WebElement saveBtn;
	
	@FindBy(id="photofile")
	WebElement photograph;

	public AddEmployee(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstNameLastName(String firstName, String lastName) throws IOException {
		fName.clear();
		fName.sendKeys(firstName);
		lName.clear();
		lName.sendKeys(lastName);
	}
	
	public void clickSaveButton() throws IOException {
		saveBtn.click();
	}
	
	public void choosePhoto(String fileName) throws Exception {
		photograph.click();
		//uploadFile(fileName);
		uploadFileUsingAutoIt();
	}
}
