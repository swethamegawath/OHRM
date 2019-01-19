package basicProgram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Gmail_Login 
{
	WebDriver driver=null;
	String url = "http://gmail.com";
	@BeforeTest
	public void setup() 
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void gmail_Login()
	{
		driver.findElement(By.id("identifierId")).sendKeys("swetha90");
		/*Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();*/
		///html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span")).click();
		
		//ZFr60d CeoRYc
		//RveJvd snByac
	}
}


















