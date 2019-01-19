package com.NewtoursDemoaut_Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Login_FlightConfirmation	
{
	WebDriver driver= null;
	
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=0)
	public void Login() throws IOException
	{
		FileInputStream file1 = new FileInputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\NewTours.Properties");
		Properties pr= new Properties();
		pr.load(file1);
		
		
		driver.findElement(By.name(pr.getProperty("UserID"))).sendKeys("tutorial");
		driver.findElement(By.name(pr.getProperty("Password"))).sendKeys("tutorial");
		driver.findElement(By.name(pr.getProperty("LogIn"))).click();
		String actual_url = driver.getCurrentUrl();
		System.out.println("Actual url is "+actual_url);
		String Expected_url="http://newtours.demoaut.com/";
		if(actual_url.equals(Expected_url))
		{
			System.out.println("successfully navigated to login page");
		}
		else
		{
			System.out.println("Failed to navigate to Newtours login page");
		}
	}
	
	@Test(priority=1)
	public void BookingTicket() throws InterruptedException, IOException
	{
		FileInputStream file1 = new FileInputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\NewTours.Properties");
		Properties pr = new Properties();
		pr.load(file1);
		
		Thread.sleep(8000);
		driver.findElement(By.xpath(pr.getProperty("Oneway"))).click();
		driver.findElement(By.name(pr.getProperty("Passengers"))).sendKeys("2");
		driver.findElement(By.name(pr.getProperty("From"))).sendKeys("London");
		driver.findElement(By.name(pr.getProperty("onMonth"))).sendKeys("May");
		driver.findElement(By.name(pr.getProperty("onDate"))).sendKeys("04");
		driver.findElement(By.name(pr.getProperty("ArrivingTo"))).sendKeys("Paris");
		driver.findElement(By.name(pr.getProperty("ToMonth"))).sendKeys("July");
		driver.findElement(By.name(pr.getProperty("ToDate"))).sendKeys("14");
		driver.findElement(By.xpath(pr.getProperty("RadioEconomy"))).click();
		driver.findElement(By.name(pr.getProperty("Airline"))).sendKeys("Unified Airlines");
		driver.findElement(By.name(pr.getProperty("Continue"))).click();
		String actual_pagetitle=driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/font/b/font")).getText();
		String expected_pagetitle="DEPART";
		if(actual_pagetitle.equals(expected_pagetitle))
		{
			System.out.println("Page successfully navigated to Depart details - PASS");
		}
		else
		{
			System.out.println("Page failed to navigate to depart details - FAIL");
		}
	}
	
	@AfterTest(enabled=false)
	public void Teardown()
	{
		driver.close();
	}
	
	
}

