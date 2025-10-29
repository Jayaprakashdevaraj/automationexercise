package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC004_LogoutUser extends TestNGHooks{
	
	 @DataProvider(name = "signupwithvalidCredientials")
	    public Object[][] loginData() {
	        return DataHandler.getData("AutomationExerciseTestData", "LogintoTheApp");
	    }
	 @Test(dataProvider = "signupwithvalidCredientials" )
		public void verifyPage(String loginEmail, String loginPassword) {
			new HomePage().verifyPage().clickSignupLogin()
			.verifyLoginForm().loginEmailAddress(loginEmail).loginPassword(loginPassword).clickLoginButton()
			.verifyloggedIntoApp().clickLogoutButton().verifyLoginForm();

		
	 }
}
