package com.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot1 {

	public static void main(String[] args) throws InterruptedException, IOException
	{

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://bing.com");
		
		Thread.sleep(3000);
		
		File ScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenShot, new File ("C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\screenshots\\Image3.png"));
		
		driver.close();
	}

}
