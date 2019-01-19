package com.ChromeWebApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_SignOffLink_Click {

	public static void main(String[] args) {
		String driverfile_path=System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe";
		System.out.println(driverfile_path);
		
		System.setProperty("webdriver.chrome.driver", driverfile_path);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		
		//<input type="password" name="password" size="10">
		WebElement Element_password=driver.findElement(By.name("password"));
		Element_password.sendKeys("tutorial");
		
		/*
		<input type="image" name="login" value="Login" src="/images/btn_signin.gif?osCsid=614ec251a46b284573a7af54817a8fa9" width="58" height="17" alt="Sign-In" border="0">
		*/
		
		driver.findElement(By.name("login")).click();
		
		//<a href="mercurysignoff.php">SIGN-OFF</a>
		//driver.findElement(By.linkText("SIGN-OFF")).click();
		
		driver.findElement(By.partialLinkText("SIGN")).click();
		
		driver.close();
		

	}

}
