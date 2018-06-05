package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class TabMenu {

	WebDriver driver;
	ExtentTest test;

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement pimTab;

	@FindBy(id = "menu_dashboard_index")
	WebElement dashboardTab;

	@FindBy(xpath = "//*[@id='wrapper']//li[@class='current']//b")
	WebElement currentTab;

	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leaveTab;

	@FindBy(xpath = "//div[@class='menu']")
	WebElement tabMenu;

	public TabMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isTabMenuDisplayed() throws IOException {
		try {
			tabMenu.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void isCurrentTab(String tabName) throws IOException {

	}

	public void clickPIMTab() throws IOException {
		pimTab.click();
	}

	public void clickDashboardTab() throws IOException {
		dashboardTab.click();
	}

	public void clickLeaveTab() throws IOException {
		leaveTab.click();
	}

}
