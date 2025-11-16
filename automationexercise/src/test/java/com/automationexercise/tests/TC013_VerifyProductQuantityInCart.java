package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC013_VerifyProductQuantityInCart extends TestNGHooks{
	
	@DataProvider(name ="Quantity")
	public Object[][] readDate(){
		return DataHandler.getData("AutomationExerciseTestData", "ChangeTheQuantity");
	}
	
	@Test(dataProvider = "Quantity")
	public void verifyQuandity(String firstReqProduct, String newQuantity) {
		new HomePage()
		.verifyPage()
		.clickProduct()
		.clickViewProduct(firstReqProduct)
		.getProductName(firstReqProduct)
		.changeQuantity(newQuantity)
		.clickAddToCart()
		.clickViewCart()
		.getAllProdutsinCart()
		.getAllProductsQuantity();
	
	}

}
