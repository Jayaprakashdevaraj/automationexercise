package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC022_AddToCartFromRecommendedItems extends TestNGHooks{
	
	@DataProvider(name = "ProductReview")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "TC022_RecommendedProduct");
	}
	
	
	@Test(dataProvider="ProductReview")
	public void addReviewInProduct(String reqProduct) {
		 new HomePage()
		.verifyRecommendedItemHeader()
		.getAllRecommendedProduct()
		.clickaddToBag(reqProduct)
		.clickViewCart()
		.getAllProdutsinCart()
		.verifyTheProduct(reqProduct);
	}

}
