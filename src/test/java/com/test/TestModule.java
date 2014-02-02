package com.test;

import org.openqa.selenium.WebDriver;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class TestModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(WebDriver.class).toProvider(WebDriverProvider.class).in(Singleton.class);
	}

}
