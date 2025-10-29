package com.automationexercise.pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class TestCasePage extends TestNGHooks{
	
	private WaitConditions wait;
	
	public TestCasePage() {
		wait= new WaitConditions(getDriver());
	}
	
	public TestCasePage verifyTestCasePage(String title) {
		String testCaseTitle = getElementText(locateElement(Locators.XPATH, "//b[text()='Test Cases']"));
		if(testCaseTitle.equalsIgnoreCase(title)) {
			System.out.println("user navigate into testcase page");
		}
		return this;
	}

}
