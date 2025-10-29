package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC015_PlaceOrderRegisterbeforeCheckout  extends TestNGHooks{
	
	@DataProvider(name ="Quantity")
	public Object[][] readDate(){
		return DataHandler.getData("AutomationExerciseTestData", "placeorderwithRegUser");
	}
	
	@Test(dataProvider = "Quantity")
	public void verifyQuandity(String signupName, String signupEmail, String Title,String Password,String date, String month, String year, String FName,String LName,String Address1,String State,String City,String ZipCode,String MobileNumber,String firstReqProduct,  String description, String CardName, String cardNumber, String CVV, String expiryMonth, String expiryYear, String successSate
) {
		new HomePage().verifyPage().clickSignupLogin()
		.signupName(signupName)
		.signupEmailAddress(signupEmail)
		.clickSigninButton()
		.selectTitle(Title)
		.password(Password)
		.selectDate(date)
		.selectMonth(month)
		.selectYear(year)
		.selectNewsletter()
		.selectSpecialOption()
		.enterFirstName(FName)
		.enterLastName(LName)
		.enterAddress1(Address1)
		.enterState(State)
		.enterCity(City)
		.enterZipcode(ZipCode)
		.enterMobileNumber(MobileNumber)
		.clickCreateAccount()
		.clickContinue()
		.clickProduct()
		.selectProduct(firstReqProduct)
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
