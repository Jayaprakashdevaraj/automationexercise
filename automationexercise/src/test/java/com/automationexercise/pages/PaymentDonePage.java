package com.automationexercise.pages;

import org.testng.Assert;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class PaymentDonePage  extends TestNGHooks{
	private WaitConditions wait;
	private String orderState;
	public PaymentDonePage() {
		wait = new WaitConditions(getDriver());
	}
	
	public PaymentDonePage getPaymentStatusHeader() {
		orderState = getElementText(locateElement(Locators.XPATH, "//h2[@data-qa='order-placed']/b"));
		return this;
	}
	
	public PaymentDonePage verifyPaymentState(String successSate) {
		Assert.assertEquals(orderState, successSate);
		return this;
	}

	public PaymentDonePage clickDownloadInvoice() {
	click(locateElement(Locators.XPATH, "//a[text()='Download Invoice']"));
		return this;
	}
	
	public HomePage clickContinueBUtton() {
		click(locateElement(Locators.XPATH, "//a[text()='Continue']"));
			return new HomePage();
		}

	
	
}
