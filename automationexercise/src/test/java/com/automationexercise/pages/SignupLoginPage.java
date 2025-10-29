package com.automationexercise.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class SignupLoginPage extends TestNGHooks{

	private WaitConditions wait;
	
	public  SignupLoginPage() {
		wait = new WaitConditions(
				getDriver());
	}
	
	public SignupLoginPage verifyLoginForm() {
		WebElement logForm = locateElement(Locators.XPATH, "//div[@class='login-form']");
		if(logForm.isDisplayed()) {
			System.out.println(getElementText(logForm));
		}
		return this;
	}
	
	public SignupLoginPage loginEmailAddress(String loginEmail) {
		type(locateElement(Locators.XPATH, "//input[@data-qa='login-email']"), loginEmail);
		return this;
	}
	public SignupLoginPage loginPassword(String loginPassword) {
		type(locateElement(Locators.XPATH, "//input[@data-qa='login-password']"), loginPassword);
		return this;
	}
	public HomePage clickLoginButton() {
		click(locateElement(Locators.XPATH, "//button[@data-qa='login-button']"));
		return new HomePage();
	}
	public SignupLoginPage clickLoginButtonInvalidCredientials() {
		click(locateElement(Locators.XPATH, "//button[@data-qa='login-button']"));
		return this;
	}
	
	public SignupLoginPage signupName(String signupName) {
		type(locateElement(Locators.XPATH, "//input[@data-qa='signup-name']"), signupName);
		return this;
	}
	public SignupLoginPage signupEmailAddress(String signupEmail) {
		type(locateElement(Locators.XPATH, "//input[@data-qa='signup-email']"), signupEmail);
		return this;
	}
	public SignupAccountinformationPage clickSigninButton() {
		click(locateElement(Locators.XPATH, "//button[@data-qa='signup-button']"));
		return new SignupAccountinformationPage();
	}
	
	public SignupLoginPage clickSigninButtonWithExitingID() {
		click(locateElement(Locators.XPATH, "//button[@data-qa='signup-button']"));
		return this;
	}
	
	public SignupLoginPage verifyexistingAccount() {
		WebElement waitforExistingErrorMsg = wait.waitUnitlVisibilityOfElement(locateElement(Locators.XPATH, "//p[text()='Email Address already exist!']"));
		String accountError = getElementText(waitforExistingErrorMsg);
		Assert.assertEquals(accountError, "Email Address already exist!");
		return this;
	}
	
	public SignupLoginPage verifyWithWrongCredientials() {
		WebElement incorrectMsg = locateElement(Locators.XPATH, "//p[text()='Your email or password is incorrect!']");
		if(incorrectMsg.isDisplayed()) {
			System.out.println("your email or password is inccorrect");
		}
		return this;
	}
	

}
