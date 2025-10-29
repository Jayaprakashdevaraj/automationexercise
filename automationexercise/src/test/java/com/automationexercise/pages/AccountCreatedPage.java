package com.automationexercise.pages;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class AccountCreatedPage extends TestNGHooks{
	
	private WaitConditions wait;
	
	public AccountCreatedPage() {
		
		wait = new WaitConditions(
				getDriver());
	}
	
	public HomePage clickContinue() {
		click(locateElement(Locators.XPATH, "//a[@data-qa='continue-button']"));
		return new HomePage();
	}

}
