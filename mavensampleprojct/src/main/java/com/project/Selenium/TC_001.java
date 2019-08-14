/*package com.project.Selenium;

import org.apache.log4j.Logger;

//BasicConfigurator.configure();	
public class TC_001 extends Basepage {
	
	private static final Logger log=Logger.getLogger(TC_001.class.getName());
	
	public static void main(String[] args) throws Exception 
	{
		
		openBrowser("chromebrowser");
		log.info("Opened the browser of :- " +loadData("chromebrowser"));
		//System.out.println("Opened the browser of :- "+loadData("chromebrowser"));
		
		//navigate("amazonurl");
		log.info("Navigated URL is :-"+loadData("amazonurl"));
		//System.out.println("Navigated URL is :-"+loadData("amazonurl"));
		
		//type("amazonsearchtextbox_name","textvalue");
		log.info("Entered search text load data :- "+ loadData("textvalue") + "by using locator :-" + loadData("amazonsearchtextbox_name"));
		//System.out.println("Entered search text load data :- "+ loadData("textvalue") + "by using locator :-" + loadData("amazonsearchtextbox_name"));
		
		click("amazonsearchbutton_xpath");
		log.info("Clicked on amazon search button by using locate" + loadData("amazonsearchbutton_xpath"));
		//System.out.println("Clicked on amazon search button by using locate" + loadData("amazonsearchbutton_xpath"));
		
					
		openBrowser("chromebrowser");
		
		navigate("amazonurl");
		
		type("amazonsearchtextbox_id", "textvalue");
		
		click("amazonsearchbutton_xpath");
	

	}

}
*/