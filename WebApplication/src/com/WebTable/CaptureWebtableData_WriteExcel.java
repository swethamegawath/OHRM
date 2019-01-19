package com.WebTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureWebtableData_WriteExcel {

	public static void main(String[] args) throws IOException 
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FileInputStream file = new FileInputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\src\\com\\Excel\\Results.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		
		WebElement table = driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody"));
		List<WebElement> Rows = table.findElements(By.tagName("tr"));
		System.out.println(Rows.size());
		sheet.createRow(Rows.size());
		for(int i=0;i<Rows.size();i++)
			
		{	
			Row ExcelRow = sheet.createRow(i);
			List<WebElement> ColumCount = Rows.get(i).findElements(By.tagName("td"));
			System.out.println(ColumCount.size());
			for(int j=0;j<ColumCount.size();j++)
			{
				ExcelRow.createCell(j).setCellValue(ColumCount.get(j).getText());
				FileOutputStream file1 = new FileOutputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\src\\com\\Excel\\Results3.xlsx");
				workbook.write(file1);
				
			}
		}
		
		driver.quit();	
	}
	
}
