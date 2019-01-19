package com.RediffMail;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rediff_Register_CreateMyAccount {

	public static void main(String[] args) throws InterruptedException {
		
		//String CName = "Aruba";
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.linkText("Create a new account")).click();
		
		driver.findElement(By.xpath("//*[starts-with(@name,'name')]")).sendKeys("SWetha");
		

		WebElement DOB_DropDown=driver.findElement(By.xpath("//*[starts-with(@name,'DOB_Day')]"));
		List<WebElement> DOB = DOB_DropDown.findElements(By.tagName("option"));
		System.out.println("the size of DOB dropdown is :"+DOB.size());  
				
		
		/*WebElement Country=driver.findElement(By.id("country"));
		List<WebElement> Country_Size = Country.findElements(By.tagName("option"));
		System.out.println("The size of country are :"+Country_Size.size()); 
		
		
		for(int i=0;i<Country_Size.size();i++)
		{
			String CountryNames = Country_Size.get(i).getText();
			if(CountryNames.equalsIgnoreCase(CName))
			{
				Country_Size.get(i).click();
			System.out.println(i+" "+CountryNames);
			
			}
		}*/
		
		String DOBText1 = "20";
		for(int i=0;i<DOB.size();i++)
		{
				String DOB_Text = DOB.get(i).getText();
				String DOBText=DOB.get(i).getAttribute("value");
				System.out.println("THe text is : "+DOBText);
				
				if(DOBText.equals(DOBText1))
				{
					DOB.get(i).click();
					System.out.println("The option is selected");
					System.out.println(i+" "+DOB_Text);
				}
				
			}
		
			
		}
		
	}


