package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC006_ContactUsForm extends TestNGHooks{
	
	@DataProvider(name="GetinTouchInfo")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "GetinTouch");
	}
	
	@Test(dataProvider = "GetinTouchInfo")
	public void existinguserSignup(String name, String email, String subject, String message, String successmessage) {
		new HomePage()
		.verifyPage()
		.clickContactus()
		.verifyGetInTouch()
		.enterName(name)
		.enterEmail(email)
		.enterSubject(subject)
		.enterMessage(message)
		.uploadFile()
		.clickSubmitButton()
		.clickOKinAlert()
		.checkSuccessMessage(successmessage);
		
		
	}
}
