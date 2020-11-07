package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	
@Test
	public void loginTest() throws IOException {
		logger.info("url is opened");
		LoginPage lp=new LoginPage(driver);
lp.setUserName(username);
logger.info("username entered");
lp.setPassword(password);
logger.info("password is entered");
lp.clickSubmit();
if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
	Assert.assertTrue(true);
	logger.info("logintest passed");
}
	else{
		captureScreenshot( driver, "loginTest");
	Assert.assertTrue(false);
	logger.info("logintest failed");

	}
}
}
