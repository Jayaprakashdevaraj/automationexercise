package com.automationexercise.hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automationexercise.selenium.api.base.SeleniumBase;

public class TestNGHooks extends SeleniumBase{

	@BeforeMethod
	public void beforeMethod() {
		browserLaunch();		
		loadUrl("https://automationexercise.com/");
	}
	
	@AfterMethod
	public void afterMethod() {
		quit();
	}

}
