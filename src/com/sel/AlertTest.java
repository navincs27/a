package com.sel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {
	
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
	
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void scrollUsingJS(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	public static void handleSimpleAlert() {
		Alert simple_alert = driver.switchTo().alert();
		simple_alert.accept();
	}
	
	public static void handleConfirmAlert(String option) {
		Alert confirm_alert = driver.switchTo().alert();
		if(option.equals("accept")) {
			confirm_alert.accept();
		}else if(option.equals("dismiss")) {
			confirm_alert.dismiss();
		}	
	}
	
	public static void main(String[] args) {
		launchBrowser();
		launchUrl("https://demoqa.com/alerts");
		WebElement simple_alert_btn = driver.findElement(By.id("alertButton"));
		scrollUsingJS(0, 300);
		clickOnElement(simple_alert_btn);
		handleSimpleAlert();
		
		WebElement confirm_alert_btn = driver.findElement(By.id("confirmButton"));
		clickOnElement(confirm_alert_btn);
		handleConfirmAlert("dismiss");
	}

}
