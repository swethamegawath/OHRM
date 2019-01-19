package com.ChromeWebApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newtour_ValidateURL {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\driverfiles\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		
		String actual_url=driver.getCurrentUrl();
		System.out.println(actual_url);
		
		String expected_url="http://newtours.demoaut.com/";
		
		if(actual_url.equals(expected_url))
		//if(actual_url.equalsIgnoreCase(expected_url))
		{
			System.out.println("Url is matched - PASS");
		}
		else
		{
			System.out.println("url is not matched - FAIL");
		}
		
		driver.quit();
	}

}
