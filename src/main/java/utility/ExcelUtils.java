package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	private static XSSFWorkbook excelWorkBook;
	private static XSSFSheet excelSheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static Object[][] getTableArray(String filePath, String sheetName){
		String tabArray[][]=null;
		try {
			FileInputStream excelFile=new FileInputStream(filePath);
			excelWorkBook=new XSSFWorkbook(excelFile);
			excelSheet=excelWorkBook.getSheet(sheetName);
			int startRow=1;
			int startCol=1;
			
			int totalRows=excelSheet.getLastRowNum();
			int totalCols=2;
			tabArray=new String[totalRows][totalCols];
			for(int i=startRow;i<=totalRows;i++) {
				for(int j=startCol,k=0;;j++,k++) {
					tabArray[i-1][j-1]=getCellData(i,j);
					System.out.println(tabArray[i-1][j-1]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabArray;
		
	}
	
	public static void setExcelFile(String path,String sheetName) {
		try {
			FileInputStream excelFile=new FileInputStream(path);
			excelWorkBook=new XSSFWorkbook(excelFile);
			excelSheet=excelWorkBook.getSheet(sheetName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getCellData(int rowNum,int cellNum) {
		
		cell=excelSheet.getRow(rowNum).getCell(cellNum);
		
		return cell.toString();
		
	}
	
	public static void setCellData(String result, int rowNum, int CellNum) {

		row=excelSheet.getRow(rowNum);
		cell=row.getCell(CellNum);
		if(cell==null) {
			cell=row.createCell(CellNum);
			cell.setCellValue(result);
			
		}
		else {
			cell.setCellValue(result);
		}
		
		try {
			FileOutputStream fileOut=new FileOutputStream(Constant.Path_TestData+Constant.File_TestData);
			excelWorkBook.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
