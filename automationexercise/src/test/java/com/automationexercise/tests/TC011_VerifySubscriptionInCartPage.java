package com.automationexercise.tests;

import org.openqa.selenium.devtools.v137.log.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC011_VerifySubscriptionInCartPage extends TestNGHooks{
	
	@DataProvider(name = "cartSubEmail")
	public Object[][] cartSubscritionEmail(){
		return DataHandler.getData("AutomationExerciseTestData", "CartEmail");
	}
	
	@Test(dataProvider = "cartSubEmail")
	public void verifySubInCart(String Email){
		new HomePage()
		.verifyPage()
		.clickCart()
		.verifySubcribeHeader()
		.clickSusbscribeEmail(Email);
		
	}

}
