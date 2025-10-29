package com.automationexercise.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexercise.general.utils.DataHandler;
import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.pages.HomePage;

public class CreateNewAccount extends TestNGHooks{
	
	 @DataProvider(name = "signupData")
	    public Object[][] getSignupData() {
	        return DataHandler.getData("AutomationExerciseTestData", "SignupWithNewID");
	    }
	
	@Test(dataProvider = "signupData" )
	 public void signupTheAccount(String signupName, String signupEmail, String Title,String Password,String date, String month, String year, String FName,String LName,String Address1,String State,String City,String ZipCode,String MobileNumber) {
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
		.clickCreateAccount();
	}


}
