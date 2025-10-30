package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC019_ViewCartBrandProducts  extends TestNGHooks{
	
	@DataProvider(name="brand")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "SelectBrand");
	}
	
	@Test(dataProvider = "brand")
	public void existinguserSignup(String firstBrandName, String secondBrandName) {
		new HomePage()
		.verifyPage()
		.clickProduct()
		.verifyBrands()
		.selectBrand(firstBrandName)
		.verifyTitle()
		.getAllProduct()
		.selectBrand(secondBrandName)
		.verifyTitle()
		.getAllProduct();
		
		
		
	}
}
