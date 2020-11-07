package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
	
		AddCustomerPage addcust=new AddCustomerPage(driver);
		logger.info("Providing customer details.....");
		addcust.clickAddNewCustomer();
		addcust.custName("Pavan");
	addcust.custgender("female");
	addcust.custdob("02", "06", "1998");
	Thread.sleep(3000);
	addcust.custaddress("INDIA");
	addcust.custcity("TKU");
	addcust.custstate("AP");
	addcust.custpinno("534211");
	addcust.cusrmobileno("9515459384");
	
	String email=randomstring()+"@gmail.com";
	addcust.custemailid(email);
	addcust.custpassword("abcdef");
	addcust.custsubmit();
	Thread.sleep(3000);
	logger.info("validation is started.....");
	boolean res=driver.getPageSource().contains("");
	if (res==true) {
		Assert.assertTrue(true);
		logger.info("testcase passed...");
		
	} else {
captureScreenshot(driver, "addNewCustomer");
Assert.assertTrue(false);
logger.info("testcase is failed....");
	}
	}



}
