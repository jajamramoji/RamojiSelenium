package com.project.mavensampleprojct;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.project.Selenium.Basepage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC_004 extends Basepage

{
  
  @BeforeMethod
  @Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	  openBrowser(btype);
	  navigate("amazonurl");
  }
  
  @Test
  public void amazon() throws Exception 
  {
	  type("amazonsearchtextbox_id", "textvalue");
	  click("amazonsearchbutton_xpath");
  }

  @AfterMethod
  public void endProcess() 
  {
	  close();
  }

}
