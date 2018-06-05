package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage {

	WebDriver driver;
	ExtentTest test;

	@FindBy(id = "txtUsername")
	WebElement uName;

	@FindBy(id = "txtPassword")
	WebElement pwd;

	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@src='/webres_5786257bd7c8a5.72130757/themes/default/images/login/logo.png']")
	public WebElement loginLogo;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String userName) throws IOException {
		uName.clear();
		uName.sendKeys(userName);
	}

	public void setPassword(String password) throws IOException {
		pwd.clear();
		pwd.sendKeys(password);
	}

	public void clickLoginBtn() throws IOException {
		loginBtn.click();
	}

	public boolean isLoginPageLogoDisplayed() {
		try {
			loginLogo.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
