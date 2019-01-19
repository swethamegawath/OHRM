package com.Google_Signin_Click;


import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn_Click {

	public static void main(String[] args) {
		
		String driverfile_path=System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe";
		//System.out.println(driverfile_path);
		
		System.setProperty("webdriver.chrome.driver", driverfile_path);
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		
		/*
		 <a class="gb_Pe gb_Ba gb_Mb" id="gb_70" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;
		 continue=https://www.google.com/" target="_top">Sign in</a>
		 */
		
		driver.findElementById("gb_70").click();
		
		driver.close();
		
		
	}

}
