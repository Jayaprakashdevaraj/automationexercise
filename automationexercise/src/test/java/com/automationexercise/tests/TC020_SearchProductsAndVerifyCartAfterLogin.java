package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;

public class TC020_SearchProductsAndVerifyCartAfterLogin  extends TestNGHooks{
	
	@DataProvider(name="searchtoaddProductAndLogin")
	public Object[][] readData(){
		return DataHandler.getData("AutomationExerciseTestData", "SearchAndVerify");
	}
	
	@Test(dataProvider = "searchtoaddProductAndLogin")
	public void existinguserSignup(String search, String loginEmail, String loginPassword) {
		new HomePage()
		.verifyPage()
		.clickProduct()
		.verifyTitle()
		.searchProduct(search)
		.getAllProduct()
		.selectProduct(search)
		.clickAddToCart()
		.clickViewCart()
		.getAllProdutsinCart()
		.clickSignupLogin()
		.loginEmailAddress(loginEmail)
		.loginPassword(loginPassword)
		.clickLoginButton()
		.clickCart()
		.getAllProdutsinCart();
		
	}
}
