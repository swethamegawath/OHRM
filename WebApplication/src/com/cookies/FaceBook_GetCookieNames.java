package com.cookies;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FaceBook_GetCookieNames 
{
	
	WebDriver driver = null;
	String url = "http://facebook.com";
	
	@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Cookies()
	{
		Set <Cookie> myCookie=driver.manage().getCookies();
		int Cookie_Count=myCookie.size();
		System.out.println("number of cookies in facebook application is :"+Cookie_Count);
		Iterator <Cookie> IT =myCookie.iterator();
		while(IT.hasNext())
		{
			Cookie c=IT.next();
			System.out.println(c.getDomain()+" "+c.getName());
		}
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}
