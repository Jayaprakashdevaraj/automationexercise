package com.automationexercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.testng.Assert;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class HomePage extends TestNGHooks{
	
	private WaitConditions wait;
	
	public HomePage() {
		wait = new WaitConditions(
				getDriver());
	}
	
	public HomePage verifyPage() {
		WebElement homeOption = wait.waitUnitlVisibilityOfElement(locateElement(Locators.XPATH, "//a[text()=' Home'][@style='color: orange;']"));
		System.out.println("user in homePage");
		return this;
	}
	public SignupLoginPage clickSignupLogin() {
		click(locateElement(Locators.XPATH, "//a[text()=' Signup / Login']"));
		return new SignupLoginPage();
	}
	
	public AccountDeletePage deleteAccount() {
		WebElement deleteOption = locateElement(Locators.XPATH, "//a[text()=' Delete Account']");
		if(deleteOption.isDisplayed()) {
			click(deleteOption);
		}
		return new AccountDeletePage();
	}
	
	public HomePage verifyloggedIntoApp() {
		String username = getElementText(locateElement(Locators.XPATH, "//a[text()=' Logged in as ']/b"));
		System.out.println(username);
		return this;
	}
	public SignupLoginPage clickLogoutButton() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),'Logout')]"));
		return new SignupLoginPage();
	}
	
	public ContactusPage clickContactus() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),'Contact us')]"));
		return new ContactusPage();
	}
	
	public TestCasePage clickTestCaseButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Test Cases']"));
		return new TestCasePage();
	}
	
	public ProductsPage clickProduct() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),'Products')]"));
		return new ProductsPage();
	}
	
	public HomePage verifySubcribeHeader() {
		String elementText = getElementText(locateElement(Locators.XPATH, "//div[@class='single-widget']"));
		
		//Assert.assertEquals(elementText, "Subscription");
		return this;
	}
	
	public HomePage clickSusbscribeEmail(String Email) {
		type(locateElement(Locators.ID, "susbscribe_email") , Email);
		
		return this;
	}
	
	public ViewCartPage clickCart() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),'Cart')]"));
		return new ViewCartPage();
	}



}
