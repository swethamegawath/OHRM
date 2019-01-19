package com.ExcelOperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_ReadOperation_MultipleData {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("C:\\Users\\Megawath\\Desktop\\selenium project\\WebApplication\\src\\com\\Excel\\Book2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int RowCount = sheet.getLastRowNum();
		for (int i=1;i<=RowCount;i++)
		{
			Row r=sheet.getRow(i);
			//System.out.println("The number of rows in Excel Sheet is"+RowCount);
			//Cell c=r.getCell(0);
			int CellCount = r.getLastCellNum();
			//System.out.println("THe number of Cells in every rows"+CellCount);
			for(int k=0;k<CellCount;k++)
			{
				Cell c=r.getCell(k);
				String Data = c.getStringCellValue();
				System.out.print(Data+" ");
			}
			System.out.println();
		}
	}

}
