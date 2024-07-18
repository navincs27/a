package com.sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
static WebDriver driver;
	
	public static void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void readDataFromTable(WebElement element) {
		System.out.println(element.getText());
	}
	
	public static void main(String[] args) {
		launchBrowser();
		launchUrl("https://letcode.in/table");
		WebElement egg_price = driver.findElement(By.xpath("//table[@id='shopping']"));
		readDataFromTable(egg_price);
		WebElement icecream_row = driver.findElement(By.xpath("//table[@class='mat-sort table is-bordered is-striped is-narrow is-hoverable is-fullwidth']/tr[2]"));
		readDataFromTable(icecream_row);
	
	}

}
