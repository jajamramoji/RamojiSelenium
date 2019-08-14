package com.project.Selenium;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.pattern.PropertiesPatternConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Basepage {
	
	private static final Logger log=Logger.getLogger(Basepage.class.getClass());
	public static WebDriver driver;
	public static final String path="./data.properties";
	
	public static String loadData(String key) throws Exception
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(path);
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	public static void lanch(String browser, String url) {
		
		
		
		driver.get(url);
	}
	
	public static boolean isElementPresent(String locatorKey) throws Exception {
		List<WebElement> element=null;
		if(locatorKey.endsWith("_id"))
			element=driver.findElements(By.id(loadData(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			element=driver.findElements(By.name(loadData(locatorKey)));
		else if(locatorKey.endsWith("_xpath"))
			element=driver.findElements(By.xpath(loadData(locatorKey)));
		else if(locatorKey.endsWith("linktext"))
			element=driver.findElements(By.linkText(loadData(locatorKey)));
		
		if(element.size()==0)
			return false;
		else
			return true;
	}

	
	public static boolean verifyText(String locatorKey, String expectedvalue) throws Exception {
		
		String actvalue = getElement(locatorKey).getText().trim();
		System.out.println("Actual value : "+actvalue);
		System.out.println("Expected value : "+loadData(expectedvalue));
		if(actvalue.equalsIgnoreCase(loadData(expectedvalue)))
			return true;
		else
			return false;
	}

	
	
	public static void click(String locatorKey) throws Exception {
		
		driver.findElement(By.xpath(loadData(locatorKey))).click();
		
		
	}

	public static void type(String locatorKey, String valueKey) throws Exception {
		
		//driver.findElement(By.name(loadData(locatorKey))).sendKeys(loadData(valueKey));
		getElement(locatorKey).sendKeys(loadData(valueKey));
		
	}

	private static WebElement getElement(String locatorKey) throws Exception {
		
		WebElement e=null;
		if(locatorKey.endsWith("_id"))
			e=driver.findElement(By.id(loadData(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			e=driver.findElement(By.name(loadData(locatorKey)));
		else if(locatorKey.endsWith("_xpath"))
			e=driver.findElement(By.xpath(loadData(locatorKey)));
		else if(locatorKey.endsWith("linktext"))
			e=driver.findElement(By.linkText(loadData(locatorKey)));
		else
			//System.out.println("No locator is matching......");
			reportFailure("No locator is matching......"+loadData("locatorKey"));
		
		return e;
		
	}

	public static void reportFailure(String msg) throws Exception {
		takeScreenShot();
		log.info(msg);
		
	}

	public static void takeScreenShot() throws Exception {
		
		Date dt=new Date();
		String fineName = dt.toString().replace(":", "_").replace(" ", "_")+".jpeg";
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\jajamramoji.rao\\Desktop" + dateFormat));
		org.openqa.selenium.io.FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"//Failure//"+fineName));
		
	}

	public static void navigate(String urlKey) throws Exception {
		
		driver.get(loadData(urlKey));
	}

	public static void openBrowser(String browser) throws Exception {
	//	System.out.println(browser);
	//	System.out.println(loadData(browser));
		
		if(loadData(browser).equalsIgnoreCase("CHROME"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(loadData(browser).equalsIgnoreCase("FF"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(loadData(browser).equalsIgnoreCase("IE"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(loadData(browser).equalsIgnoreCase("EDGE"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}
		
		/*For Implicit script level
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);*/
		
		String path = "./data.properties";
		/*driver.manage().window().maximize();
		String path = "./data.properties";
		String path1 = "./log4j.properties";
		PropertyConfigurator.configure(path);
		PropertyConfigurator.configure(path1);*/
	}
	
	public static void close()
	{
		driver.quit();
	}
	
	public void waitForElement(int timeInSeconds,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//By using below method you can call directly values using SELECT
	public void selectItem(WebElement element, int value)
	{
		Select s=new Select(element);
		s.selectByIndex(value);
	}
	
	public Integer rannumber() 
	{
		Random r=new Random();
		int rnum= r.nextInt(8888);
		return rnum;
	}

}
