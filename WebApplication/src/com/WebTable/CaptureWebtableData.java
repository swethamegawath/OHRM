package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureWebtableData
{

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
		
		for(int i=1;i<=36;i++)
		{
			for(int j=1;j<=8;j++)
			{
				String part1="/html/body/div/div[6]/section/div/section/div/div/table/tbody/tr[";
				String part2="]/td[";
				String part3 = "]";
				
				String data = driver.findElement(By.xpath(part1+i+part2+j+part3)).getText();
				System.out.print(data+"   ");
			}
			
			System.out.println();	
		}	
		driver.quit();
	}

}
