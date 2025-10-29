package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC005_RegisterUserWithExistingEmail extends TestNGHooks{
	
	@DataProvider(name="SignupWithExistingCredientials")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "SignupWithExistingID");
	}
	
	
	@Test(dataProvider = "SignupWithExistingCredientials")
	public void existinguserSignup(String signupName, String signupEmail) {
		new HomePage()
		.verifyPage()
		.clickSignupLogin()
		.signupName(signupName)
		.signupEmailAddress(signupEmail)
		.clickSigninButtonWithExitingID()
		.verifyexistingAccount();
		
	}

}
