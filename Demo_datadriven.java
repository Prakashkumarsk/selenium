package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo_datadriven {
	public static void dataDriven() throws IOException {
		File f=new File("C:\\Users\\prakashkumar\\Desktop\\fbid.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		Row row = sheetAt.getRow(0);
		Cell cell = row.getCell(0);
		CellType cellType = cell.getCellType();
		/*wb.getSheetAt(1);
		Row row = sheetAT.getRow(1);
		Cell cell = row.getCell(1);
		CellType cellType = cell.getCellType();*/
		if (cellType.equals(cellType.STRING)) {
			
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			System.out.println(numericCellValue);
		}

	}
	public static void main(String[] args) throws IOException {
		dataDriven();
	}
	

}



