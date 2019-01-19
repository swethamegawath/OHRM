package com.Jqueryui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Jquery_DragAndDrop {

	public static void main(String[] args) 
	
	{
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement Drag_Element=driver.findElementById("draggable");
		WebElement Drop_Element=driver.findElementById("droppable");
		
		Actions act = new Actions(driver);
		act.dragAndDrop(Drag_Element, Drop_Element).perform();
		
		driver.switchTo().defaultContent();
		
		driver.close();
		
		

	}

}
