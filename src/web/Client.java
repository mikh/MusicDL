package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import basics.DEFINE;
import logging.Log;

public class Client {
	Log ll;
	String base_URL;
	WebDriver driver;
	
	public Client(String base_URL, Log ll){
		this.ll = ll;
		this.base_URL = base_URL;
		
		ll.write(2, "Starting web driver\r\n");
		driver = new FirefoxDriver();
		
		ll.write(2, "Loading page " + base_URL + "\r\n");
		driver.get(base_URL);
	}
	
	public boolean getSong(String URL){
		if(!driver.getTitle().equals(DEFINE.START_PAGE_TITLE))
			gotoPage(base_URL);
		
		WebElement query = driver.findElement(By.name("url"));
		query.sendKeys(URL);
		query.submit();
		return true;
	}
	
	public void gotoPage(String URL){
		ll.write(2, "Loading page " + URL + "\r\n");
		driver.get(URL);
	}
	
	public String getPageSource(){
		return driver.getPageSource();
	}
}
