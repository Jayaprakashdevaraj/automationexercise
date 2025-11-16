package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC009_SearchProduct extends TestNGHooks{
	
	
	@DataProvider(name="search")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "SearchProduct");
	}
	
	@Test(dataProvider = "search")
	public void verifyProduct(String search) {
		
		new HomePage()
		.verifyPage()
		.clickProduct()
		.verifyAllProducts()
		.searchProduct(search)
		.getAllProduct()
		.clickViewProduct(search)
		.getCategory()
		.getPrice()
		.checkAvailablity()
		.checkCondition()
		.checkBrand();
	
	}
}
