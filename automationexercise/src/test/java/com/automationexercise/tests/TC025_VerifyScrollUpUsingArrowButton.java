package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC025_VerifyScrollUpUsingArrowButton extends TestNGHooks{
	
	
/*	@DataProvider(name="subscriptionData")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "EmailData");
	}
	
	@Test(dataProvider = "subscriptionData")
*/
	@Test
	public void verifysubscriptionData() {
		
		new HomePage()
		.verifyPage()
		.scrolltillSubcribeHeader()
		.verifySubcribeHeader()
		.clickScrollUpArrow()
		.getInfoAfterClickArrowUpButton();
	}

}
