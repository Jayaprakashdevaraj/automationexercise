package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC010_VerifySubscriptionInHomePage extends TestNGHooks{
	
	
	@DataProvider(name="subscriptionData")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "EmailData");
	}
	
	@Test(dataProvider = "subscriptionData")
	public void verifysubscriptionData(String Email) {
		
		new HomePage()
		.verifyPage()
		.verifySubcribeHeader()
		.clickSusbscribeEmail(Email);
	}

}
