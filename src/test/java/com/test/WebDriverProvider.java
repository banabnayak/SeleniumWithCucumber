package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.inject.Provider;

public class WebDriverProvider implements Provider<WebDriver> {

	public WebDriver get() {

		WebDriver driver = null;
		String browser = System.getProperty("browser.name");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
