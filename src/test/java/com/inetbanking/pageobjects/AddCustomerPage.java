package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
WebDriver ldriver;

public AddCustomerPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
@FindBy(how=How.XPATH,using= "//a[contains(text(),'New Customer')]")
@CacheLookup
WebElement lnkAddNewCustomer;

@FindBy(how=How.XPATH,using = "//tbody/tr[4]/td[2]/input[1]")
@CacheLookup
WebElement txtCustomerName;

@FindBy(how=How.XPATH,using = "//tbody/tr[5]/td[2]/input[2]")
@CacheLookup
WebElement rdGender;

@FindBy(how=How.XPATH,using = "//input[@id='dob']")
@CacheLookup
WebElement txtdob;

@FindBy(how=How.XPATH,using ="//tbody/tr[7]/td[2]/textarea[1]" )
@CacheLookup
WebElement txtAddress;

@FindBy(how=How.XPATH,using = "//tbody/tr[8]/td[2]/input[1]")
@CacheLookup
WebElement txtCity;

@FindBy(how=How.XPATH,using = "//tbody/tr[9]/td[2]/input[1]")
@CacheLookup
WebElement txtState;

@FindBy(how=How.XPATH,using = "//tbody/tr[10]/td[2]/input[1]")
@CacheLookup
WebElement txtPinno;

@FindBy(how=How.XPATH,using = "//tbody/tr[11]/td[2]/input[1]")
@CacheLookup
WebElement txtMobileNo;

@FindBy(how=How.XPATH,using = "//tbody/tr[12]/td[2]/input[1]")
@CacheLookup
WebElement txtEmailID;

@FindBy(how=How.XPATH,using = "//tbody/tr[13]/td[2]/input[1]")
@CacheLookup
WebElement txtPassword;

@FindBy(how=How.XPATH,using = "//tbody/tr[14]/td[2]/input[1]")
@CacheLookup
WebElement btnsubmit;



public void clickAddNewCustomer() {
lnkAddNewCustomer.click();
}

public void custName(String cname) {
txtCustomerName.sendKeys(cname);
}
public void custgender(String cgender) {
rdGender.click();
}
public void custdob(String mm, String dd, String yy) {
txtdob.sendKeys(mm);
txtdob.sendKeys(dd);
txtdob.sendKeys(yy);
}
public void custaddress(String caddress) {
txtAddress.sendKeys(caddress);
}
public void custcity(String ccity) {
txtCity.sendKeys(ccity);
}
public void custstate(String cstate) {
txtState.sendKeys(cstate);
}
public void custpinno(String cpin) {
txtPinno.sendKeys(String.valueOf(cpin));
}
public void cusrmobileno(String cmobileno) {
txtMobileNo.sendKeys(cmobileno);
}
public void custemailid(String cemailid) {
txtEmailID.sendKeys(cemailid);
}

public void custpassword(String cpassword) {
txtPassword.sendKeys(cpassword);
}

public void custsubmit( ) {
btnsubmit.click();
}

}
