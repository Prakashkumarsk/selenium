package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_Driven {
	static WebDriver driver;

	public static void browserLanuch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

	}

	
	public static void dataDriven() throws IOException {
		File f = new File("C:\\Users\\prakashkumar\\Desktop\\fbid.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		
		int lastRowNum = sheetAt.getLastRowNum();
		System.out.println(lastRowNum); 
		Row row = sheetAt.getRow(0);
		short lastCellNum = row.getLastCellNum();
		System.out.println(lastCellNum);
		
			Row row2 = sheetAt.getRow(1);
			String string = row2.getCell(0).toString();
			WebElement login = driver.findElement(By.xpath("//input[@name='email']"));
			login.sendKeys(string);
			
		Row row3 = sheetAt.getRow(1);
	     String string2 = row3.getCell(1 ).toString();
	     WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
	     password.sendKeys(string2);
			
		}//

	

	public static void main(String[] args) throws IOException {
		browserLanuch();
		dataDriven();
	}

}
