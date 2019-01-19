package com.OrangeHRMTesting;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OrangeHRM_Login 
{

WebDriver driver=null;
String url = "http://localhost/orangehrm-2.6/orangehrm-2.6/login.php";

@Given("^Open Firefox browser and navigate to OrangeHRM Application$")
public void Open_Firefox_browser_and_navigate_to_OrangeHRM_Application() 

{
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}

@When("^User enters valid Username and Password and click on Signin button$")
public void User_enters_valid_Username_and_Password_and_click_on_Signin_button()

{
   driver.findElement(By.name("txtUserName")).sendKeys("admin");
   driver.findElement(By.name("txtPassword")).sendKeys("admin");
   driver.findElement(By.name("Submit")).click();
   
}

@Then("^User should be able to successfully login and close the application$")
public void User_should_be_able_to_successfully_login_and_close_the_application()

{
	///html/body/div[3]/ul/li[1]
	String Actual_Text = driver.findElement(By.xpath("/html/body/div[3]/ul/li[1]")).getText();
	System.out.println("Actual text is "+Actual_Text);
	String Expected_Text="Welcome";
	if(Actual_Text.contains(Expected_Text))
	{
		System.out.println("Successfully logged into Orangehrm - PASS");
	}
	else
	{
		System.out.println("Failed to navigate - FAIL");
	}
}

}
