package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class TC024_DownloadInvoiceAfterPurchaseOrder  extends TestNGHooks{
	
	@DataProvider(name ="Quantity")
	public Object[][] readDate(){
		return DataHandler.getData("AutomationExerciseTestData", "DownloadInvoice");
	}
	
	@Test(dataProvider = "Quantity")
	public void verifyQuandity(String firstReqProduct, String signupName, String signupEmail, String Title,String Password,String date, String month, String year, String FName,String LName,String Address1,String State,String City,String ZipCode,String MobileNumber, String description, String CardName, String cardNumber, String CVV, String expiryMonth, String expiryYear, String successSate
) {

		new HomePage()
		.verifyPage()
		.clickProduct()
		.clickViewProduct(firstReqProduct)
		.getProductName(firstReqProduct)
		.clickAddToCart()
		.clickViewCart()
		
		
		.clickProceedToCheckoutWithoutLogin()
		.clickRegisterOrLoginLink()
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
		.verifyloggedIntoApp()
		.clickCart()
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
		.clickDownloadInvoice()
		.clickContinueBUtton()
		.deleteAccount()
		.deleteinfo()
		.clickContinueindeleteAccount();
	
	}


}
