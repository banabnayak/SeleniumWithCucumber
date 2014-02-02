Feature:
	In order to search flights from A to B
	As a passenger
	I need to find cheapest flights possible to save money

Scenario: search flights
		
		Given I navigate to "http://www.kayak.com"
		When I search flights from "BOS" to "LAX"
		Then I find flights successfully