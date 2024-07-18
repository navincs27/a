package com.sel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		
		js.executeScript("document.getElementById('twotabsearchtextbox').value = 'samsung';");
		Thread.sleep(10000);
		WebElement sell_on_amazon = driver.findElement(By.xpath("//a[text() = 'Sell on Amazon']"));
//		js.executeScript("arguments[0].scrollIntoView()",sell_on_amazon);
	
		
		js.executeScript("arguments[0].click()",sell_on_amazon);
		
	}

}
