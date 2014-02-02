package com.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","html:target/cucumber-html-reports","json:target/cucumber.json"},features={"classpath:search.feature"})
public class RunCukesTest {

}
