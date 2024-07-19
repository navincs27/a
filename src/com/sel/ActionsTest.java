package com.sel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {
	static WebDriver driver;
	
	
	public static void launchBrowser() {
		System.out.println();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		System.out.println();
		driver.get(url);
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void rightClickUsingMouse(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public static void mouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public static void downUsingKeyBoard() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static void enterUsingKeyBoard() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void switchToTab() {
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> id_list = new ArrayList<>(windowHandles);
		driver.switchTo().window(id_list.get(1));
	}
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		launchBrowser();
		launchUrl("https://www.amazon.in/");
		WebElement mobile = driver.findElement(By.xpath("//a[text() = 'Mobiles']"));
		rightClickUsingMouse(mobile);
//		WebElement signIn_btn = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
//		mouseHover(signIn_btn);
//		WebElement your_account_option = driver.findElement(By.xpath("//span[text() = 'Your Account']"));
//		clickOnElement(your_account_option);
		downUsingKeyBoard();
		enterUsingKeyBoard();
		Thread.sleep(3000);
		switchToTab();
		WebElement smartWatch = driver.findElement(By.xpath("//span[text() = 'Smartwatches']"));
		clickOnElement(smartWatch);
		
		
		
	}
	

}
