package com.ticketonline.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	 XSSFWorkbook wb;
	
	public ExcelDataProvider(){
		
		File src = new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("error while xcel upload"+e.getMessage());
			
		}
	}
	
	public String getstringdata(int sheetindex, int row,int column ){
		return	wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
			
		}
	
	public String getstringdata(String login, int row,int column ){
	return	wb.getSheet("Login").getRow(row).getCell(column).getStringCellValue();
		
	}

	
	public double getnumeric(String login, int row,int column ){
		return	wb.getSheet("Login").getRow(row).getCell(column).getNumericCellValue();
			
		}
	
	//public String writedata(int sheetindex, int row,int column ){
		
		//wb.getSheetAt(sheetindex).getRow(row).getCell(column);
		
		//return null;
		
	//}
	
	
	
	
}
