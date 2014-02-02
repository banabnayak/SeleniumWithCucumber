Selenium with Cucumber
========================
This is a Java Maven project I created to learn about Maven and Selenium(WebDriver), Cucumber.
The program opens  "www.kayak.com" in a user defined browser and finds the cheapest flight for the dates provided.  Currently the code supports two browsers, Chrome and Firefox.
Code can be run from command line as,
```mvn clean test -Dbrowser.name=chrome```
While developing this project I learned about
  - different types of selectors(xpath, css, id, name) to find elements 
  - concepts and usage of pageObject and pageFactory 
  - Implicit and explicit waits for synchronization
  - Cucumber for wrapping business language around code
  - Guice for dependency injection
	
