package com.automationexercise.pages;

import org.openqa.selenium.WebElement;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class SignupAccountinformationPage extends TestNGHooks {
private WaitConditions wait;
	
	public  SignupAccountinformationPage() {
		wait = new WaitConditions(
				getDriver());
	}
	
	public SignupAccountinformationPage selectTitle(String Title) {
		WebElement titleRadio = locateElement(Locators.XPATH, "//input[@value='"+Title+"']");
		if(!titleRadio.isSelected()) {
			click(titleRadio);
		}
		return this;		
	}
	public SignupAccountinformationPage password(String Password) {
		type(locateElement(Locators.ID, "password"), Password);
		return this;
	}
	
	public SignupAccountinformationPage selectDate(String date) {
		dropdownSelectByValue(locateElement(Locators.ID, "days"), date);
		return this;
	}
	
	public SignupAccountinformationPage selectMonth(String month) {
		dropdownSelectByVisibleText(locateElement(Locators.ID, "months"), month);
		return this;
	}
	
	public SignupAccountinformationPage selectYear(String year) {
		dropdownSelectByValue(locateElement(Locators.ID, "years"), year);
		return this;
	}
	
	public SignupAccountinformationPage selectNewsletter() {
		WebElement newletterCheckbox = locateElement(Locators.ID, "newsletter");
		if(!newletterCheckbox.isSelected()) {
			click(newletterCheckbox);
		}
		return this;
	}
	
	public SignupAccountinformationPage selectSpecialOption() {
		WebElement optinCheckbox = locateElement(Locators.ID, "optin");
		if(!optinCheckbox.isSelected()) {
			click(optinCheckbox);
		}
		return this;
	}
	
	public SignupAccountinformationPage enterFirstName(String FName) {
		type(locateElement(Locators.ID, "first_name"), FName);
		return this;
	}
	public SignupAccountinformationPage enterLastName(String LName) {
		type(locateElement(Locators.ID, "last_name"), LName);
		return this;
	}
	

	public SignupAccountinformationPage enterAddress1(String Address1) {
		type(locateElement(Locators.ID, "address1"), Address1);
		return this;
	}
	
	public SignupAccountinformationPage enterState(String State) {
		type(locateElement(Locators.ID, "state"), State);
		return this;
	}
	public SignupAccountinformationPage enterCity(String City) {
		type(locateElement(Locators.ID, "city"), City);
		return this;
	}
	public SignupAccountinformationPage enterZipcode(String ZipCode) {
		type(locateElement(Locators.ID, "zipcode"), ZipCode);
		return this;
	}
	public SignupAccountinformationPage enterMobileNumber(String MobileNumber) {
		type(locateElement(Locators.ID, "mobile_number"), MobileNumber);
		return this;
	}
	public AccountCreatedPage clickCreateAccount() {
		click(locateElement(Locators.XPATH, "//button[text()='Create Account']"));
		return new AccountCreatedPage();
	}

}
