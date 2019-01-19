package com.TestNGAnnotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTours_LoginTest 
	{
	
	WebDriver driver = null;
	
	
		@BeforeTest
		public void setup()
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://newtours.demoaut.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void login()
		{
			driver.findElement(By.name("userName")).sendKeys("tutorial");
			driver.findElement(By.name("password")).sendKeys("tutorial");
			driver.findElement(By.name("login")).click();
			String actual_URL= driver.getCurrentUrl();
			System.out.println(actual_URL);
			String Expected_URL="http://newtours.demoaut.com/";
			if(actual_URL.contains(Expected_URL))
			{
				System.out.println("successfully navigated to newtours homw page");
				driver.findElement(By.linkText("SIGN-OFF")).click();
			}
			else
			{
				System.out.println("Failed to navigate");
			}
		}
		
		@AfterTest
		public void tearsDown() 
		{
			driver.close();
		}
		
	}