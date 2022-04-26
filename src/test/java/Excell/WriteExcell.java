package Excell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcell {
	
	public static void main(String[] args) throws IOException {
		
		
		
String excellpath = "/Users/yusan/eclipse-workspace/NewTestNgP/src/test/resources/DataFOlder/ALII.xlsx";
		
		FileInputStream file = new FileInputStream(excellpath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int lastrow = sheet.getLastRowNum();
		
		System.out.println(lastrow);
		
		for(int i = 0 ; i <=lastrow; i++) {
			
			Row row = sheet.getRow(i);
			
			
			Cell cell = row.createCell(4);
			
			cell.setCellValue("Status");
			
			//cell.setCellValue("Pass");
			
			
		}
		
		FileOutputStream str = new FileOutputStream(excellpath);
		workbook.write(str);
		
		str.close();
	}

}
