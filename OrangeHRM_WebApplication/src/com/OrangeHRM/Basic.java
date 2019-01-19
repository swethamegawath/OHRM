package com.OrangeHRM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basic {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
		WebDriver driver=null;
		driver = new FirefoxDriver();  
		driver.get("http://localhost/orangehrm-2.6/orangehrm-2.6/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("txtUserName")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
		
		
		//<input type="checkbox" class="checkbox" name="chkLocID[]" value="0001" onclick="unCheckMain();">
		//<input type="checkbox" class="checkbox" name="chkLocID[]" value="0001" onclick="unCheckMain();">
		//<input type="checkbox" class="checkbox" name="chkLocID[]" value="0005" onclick="unCheckMain();">
		//allCheck
		
		
		
		
		//	Thread.sleep(5000);
		//below code will click on the checkbox  which will select all checkbox from webtable
			//driver.findElement(By.id("allCheck")).click();
		
		//here it counts thenumber of  rows and select checkboxes one by one 
				WebElement table=driver.findElement(By.className("maincontent"));
				List<WebElement> Rows=driver.findElements(By.xpath("//*[@id='standardView']/table/tbody/tr"));
				for(int i=1;i<=Rows.size();i++)
				{
					driver.findElement(By.xpath("//*[@id='standardView']/table/tbody/tr["+i+"]/td[1]/input")).click();
				}
		
		
				
		//select Emp iD from the list
		//driver.findElement(By.id("loc_code")).sendKeys("Emp ID");
		 
		//Enter sprcific emp id which we want to delete
		driver.findElement(By.id("loc_name")).sendKeys("0008");
		driver.findElement(By.xpath("//*[@value='Search']")).click();
		
		String Message = driver.findElement(By.xpath("//*[@id='standardView']/div[3]/div[2]")).getText();
		 		
		 		
		 //It checks the condition whether webtable have any record with that specific id or not and if it have any records it goes into the else condition		
		  if(Message.equals("No Records to Display"))
		  {
			  System.out.println(Message);
		  }
		  else
		  {
			  WebElement Table=driver.findElement(By.className("maincontent"));
			  Table.findElement(By.xpath("//*[@onclick='unCheckMain();']")).click();
			  driver.findElement(By.xpath("//*[@onclick='returnDelete();']")).click();
			  String Message1=driver.findElement(By.xpath("//*[@id='standardView']/div[2]/span")).getText();
			  System.out.println("passed message is "+Message1); 
		  }
		  driver.switchTo().defaultContent();
		 driver.findElement(By.linkText("Logout")).click();
		 driver.close();
		
	}

}
