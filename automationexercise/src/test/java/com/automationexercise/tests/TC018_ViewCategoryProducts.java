package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC018_ViewCategoryProducts  extends TestNGHooks{
	
	@DataProvider(name="testcasePage")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "viewCategory");
	}
	
	@Test(dataProvider = "testcasePage")
	public void existinguserSignup(String CategoryHeader, String requiredCategory, String requiredCategory2) {
		new HomePage()
		.verifyPage()
		.verifyLeftSidebar(CategoryHeader)
		.clickCategory(requiredCategory)
		.clickDressinWoman()
		.verifyTitle()
		.clickCategory(requiredCategory2)
		.clickJeansinMen()
		.verifyTitle();
		
		
		
	}
}
