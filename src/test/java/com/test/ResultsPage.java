package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ResultsPage(WebDriver driver) {
		this.driver= driver;
		this.wait = new WebDriverWait(driver,30);
	}

	public void waitForPageLoaded() {
		//My own condition to check if all results are loaded
		 ExpectedCondition<Boolean> expectation = new
					ExpectedCondition<Boolean>() {
					        public Boolean apply(WebDriver driver) {
					          try {
								WebElement element;
								try {
									element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("progressDiv")));
									if(element == null)
									   return false;								
									return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-progressbar-value")));
								} catch (NoSuchElementException e) {
									System.out.println("not found "+e.getMessage());
									e.printStackTrace();
									return false;
								}
							} catch (Exception e) {
								System.out.println("not found "+e.getMessage());
								return false;
							}
					        }
					      };

		      try {
	             wait.until(expectation);
	     } catch(Throwable error) {
	             assert ("Timeout waiting for Page Load Request to complete.") != null;
	     }
	}

	@FindBy(css = "select#sortselectlist")
	WebElement dropdown;
	public void selectFlight()
	{
		//WebElement dropdown = driver.findElement(By.cssSelector("select#sortselectlist"));

		//sortselectlist
		Select sortbySelect = new Select(dropdown);
		sortbySelect.selectByVisibleText("Price - Low to High");
		
		//getting lowest airfare
//		 WebElement selectFlight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbd112 buttontab.overviewtab_112")));
//		 selectFlight.click();
	}

	@FindBy(css = "#showingnumberresults")
	WebElement showingFlights;
	
	public boolean isResultsEmpty()
	{
	     if(showingFlights.getText().equalsIgnoreCase("0"))
	    	 return true;
	     return false;
	}
	public void quitApp(){
		
		driver.quit();
		
	}
	
}
