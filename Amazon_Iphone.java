package com.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Iphone {
	static WebDriver driver;

	public void browserlanuch() {
		WebDriverManager.chromedriver().setup();
		List<String> optionlist = new ArrayList();
		optionlist.add("start-maximized");
		optionlist.add("incognito");
		ChromeOptions list = new ChromeOptions();
		list.addArguments(optionlist);
		driver = new ChromeDriver(list);
		driver.get("https://www.amazon.in/");

	}

	public void Serachcat() {
		WebElement searchcategory = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		
		searchcategory.click();
		
		WebElement textproduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		textproduct.sendKeys("Apple iPhone 14 ");
		WebElement search = driver.findElement(By.xpath("//input[@type='submit']"));
		search.submit();

	}
	public void totalnoofproduct() {
		List <WebElement> totalnoproduct=driver.findElements(By.xpath("//div[@class=\"a-section\"]"));
		for (WebElement iphone : totalnoproduct) {
			String totalproducttext = iphone.getText();
			System.out.println(totalproducttext);
			
		}
		System.out.println("total nof of product" + totalnoproduct.size());

	}

	public static void main(String[] args) {
		Amazon_Iphone v = new Amazon_Iphone();
		v.browserlanuch();
		v.Serachcat();
		v.totalnoofproduct();

	}

}
