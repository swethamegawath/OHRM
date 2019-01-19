package com.pagesource;


import org.openqa.selenium.firefox.FirefoxDriver;

public class Identify_privacy {

	public static void main(String[] args) 
	{
		String Text = "Privacy";
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		
		String Source = driver.getPageSource();
		if(Source.contains(Text))
		{
			System.out.println("element 'privacy' is identified on web page");
		}
		else
		{
			System.out.println("element not found");
		}

	}

}
