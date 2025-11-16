package com.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class CheckoutPage extends TestNGHooks{
	private WaitConditions wait;
	public WebElement deliveryAddress;
	
	public CheckoutPage() {
		wait = new WaitConditions(getDriver());
	}
	
	 public String getSignupAddress(String Title, String FName,String LName,String Address1,String City,String State,String ZipCode,String MobileNumber) {
		 return  "Your delivery address"+ "\n"
		+Title+" "+FName+" "+LName+ "\n"
		  +Address1+ "\n"	
		  +City+" "+State+" "+ZipCode+ "\n"
		  + "India"+ "\n"
		  +MobileNumber;		 
	 }
	
	public HomePage clickHome() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),' Home')]"));
		return new HomePage();
	}
	
	public CheckoutPage getDeliveryDetails() {
		List<WebElement> delivery = locateElements(Locators.XPATH, "//ul[@id='address_delivery']/li");
		for (WebElement deliveryAddress : delivery) {
			System.out.println(getElementText(deliveryAddress));
		}
		return this;
	}
	
	public String changeDeliveryDetailsformat() {
		StringBuilder uiAddress = new StringBuilder();
		uiAddress.append(getElementText(deliveryAddress).trim()).append("\n");
		return uiAddress.toString().trim();
	}
	
	public CheckoutPage verifyDeliveryDetails() {
		String actualDeliveryAddress = changeDeliveryDetailsformat().replaceAll("\\s+", " ").trim();
		String expectedAddress = getSignupAddress(actualDeliveryAddress, actualDeliveryAddress, actualDeliveryAddress, actualDeliveryAddress, actualDeliveryAddress, actualDeliveryAddress, actualDeliveryAddress, actualDeliveryAddress).replaceAll("\\s+", " ").trim();

/*	    if (!actualDeliveryAddress.equalsIgnoreCase(expectedAddress)) {
	        throw new AssertionError("\nEXPECTED:\n" + expectedAddress + "\n\nACTUAL:\n" + actualDeliveryAddress);
	    }else{
	    	System.out.println("address not correct");
	    }
*/
		Assert.assertEquals(actualDeliveryAddress, expectedAddress, "Address not matched");
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
