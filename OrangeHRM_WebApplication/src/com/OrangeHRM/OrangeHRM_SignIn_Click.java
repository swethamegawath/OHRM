package com.OrangeHRM;

import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRM_SignIn_Click {

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://localhost/orangehrm-2.6/orangehrm-2.6/login.php");
		
		driver.findElementByName("txtUserName").sendKeys("admin");
		driver.findElementByName("txtPassword").sendKeys("admin");
		driver.findElementByName("Submit").click();
		
		///html/body/form/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/strong/font
		driver.switchTo().frame(driver.findElementById("rightMenu"));
		
		///html/body/div/div[2]/form/div[1]/h2
		
		String actual_header = driver.findElementByClassName("mainHeading").getText();
		String expected_header = "Employee Information";
		if(actual_header.equalsIgnoreCase(expected_header))
		{
			System.out.println("actual text is matched to expected text");
		}
		else
		{
			System.out.println("actual text is not matching with expected text");
		}
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		
		driver.findElementByLinkText("Logout").click();
		
		
		driver.close();
	}

}
