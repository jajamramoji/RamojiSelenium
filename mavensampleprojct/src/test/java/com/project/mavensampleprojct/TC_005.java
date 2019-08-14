package com.project.mavensampleprojct;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.project.Selenium.Basepage;
import com.project.Selenium.PageUI;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.Assert;		
import org.testng.annotations.AfterMethod;

public class TC_005 extends Basepage
{
 
	PageUI page;
	
  @BeforeMethod
  public void startProcess() throws Exception 
  {
	  
	  openBrowser("chromebrowser");
	  navigate("automationurl");
  }
  
  @Test(enabled=false)
  public void automationLogin() 
  {
	  page=new PageUI(driver);
	  page.login();
	  assertEquals(page.verifyError(), "Authentication failed.");
	  
	  /*driver.findElement(By.linkText("Sign in")).click();
	  driver.findElement(By.id("email")).sendKeys("ramtest02@gmail.com");
	  driver.findElement(By.id("passwd")).sendKeys("password");
	  driver.findElement(By.id("SubmitLogin")).click();
	  String actaualValue = driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).getText();
	  String expectedValue="Authentication failed";
	  Assert.assertEquals(expectedValue, actaualValue);*/
	 
  }
  
  @Test
  public void autoRegistration() throws Exception
  {
	  page=new PageUI(driver);
	  page.customerRegistration();
  }
  

  @AfterMethod
  public void endProcess()	
  {
	  
  }

}
