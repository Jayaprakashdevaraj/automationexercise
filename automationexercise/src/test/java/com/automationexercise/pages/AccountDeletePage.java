package com.automationexercise.pages;

import org.openqa.selenium.WebElement;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class AccountDeletePage extends TestNGHooks{
	private WaitConditions wait;
	public  AccountDeletePage() {
		wait = new WaitConditions(
				getDriver());
	}

	
	
	
	public AccountDeletePage deleteinfo() {
		String elementText = getElementText(locateElement(Locators.XPATH, "//b[text()='Account Deleted!']/following::p"));
		if(elementText.contains("permanently deleted")) {
			System.out.println("Account deleted successfully");
		}
		return this;

	}
	public HomePage clickContinueindeleteAccount() {
		click(locateElement(Locators.XPATH, "//a[text()='Continue']"));
		return new HomePage();		
	}
}
