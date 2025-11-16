package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC016_PlaceOrderLoginBeforeCheckout extends TestNGHooks{
	
	@DataProvider(name ="PlaceOrder")
	public Object[][] readDate(){
		return DataHandler.getData("AutomationExerciseTestData", "placeorderwithLoggedinUser");
	}
	
	@Test(dataProvider = "PlaceOrder", dependsOnMethods = "signupTheAccount")
	public void verifyQuandity(String loginEmail, String loginPassword,String firstReqProduct,  String description, String CardName, String cardNumber, String CVV, String expiryMonth, String expiryYear, String successSate
) {
		new HomePage().verifyPage()
		.clickProduct()
		.clickViewProduct(firstReqProduct)
		.getProductName(firstReqProduct)
		.clickAddToCart()
		.clickViewCart()
		.clickProceedToCheckoutWithLogin()
		.getDeliveryDetails()
		.getBillingDetails()
		.enterDescription(description)
		.clickPlaceOrder()
		.enterCardName(CardName)
		.entercardNumber(cardNumber)
		.enterCVV(CVV)
		.enterMonth(expiryMonth)
		.enterYear(expiryYear)
		.clickPayAndConfirm()
		.getPaymentStatusHeader()
		.verifyPaymentState(successSate)
		.clickContinueBUtton()
		.deleteAccount()
		.deleteinfo()
		.clickContinueindeleteAccount();
	
	}


}
