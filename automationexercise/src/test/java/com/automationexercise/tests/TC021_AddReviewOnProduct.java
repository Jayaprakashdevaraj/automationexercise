package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC021_AddReviewOnProduct extends TestNGHooks{
	
	@DataProvider(name = "ProductReview")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "TC021_SearchAndVerify");
	}
	
	
	@Test(dataProvider="ProductReview")
	public void addReviewInProduct(String reqProduct,String ReviewerName,String ReviewerEmail, String ReviewerInfo) {
		new HomePage()
		.verifyPage()
		.clickProduct()
		.verifyTitle()
		.clickViewProduct(reqProduct)
		.getReviewHeaderName()
		.reviewName(ReviewerName)
		.reviewEmail(ReviewerEmail)
		.addReview(ReviewerInfo)
		.clickSubmitButton()
		.getReviewMessageStatus();
	}

}
