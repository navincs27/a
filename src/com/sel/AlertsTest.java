package com.sel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTest {
	
	WebDriver driver;
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void launchUrl() {
		driver.get("https://demoqa.com/alerts");
	}
	
	public void handlingConfirmAlert() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement confirm_btn = driver.findElement(By.id("promtButton"));
		confirm_btn.click();
		Alert prompt_alert = driver.switchTo().alert();
		Thread.sleep(5000);
		prompt_alert.sendKeys("nvn");
		Thread.sleep(5000);
		prompt_alert.accept();
	
	}
	
	public static void main(String[] args) throws InterruptedException {
		AlertsTest a = new AlertsTest();
		a.launchBrowser();
		a.launchUrl();
		a.handlingConfirmAlert();
	}

}
