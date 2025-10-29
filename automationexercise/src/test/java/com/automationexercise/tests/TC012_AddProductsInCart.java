package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC012_AddProductsInCart extends TestNGHooks{
	
	@DataProvider(name = "overlayclick")
	public Object[][] cartSubscritionEmail(){
		return DataHandler.getData("AutomationExerciseTestData", "ProductOverlayClick");
	}
	
	@Test(dataProvider = "overlayclick")
	public void verifySubInCart(String firstReqProduct, String secondReqProduct) throws InterruptedException{
		new HomePage()
		.verifyPage()
		.clickProduct()
		.getAllProduct()
		.hoveTheProduct(firstReqProduct)
		.clickAddToBaginOverlay(firstReqProduct)
		.clickContinueShopping()
		.hoveTheProduct(secondReqProduct)
		.clickAddToBaginOverlay(secondReqProduct)
		.clickViewCart()
		.getAllProdutsinCart()
		.getAllProductsPrice();
	
	}
}
