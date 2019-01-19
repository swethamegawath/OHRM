package com.Monster_Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Monster_Dropdown_Select {

	public static void main(String[] args) throws InterruptedException
	
	{
		String Url = "https://my.monsterindia.com/sponsered_popup.html";
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(Url);
		
		WebElement CurrentLocation=driver.findElement(By.className("border_grey1"));
		//CurrentLocation.sendKeys("Ahmedabad");
		Select Selection = new Select(CurrentLocation);     //TypeCasting
		Thread.sleep(1000);
		Selection.selectByIndex(0);
		Thread.sleep(1000);
		Selection.selectByValue("6");
		Thread.sleep(1000);
		Selection.selectByVisibleText("Delhi");
		
		
		//id_industry
		WebElement Industry=driver.findElement(By.id("id_industry"));
		Select Sel = new Select(Industry);
		Sel.selectByIndex(1);
		Sel.selectByValue("4");
		Sel.selectByVisibleText("Banking/ Financial Services");
		
		Sel.deselectByIndex(0);
		Sel.deselectByValue("4");
		Sel.deselectAll();

	}

}
