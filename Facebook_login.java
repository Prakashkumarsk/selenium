package com.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_login {
	public static String facebook3;
	public static String facebooktitle;
	static WebDriver driver;

	@BeforeClass
	public static void browserlanuch() {
		WebDriverManager.chromedriver().setup();

		List<String> optionslist = new ArrayList<>();
		optionslist.add("start-maximized");
		optionslist.add("incognito");

		ChromeOptions option = new ChromeOptions();
		option.addArguments(optionslist);
		driver = new ChromeDriver(option);
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
	}

	
    
	@Test(groups = "prakash")
	public static void login() {
		facebooktitle = driver.getTitle(); 
		String facebookurl = driver.getCurrentUrl();

		System.out.println(facebooktitle + facebookurl);

		if (facebooktitle.equalsIgnoreCase("facebook") == facebookurl.equalsIgnoreCase("facebook")) {

			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prakashkumar@gmail.com");

			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("987654321");
			driver.findElement(By.xpath("//button[@name='login']")).click();

		}

	}

	@Test(priority = 1,description = "take the screenshot",alwaysRun = true,groups= {"sanity"})
	public static void screenshot() throws IOException {

		TakesScreenshot screen = (TakesScreenshot) driver;
		File t = screen.getScreenshotAs(OutputType.FILE);
		File n = new File("C:\\Users\\prakashkumar\\eclipse-workspace\\Demo\\ScreenShot\\79.png");
	                 	FileHandler.copy(t, n);
		driver.navigate().back();

	}

	@Test(priority = 2,enabled = false,groups= {"reg"})
	public static void account() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("prakash");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[3]")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("kash@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"password_step_input\"]")).sendKeys("987654321");

		WebElement birthday = driver.findElement(By.xpath("//select[@name=\"birthday_day\"]"));
		Select s = new Select(birthday);
		Thread.sleep(3000);
		s.selectByVisibleText("3");

		WebElement birthmonth = driver.findElement(By.xpath("//select[@id='month']"));

		Select s3 = new Select(birthmonth);
		Thread.sleep(3000);
		s3.selectByVisibleText("Jul");

		Select s2 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		Thread.sleep(3000);
		s2.selectByValue("1995");

		driver.findElement(By.xpath("(//input[@type=\"radio\"])[3]")).click();

		driver.findElement(By.xpath("//button[@name='websubmit']")).click();

	}

	@Test(priority = 3,groups= {"spt"})
	public static void screeshot2() throws IOException {
		TakesScreenshot screen2 = (TakesScreenshot) driver;
		File DEST = screen2.getScreenshotAs(OutputType.FILE);
		File source = new File("C:\\Users\\prakashkumar\\eclipse-workspace\\Demo\\ScreenShot\\89image.png");
		FileHandler.copy(DEST, source);

	}
@Test(priority=4,groups = {"ipt"})
	public static void comparsion() {
		facebook3 = driver.getTitle();
		System.out.println(facebook3);

	}



}
