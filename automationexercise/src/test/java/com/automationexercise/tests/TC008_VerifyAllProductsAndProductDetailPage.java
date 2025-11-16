package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC008_VerifyAllProductsAndProductDetailPage extends TestNGHooks{
	
	
	@DataProvider(name="products")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "Product");
	}
	
	@Test(dataProvider = "products")
	public void verifyProduct(String reqProduct) {
		
		new HomePage()
		.verifyPage()
		.clickProduct()
		.verifyAllProducts()
		.getAllProduct()
		.clickViewProduct(reqProduct)
		.getProductName(reqProduct)
		.getCategory()
		.getPrice()
		.checkAvailablity()
		.checkCondition()
		.checkBrand();
	}
}
