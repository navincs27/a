package com.sel;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class WebDriverMethods {
	
	static WebDriver driver;
	public static void browserLaunch() {
		driver = new ChromeDriver();
	}
	
	public static void launchUrl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static void getPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public static void getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	public static void captureScreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File("D:\\Avadi\\workspace\\S089\\Screenshots\\"+name+".png");

		FileHandler.copy(src,dest);
	}
	
	public static void findPageElement() throws InterruptedException, IOException {
		//Locator - ID
		WebElement search_box = driver.findElement(By.id("twotabsearchtextbox"));
//		search_box.sendKeys("samsung");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('twotabsearchtextbox').value = 'iphone';");
		
		js.executeScript("window.scrollBy(0,500);");
		
		
		captureScreenshot("search");
		
		
		System.out.println(search_box.getAttribute("class"));
		
		Thread.sleep(5000);
		
		System.out.println(search_box.isEnabled());
		
		System.out.println(search_box.getText());
		
//		search_box.clear();
		
		Thread.sleep(5000);
		
		WebElement search_btn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		System.out.println(search_btn.isDisplayed());
		
		search_btn.click();
		
		js.executeScript("window.scrollBy(0,500);");
		
		captureScreenshot("samsung_page");
		
		WebElement mobile_tab = driver.findElement(By.linkText("Mobiles"));
		System.out.println(mobile_tab.getText());
		
		
		//Locator - Name
		WebElement search = driver.findElement(By.name("field-keywords"));
	
		//Locator - TagName
		WebElement link = driver.findElement(By.tagName("a"));
	
		//Locator - LinkText
		
		WebElement findElement = driver.findElement(By.xpath("//a[@data-csa-c-content-id = 'nav_cs_mobiles']"));
		
	}
	
	public static void closeWindow() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		browserLaunch();
		launchUrl("https://www.amazon.in/");
//		getPageTitle();
//		getPageUrl();
		findPageElement();
		
		closeWindow();
	}
	
	

}
