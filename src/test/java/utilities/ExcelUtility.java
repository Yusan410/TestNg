package utilities;

import java.io.FileInputStream;

import org.apache.groovy.json.internal.Exceptions;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook book;
	private static Sheet sheet;

	public static void openExcell(String filepath) {

		try {

			FileInputStream file = new FileInputStream(filepath);

			book = new XSSFWorkbook(file);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private static void sheetlaod(String sheetname) {

		sheet = book.getSheet(sheetname);
	}

	public static int rowcount() {

		return sheet.getPhysicalNumberOfRows();
	}

	public static int colcount(int rowindex) {

		return sheet.getRow(rowindex).getLastCellNum();

	}

	public static String celldata(int rowindex, int colIndex) {

		return sheet.getRow(rowindex).getCell(colIndex).toString();

	}
	
	public static Object[][] excelintoarray(String filepath,String sheetname){
		
		
		openExcell(filepath);
		
		sheetlaod(sheetname);
		
		int row =rowcount();
		
		int cols =colcount(0);
		
		Object[][] data = new Object[row-1][cols];
		
		for(int i =1; i <row;i++) {
			
			for(int j =0; j<cols;j++) {
				
				data[i-1][j] = celldata(i,j);
				
				
			}
		}
		return data;
		
	}

}
