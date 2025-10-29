package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class VerifyTheExistingID extends TestNGHooks{
	
	 @DataProvider(name = "signupwithOldID")
	    public Object[][] getSignupData() {
	        return DataHandler.getData("AutomationExerciseTestData", "SignupWithOldID");
	    }
	
	@Test(dataProvider = "signupwithOldID" )
	public void verifyPage(String signupName, String signupEmail) {
		new HomePage().verifyPage().clickSignupLogin()
		.signupName(signupName)
		.signupEmailAddress(signupEmail)
		.clickSigninButtonWithExitingID()
		.verifyexistingAccount();	
		}


}
