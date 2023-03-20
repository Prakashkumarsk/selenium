package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_ {
	public static WebDriver driver;

	public static void main(String args[]) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// simple
		driver.get("https://letcode.in/alert");
		driver.findElement(By.xpath("//button[@id=\"accept\"]")).click();
		Alert single = driver.switchTo().alert();
		System.out.println(single.getText());
		single.accept();

		// takeScreenshot("kis");

		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\prakashkumar\\eclipse-workspace\\Demo\\ScreenShot\\90img.png");
		FileHandler.copy(source, des);

		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("kumar");
		String india = prompt.getText();
		System.out.println(india);
		prompt.accept();

	}
}