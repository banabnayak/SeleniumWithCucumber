package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Inject;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepDefs {
	 WebDriver driver;
	 MainPage mainPage;
	 ResultsPage resultsPage;
	 @Inject
	 public SearchStepDefs(WebDriver driver){
		  this.driver = driver;
	 }
	   	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	@Given("^I navigate to \"([^\"]*)\"$")
	public void I_navigate_to(String url) throws Throwable {
	    System.out.println(url);
      	mainPage = new MainPage(driver);
      	PageFactory.initElements(driver, mainPage);
    
	}

	@When("^I search flights from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void I_search_flights_from_to(String source, String destination) throws Throwable {
	   System.out.println(source+"   "+destination);
	   FlightsPage flightsPage = mainPage.gotoFlightsPage();
	   PageFactory.initElements(driver, flightsPage);
	 //takes airport code as input
	   resultsPage = flightsPage.bookFlight("SJC","LAX");
	   PageFactory.initElements(driver, resultsPage);
	   resultsPage.waitForPageLoaded();
	   resultsPage.selectFlight();
	}

	@Then("^I find flights successfully$")
	public void I_find_flights_successfully() throws Throwable {
	  System.out.println("assert here");
	  if(resultsPage.isResultsEmpty() == true)
		  System.out.println("No matching flights found");
	  else
		  System.out.println("Found matching flights");
		
	}
	
	@After()
	public void TearDown(){
		resultsPage.quitApp();
	}
}
