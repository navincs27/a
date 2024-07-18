package com.sel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesTest {

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
	
	public static void scrollUsingJS(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		launchUrl("https://demoqa.com/frames");
		
		scrollUsingJS(0, 300);
		switchToFrame("frame1");
		WebElement frame_text = driver.findElement(By.id("sampleHeading"));
		System.out.println(frame_text.getText());
		
	}
}
