package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public FlightsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public ResultsPage bookFlight(String originAirport,
			String destinationAirport) throws InterruptedException {
		// Select Origin and destination
		WebElement origin = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("input[id='origin']")));
		origin.click();
		origin.clear();
		origin.sendKeys(originAirport);

		WebElement airport_origin = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.cssSelector("#smartbox li[id^='ap-" + originAirport
								+ "']")));
		airport_origin.click();

		WebElement destination = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.cssSelector("input[id='destination']")));
		destination.clear();
		destination.sendKeys(destinationAirport);
		WebElement airport_destination = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.cssSelector("#smartbox li[id^='ap-"
								+ destinationAirport + "']")));
		airport_destination.click();

		// Select Start and end dates for travel

		WebElement start = wait.until(ExpectedConditions
				.elementToBeClickable(By
						.cssSelector("#travel_dates-start-placeholder")));
		start.click();
		// final List<WebElement> rows = new ArrayList<WebElement>();
		List<WebElement> rows = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
						.cssSelector("div.r9-datepicker-month-last span.r9-datepicker-month-row")));
		for (WebElement row : rows) {
			By findBy = By.xpath(".//span[text()='27']");
			try {
				WebElement day = row.findElement(findBy);
				day.click();
				break;
			} catch (NoSuchElementException e) {

			}
		}

		// }
		// This condition makes sure all dates are loaded.
		// ExpectedCondition<WebElement> dateAppears = new
		// ExpectedCondition<WebElement>() {
		// public WebElement apply(WebDriver driver) {
		// try {
		// rows = wait
		// .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
		// .cssSelector("div.r9-datepicker-month-last span.r9-datepicker-month-row")));
		// final By findBy = By.xpath(".//span[text()='15']");
		// for (final WebElement row : rows) {
		// WebElement day = row.findElement(findBy);
		// return day;
		// }
		// } catch (Exception e) {
		// System.out.println("Didn't find it yet......");
		// return null;
		// }
		// return null;
		// }
		// };
		// WebElement date = wait.until(dateAppears);
		// date.click();
		WebElement end = wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("#travel_dates-end-placeholder")));
		end.click();

		for (WebElement row : rows) {
			By findBy = By.xpath(".//span[text()='27']");
			try {
				WebElement day = row.findElement(findBy);
				day.click();
				break;
			} catch (NoSuchElementException e) {

			}
		}

		WebElement travelers = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("#travelers-status")));
		travelers.click();

		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.cssSelector("#travelerTypeSelect .ptcAdults button.incrementor")))
				.click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.cssSelector("#travelerTypeSelect .ptcChildren button.incrementor")))
				.click();
		// driver.findElement(By.cssSelector("#fdimgbutton")).click();
		WebElement findFlights = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("#fdimgbutton")));
		findFlights.submit();

		return new ResultsPage(driver);

	}

}
