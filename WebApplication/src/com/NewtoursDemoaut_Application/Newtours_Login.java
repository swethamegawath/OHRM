package com.NewtoursDemoaut_Application;




import org.openqa.selenium.firefox.FirefoxDriver;

public class Newtours_Login {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		//launches the firefox application
		FirefoxDriver driver = new FirefoxDriver();
		
		//navigates to newtours application
		driver.get("http://newtours.demoaut.com");
		//driver.get("http://gmail.com");
		//driver.get("http://facebook.com");
		
		//gives the size of a tagname 'a'
		int link_Count = driver.findElementsByTagName("a").size();
		
		for(int i=0;i<=link_Count;i++)
		{
			String link_Text = driver.findElementsByTagName("a").get(i).getText();
			System.out.println(link_Text);
			
		}
		
		
		
		
		
		
		
	}
}
