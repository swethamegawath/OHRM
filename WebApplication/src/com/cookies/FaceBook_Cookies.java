package com.cookies;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Cookie;

public class FaceBook_Cookies 
{
	WebDriver driver = null;
	String url = "http://facebook.com";
	
	@BeforeTest
	public void setup() 
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Cookie()
	{
		Set <Cookie> myCookies=driver.manage().getCookies();
		int Cookie_Count=myCookies.size();
		System.out.println("the number of cookies in the facebook application is :"+Cookie_Count);
		driver.manage().deleteAllCookies();
		myCookies = driver.manage().getCookies();
		int cookies_Count = myCookies.size();
		System.out.println("total number of cookies after deletion is :"+cookies_Count);
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}

