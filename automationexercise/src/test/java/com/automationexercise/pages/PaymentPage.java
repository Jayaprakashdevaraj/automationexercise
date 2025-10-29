package com.automationexercise.pages;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class PaymentPage extends TestNGHooks{
	private WaitConditions wait;
	
	public PaymentPage() {
		wait = new WaitConditions(getDriver());
	}
	
	public PaymentPage enterCardName(String CardName) {
		type(locateElement(Locators.XPATH, "//input[@name='name_on_card']"), CardName);
		return this;
	}

	
	public PaymentPage entercardNumber(String cardNumber) {
		type(locateElement(Locators.XPATH, "//input[@name='card_number']"), cardNumber);
		return this;
	}
	
	public PaymentPage enterCVV(String CVV) {
		type(locateElement(Locators.XPATH, "//input[@name='cvc']"), CVV);
		return this;
	}
	public PaymentPage enterMonth(String expiryMonth) {
		type(locateElement(Locators.XPATH, "//input[@name='expiry_month']"), expiryMonth);
		return this;
	}
	public PaymentPage enterYear(String expiryYear) {
		type(locateElement(Locators.XPATH, "//input[@name='expiry_year']"), expiryYear);
		return this;
	}
	
	public PaymentDonePage clickPayAndConfirm() {
		click(locateElement(Locators.ID, "submit"));
		return new PaymentDonePage();
	}
	
	
}
