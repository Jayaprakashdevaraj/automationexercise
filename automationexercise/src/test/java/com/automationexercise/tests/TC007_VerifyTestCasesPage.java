package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC007_VerifyTestCasesPage  extends TestNGHooks{
	
	@DataProvider(name="testcasePage")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "testcase");
	}
	
	@Test(dataProvider = "testcasePage")
	public void existinguserSignup(String title) {
		new HomePage()
		.verifyPage()
		.clickTestCaseButton()
		.verifyTestCasePage(title);
		
		
	}
}
