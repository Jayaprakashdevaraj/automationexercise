package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC003_LoginUserWithIncorrectEmailAndPassword extends TestNGHooks{
	
	 @DataProvider(name = "signupwithOldID")
	    public Object[][] loginWithInvalidData() {
	        return DataHandler.getData("AutomationExerciseTestData", "LoginWithWrongCredientials");
	    }
	
	@Test(dataProvider = "signupwithOldID" )
	public void verifyPage(String loginEmail, String loginPassword) {
		new HomePage().verifyPage().clickSignupLogin()
		.verifyLoginForm().loginEmailAddress(loginEmail).loginPassword(loginPassword).clickLoginButtonInvalidCredientials()
		.verifyWithWrongCredientials();	
		}


}
