package com.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Login

{
	String url = "http://localhost/orangehrm-2.6/orangehrm-2.6/login.php";
	WebDriver driver = null;

	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\geckodriver.exe");
		
		driver= new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void OrangeHRM_Login() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\OrangeHRM_WebApplication\\src\\com\\ExcelTestData\\Book2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		FileInputStream file2 = new FileInputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\OrangeHRM_WebApplication\\Orangehrm.Properties");
		Properties pr= new Properties();
		pr.load(file2);
		
		int RowCount=sheet.getLastRowNum();
		for(int i=0;i<=RowCount;i++)
		{
			Row r=sheet.getRow(i);
			
			driver.findElement(By.name(pr.getProperty("UserName"))).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.name(pr.getProperty("Password"))).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.name(pr.getProperty("Login"))).click();
			
						
			String Actual_URL=driver.getCurrentUrl();
			//System.out.println(Actual_URL);
			String Expected_URL = "http://localhost/orangehrm-2.6/orangehrm-2.6/index.php";
			
			
			
			if(Actual_URL.equals(Expected_URL))
			{
				System.out.println("Successfully navigated - PASS");
				r.createCell(2).setCellValue("PASS");
				driver.findElement(By.linkText("Logout")).click();
			}
			else
			{
				System.out.println("Failed to navigate");
				r.createCell(2).setCellValue("FAIL");
				File Screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
				FileUtils.copyFile(Screenshot2,new File("C:\\Users\\Megawath\\Desktop\\selenium project\\OrangeHRM_WebApplication\\Screenshot\\image"+i+""+i+".png"));
			}
			
			FileOutputStream file1 = new FileOutputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\OrangeHRM_WebApplication\\src\\com\\ExcelTestData\\Book2.xlsx");
			workbook.write(file1);
			driver.navigate().back();

	}
}
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}

