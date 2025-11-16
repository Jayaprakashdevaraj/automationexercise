package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC017_RemoveProductsFromCart extends TestNGHooks{
	
	@DataProvider(name ="delete")
	public Object[][] readDate(){
		return DataHandler.getData("AutomationExerciseTestData", "DeleteProduct");
	}
	
	@Test(dataProvider = "delete")
	public void verifyQuandity(String firstReqProduct) {
		new HomePage().verifyPage()
		.clickProduct()
		.clickViewProduct(firstReqProduct)
		.getProductName(firstReqProduct)
		.clickAddToCart()
		.clickViewCart()
		.deleteSingleProduct(firstReqProduct);
	}

}
