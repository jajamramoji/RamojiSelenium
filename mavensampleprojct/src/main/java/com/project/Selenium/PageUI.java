package com.project.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;	
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUI extends Basepage
{
	//Login Page
	@FindBy(linkText="Sign in") WebElement signIn;
	@FindBy(id="email") WebElement customerEmail;
	@FindBy(id="passwd") WebElement customerPassword;
	@FindBy(id="SubmitLogin") WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]") WebElement getErrorMessage;
	
	//Registration Page
	@FindBy(id="email_create") WebElement emailCreate;
	@FindBy(id="SubmitCreate") WebElement submit;
	@FindBy(id="id_gender1") WebElement gen1;
	@FindBy(id="id_gender2") WebElement gen2;
	@FindBy(id="customer_firstname") WebElement fName;
	@FindBy(id="customer_lastname") WebElement lName;
	@FindBy(id="email") WebElement email;
	@FindBy(id="passwd") WebElement pword;
	@FindBy(id="days") WebElement DOB_day;
	@FindBy(id="months") WebElement DOB_month;
	@FindBy(id="years") WebElement DOB_year;
	@FindBy(id="company") WebElement company;
	@FindBy(id="address1") WebElement address1;
	@FindBy(id="address2") WebElement address2;
	@FindBy(id="city") WebElement city;
	@FindBy(id="id_state") WebElement state;
	@FindBy(id="postcode") WebElement postcode;
	@FindBy(id="id_country") WebElement country;
	@FindBy(id="other") WebElement AdditionalInfo;
	@FindBy(id="phone_mobile") WebElement mobile;
	@FindBy(id="alias") WebElement alias;
	@FindBy(id="submitAccount") WebElement submitAccount;
	
	public PageUI(WebDriver driver) 
	{
		//PageFactory.initElements(driver, PageUI.class);
		PageFactory.initElements(driver, this);
	}

	public void login()
	{
		signIn.click();
		customerEmail.sendKeys("ramtest02@gmail.com");
		customerPassword.sendKeys("password");
		submitLogin.click();
	}

	public String verifyError()
	{
		return getErrorMessage.getText();
	}
	
	public void customerRegistration() throws Exception
	{
		signIn.click();
		emailCreate.sendKeys(loadData("fname")+loadData("lname")+rannumber()+loadData("domain"));
		System.out.println(emailCreate.getAttribute("value"));
		submit.click();
		
		//Thread.sleep(4000);
		
		/*Explicitly 
		WebDriverWait wait=new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(gen1));*/
		
		waitForElement(60, gen1);
		
		gen1.click();
		fName.sendKeys("jajam");
		lName.sendKeys("ramoji");
		pword.sendKeys("guest");
		
		/*By using Select we will araise hardcode
		Select s=new Select(DOB_day);
		s.selectByIndex(1);*/
		
		selectItem(DOB_day, 2);
		selectItem(DOB_month, 4);
		selectItem(DOB_year, 3);
		
		//DOB_day.sendKeys("1");
		//DOB_month.sendKeys("April");
		//DOB_year.sendKeys("2010");
		address1.sendKeys("hyderabad");
		city.sendKeys("hyderabad");
		state.sendKeys("California");
		postcode.sendKeys("522601");
		country.sendKeys("United States");
		mobile.sendKeys("9154828678");
		submitAccount.click();
		
	}

	

}
