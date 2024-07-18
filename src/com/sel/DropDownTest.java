package com.sel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {
	
	static WebDriver driver;
	
	public static void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void dropdownByText(WebElement element, String text) {
		Select s = new Select(element);
		System.out.println(s.isMultiple());
		s.selectByVisibleText(text);
	}
	
	public static void getDropDownOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		
		for(WebElement e : options) {
			System.out.println(e.getText());
		}
	}
	
	public static void deselectByText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		launchUrl("https://www.amazon.in/");
		WebElement categories = driver.findElement(By.id("searchDropdownBox"));		
		dropdownByText(categories , "Baby");
		getDropDownOptions(categories);
		launchUrl("https://demoqa.com/select-menu");
		WebElement cars_dd = driver.findElement(By.id("cars"));
		dropdownByText(cars_dd,"Audi");
		dropdownByText(cars_dd,"Volvo");
		Thread.sleep(3000);
		deselectByText(cars_dd, "Volvo");
//		dropdownByText(location)
		
	}

}
