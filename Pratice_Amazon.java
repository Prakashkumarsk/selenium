package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.cli.Main;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Pratice_Amazon {
	static WebDriver driver;
   
	public static void browserlanuch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
		
		public static void selectdrop() {
		//WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
			WebElement dropdown = driver.findElement(By.xpath("//select[@name='url']"));
			dropdown.click();
			Select n=new Select(dropdown);
			String excpeted="music";
			List<WebElement> options = n.getOptions();
			for (WebElement alloption : options) {
				if (excpeted.equalsIgnoreCase(alloption.getText())) 
				{
					String text = alloption.getText();
					System.out.println(text);
					System.out.println(alloption.getText());
					n.selectByVisibleText(alloption.getText());
					break;
					
				}
	
	
			}
		}
		public static void search() {
			String expected="cd";
			WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			searchbox.sendKeys("cd");
			List<WebElement> selectvalue = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']"));
			for (WebElement orginal : selectvalue) {
				
				/*if(expected.equalsIgnoreCase
						(selectvalue))
				{*/
					
				}
				
			}

		
		
			
			
			
			
		
		public static void main(String[] args) {
			
			browserlanuch();
			selectdrop();
			search();
		}
		
		
	}

