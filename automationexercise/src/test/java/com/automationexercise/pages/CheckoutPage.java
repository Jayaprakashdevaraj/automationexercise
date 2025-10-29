package com.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class CheckoutPage extends TestNGHooks{
	private WaitConditions wait;
	
	public CheckoutPage() {
		wait = new WaitConditions(getDriver());
	}
	
	public CheckoutPage getDeliveryDetails() {
		List<WebElement> delivery = locateElements(Locators.XPATH, "//ul[@id='address_delivery']/li");
		for (WebElement deliveryAddress : delivery) {
			System.out.println(getElementText(deliveryAddress));
		}
		return this;
	}
	
	public CheckoutPage getBillingDetails() {
		List<WebElement> billing = locateElements(Locators.XPATH, "//ul[@id='address_invoice']/li");
		for (WebElement billingAddress : billing) {
			System.out.println(getElementText(billingAddress));
		}
		return this;
	}
	public CheckoutPage enterDescription(String description) {
		type(locateElement(Locators.XPATH, "//textarea[@name='message']"), description);
		return this;
	}
	public PaymentPage clickPlaceOrder() {
		click(locateElement(Locators.XPATH, "//a[text()='Place Order']"));
		return new PaymentPage();
	}


	
}
