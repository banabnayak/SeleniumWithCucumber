package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
	
	private WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.driver.get("http://www.kayak.com");
		
		
	}

	@FindBy(linkText = "FLIGHTS")
	WebElement flights;
	
	public FlightsPage gotoFlightsPage(){
	
			//WebElement element = driver.findElement(By.linkText("FLIGHTS"));
			flights.click();
			return new FlightsPage(driver);
	}

}
