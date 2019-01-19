package com.ChromeWebApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newtours_Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		//<input type="text" name="userName" size="10">
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		
		//<input type="password" name="password" size="10">
		WebElement Element_password=driver.findElementByName("password");
		Element_password.sendKeys("tutorial");
		
		/*
		<input type="image" name="login" value="Login" src="/images/btn_signin.gif?osCsid=614ec251a46b284573a7af54817a8fa9" width="58" height="17" alt="Sign-In" border="0">
		*/
		
		driver.findElement(By.name("login")).click();
		
		

	}

}
