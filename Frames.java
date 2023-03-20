package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://letcode.in/frame");
		Thread.sleep(2300);
		
		//outerframe 
		WebDriver outerframe = driver.switchTo().frame("firstFr");

		WebElement loginusername = driver.findElement(By.xpath("//input[@name=\"fname\"]"));
		loginusername.sendKeys("prkash");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("1234567");
		Thread.sleep(2000);
        // innerframe using webelement
		WebElement findElement = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
//		Thread.sleep(1000);
		driver.switchTo().frame(findElement);

//		WebDriver innerframe = driver.switchTo().frame(0);
		 
		WebElement email = driver.findElement(By.name("email"));
	     Thread.sleep(2000);
		email.sendKeys("prakshkumar@gnail.com");
		// driver.switchTo().defaultContent();
		driver.switchTo().parentFrame().switchTo().parentFrame();
		// driver.switchTo().defaultContent();
		
		

		driver.findElement(By.xpath("//a[@class=\"card-footer-item\"]")).click();

	}

}
