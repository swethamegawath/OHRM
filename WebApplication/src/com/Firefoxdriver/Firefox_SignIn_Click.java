package com.Firefoxdriver;


import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_SignIn_Click {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		FirefoxDriver driver = new FirefoxDriver();
		
		//driver.get("http://google.com");
		
		driver.get("http://google.com");
		driver.close();
	}

}
