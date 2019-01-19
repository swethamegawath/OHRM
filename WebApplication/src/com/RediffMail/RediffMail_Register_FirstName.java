package com.RediffMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RediffMail_Register_FirstName {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		String actual_Title =driver.getTitle();
		System.out.println(actual_Title);
		
		String expected_Title = "Rediffmail";
		
		if(actual_Title.contains(expected_Title))
		{
			System.out.println("Title matched");
		}
		else
		{
			System.out.println("Title not matched");
		}
		
		WebElement NewAccount = driver.findElement(By.linkText("Create a new account"));
		
		NewAccount.click();
		
		
		String actual_Text = driver.findElement(By.xpath("//*[@id=\'tblcrtac\']/tbody/tr[1]/td")).getText();
		
		String expected_Text = "Create a Rediffmail account";
		
		if (actual_Text.equalsIgnoreCase(expected_Text))
		{
			System.out.println("Create a Rediffmail account page is displayed");
		}
		else
		{
			System.out.println("Create a Rediffmail account page is not displayed");
		}
		
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("swetha");
		
		/*Actions act =  new Actions(driver);
		
		act.sendKeys(Keys.CLEAR).perform();
		act.sendKeys("Swetha").perform();
		*/
		
		
		driver.close();
		
	}

}
