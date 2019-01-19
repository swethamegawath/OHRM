package com.OrangeHRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureData_Webtable_WriteIntoExcel {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
		
		WebDriver driver= null;
		driver = new FirefoxDriver();  
		driver.get("http://localhost/orangehrm-2.6/orangehrm-2.6/login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("txtUserName")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		
		FileInputStream file = new FileInputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\src\\com\\Excel\\Results.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
		driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
		List<WebElement> RowCount=driver.findElements(By.tagName("tr"));
		System.out.println(RowCount.size());
		sheet.createRow(RowCount.size());
		for(int i=0;i<=RowCount.size();i++)
		{
			Row Rows = sheet.createRow(i);
			List<WebElement> colums =RowCount.get(i).findElements(By.tagName("td"));
			//System.out.println(colums.size());
			for(int j=1;j<colums.size();j++)
			{
				Rows.createCell(j).setCellValue(colums.get(j).getText());
				FileOutputStream file1 =  new FileOutputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\src\\com\\Excel\\Results1.xlsx");
				workbook.write(file1);
			}
		}
		
		driver.quit();
	}

}
