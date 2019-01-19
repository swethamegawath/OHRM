package com.MicrosoftEdge;


import org.openqa.selenium.edge.EdgeDriver;

public class Browser_MicrosoftEdge {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\driverfiles\\MicrosoftWebDriver.exe");
		
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://livetech.in");
		
		driver.close();
	}

}
