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
import org.openqa.selenium.interactions.Actions;

public class AddEmployee_MultipleTestData {

public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver.exe");
		String url = "http://localhost/orangehrm-2.6/orangehrm-2.6/login.php";
		WebDriver driver= null;
		driver = new FirefoxDriver();  
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FileInputStream file = new FileInputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\OrangeHRM_WebApplication\\src\\com\\ExcelTestData\\AddEmployee.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("LogIn");
		XSSFSheet sheet1 = workbook.getSheet("AddEmployee");
		Row r = sheet.getRow(1);
		driver.findElement(By.name("txtUserName")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.name("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
		driver.findElement(By.name("Submit")).click();
		
		String Actual_URL=driver.getCurrentUrl();
		String Expected_URL = "http://localhost/orangehrm-2.6/orangehrm-2.6/index.php";
			
		//Validating whether OrangeHRM  application logged in successful or not
		if(Actual_URL.equals(Expected_URL))
		{
			System.out.println("Successfully navigated - PASS");
			r.createCell(2).setCellValue("PASS");
		}
		else
		{
			System.out.println("Failed to navigate");
			r.createCell(2).setCellValue("FAIL");
			
		}
		
		driver.switchTo().frame(driver.findElement(By.name("rightMenu")));
		
		int RowNums=sheet1.getLastRowNum();
		for(int i=1;i<=RowNums;i++)
		{
			Row rs=sheet1.getRow(i);
			driver.findElement(By.xpath("//*[@value='Add']")).click();
			
			driver.findElement(By.name("txtEmpLastName")).sendKeys(rs.getCell(0).getStringCellValue());
			driver.findElement(By.name("txtEmpFirstName")).sendKeys(rs.getCell(1).getStringCellValue());
			driver.findElement(By.id("btnEdit")).click();
			
			driver.findElement(By.id("btnEditPers")).click();
			
			driver.findElement(By.id("txtEmpMiddleName")).sendKeys(rs.getCell(2).getStringCellValue());
			driver.findElement(By.id("txtEmpNickName")).sendKeys(rs.getCell(3).getStringCellValue());
			
			double d=rs.getCell(4).getNumericCellValue();
			long x=(long)d;
			String SSNo = Long.toString(x);
			
			driver.findElement(By.id("txtNICNo")).sendKeys(SSNo);
			driver.findElement(By.id("txtSINNo")).sendKeys(rs.getCell(5).getStringCellValue());
			driver.findElement(By.name("btnDOB")).click();
			driver.findElement(By.id("DOB")).sendKeys(rs.getCell(6).getStringCellValue());
			driver.findElement(By.id("txtOtherID")).sendKeys(rs.getCell(7).getStringCellValue());
			driver.findElement(By.id("cmbMarital")).sendKeys(rs.getCell(8).getStringCellValue());
			driver.findElement(By.id("chkSmokeFlag")).click();
			
			String Gender = rs.getCell(9).getStringCellValue();
			if(Gender.equalsIgnoreCase("Male"))
			{
				//System.out.println("Gender is Male");
				//driver.findElement(By.xpath("//*[@value='1']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//*[@value='2']")).click();
			}
			
			
			driver.findElement(By.id("txtLicenNo")).sendKeys(rs.getCell(10).getStringCellValue());
			driver.findElement(By.id("txtLicExpDate")).sendKeys(rs.getCell(11).getStringCellValue());
			driver.findElement(By.id("txtMilitarySer")).sendKeys(rs.getCell(12).getStringCellValue());
			driver.findElement(By.id("btnEditPers")).click();
			driver.switchTo().defaultContent();
		
			Actions act = new Actions(driver);
			WebElement PIM=driver.findElement(By.linkText("PIM"));
			act.moveToElement(PIM).perform();
			driver.findElement(By.linkText("Employee List")).click();
			driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
				
			WebElement table=driver.findElement(By.className("maincontent"));
			List<WebElement> Rows=table.findElements(By.tagName("tr"));
			System.out.println(Rows.size());
			for(int j=1;j<Rows.size();j++)
			{	
		
				String ActualText = table.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr["+j+"]/td[3]/a")).getText();
				System.out.println("the ACtual text is "+ActualText);
				String ExpectedText = rs.getCell(1).getStringCellValue();
				System.out.println("the expected text is"+ExpectedText);
				if(ActualText.contains(ExpectedText))
				{
					//System.out.println("actual text contains the expected text - PASS");
					rs.createCell(13).setCellValue("actual text contains the expected text - PASS");
					//break;
				}
				else
				{
					System.out.println("actual text is not holding the expected text - FAIL");
					rs.createCell(13).setCellValue("actual text is not holding the expected text - FAIL");
				}

				FileOutputStream file1 = new FileOutputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\OrangeHRM_WebApplication\\src\\com\\Results\\Output.xlsx");
				workbook.write(file1);
				
		}
		}
	}
	
	
}
