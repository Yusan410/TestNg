package Excell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.ConTanst;
import utilities.ExcelUtility;



public class Excell_teSt {
	
	public static void main(String[] args) throws IOException {
		
		String excellpath = ConTanst.excel_path;
		
		
		
		FileInputStream file = new FileInputStream(excellpath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		Row row = sheet.getRow(0);
		
		Cell cell = row.getCell(0);
		
		//System.out.println("1- "+sheet.getRow(0).getCell(0));
		
		
		DataFormatter object =new  DataFormatter();
		
		for(Row row1:sheet) {
			
			for(Cell cell1:row1) {
				
				String cellvalue = object.formatCellValue(cell1);
				
				System.out.print("   |  "+cellvalue );
			}
			
			System.out.println();
		}
			
	}
	
	
	

}
