package com.orangehrm.hrmdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseclass.BaseTestSuite;
import pageobjects.LoginPage;
import pageobjects.TabMenu;
import utilities.Constants;

public class Test1 extends BaseTestSuite {

	LoginPage lp;
	TabMenu tm;

	@Test(priority = 0, testName = "Verify Login")
	public void login() throws Exception {
		lp = new LoginPage(driver);
		tm = new TabMenu(driver);
		driver.get(Constants.url);
		Assert.assertTrue(lp.isLoginPageLogoDisplayed());
		test.log(LogStatus.PASS, "LoginLogo Displayed");
		lp.setUserName("admin");
		lp.setPassword("admin");
		lp.clickLoginBtn();
		Assert.assertTrue(tm.isTabMenuDisplayed());
		test.log(LogStatus.PASS, "TabMenu Displayed");
		tm.isCurrentTab("Dashboard");
	}
}
