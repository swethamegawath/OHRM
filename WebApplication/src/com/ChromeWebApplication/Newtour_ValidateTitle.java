package com.ChromeWebApplication;

import org.openqa.selenium.chrome.ChromeDriver;


public class Newtour_ValidateTitle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/");
		
		String actual_Title=driver.getTitle();
		System.out.println(actual_Title);
		
		String expected_Title="Mercury";
		
		if (actual_Title.contains(expected_Title))
		{
			System.out.println("Title Validation is PASS");
		}
		else
		{
			System.out.println("Title Validation is FAIL");
		}
		
		driver.close();
		

	}

}
