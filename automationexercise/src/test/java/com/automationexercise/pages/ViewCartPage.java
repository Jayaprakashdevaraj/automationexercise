package com.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class ViewCartPage extends TestNGHooks{
	
	
	private WaitConditions wait; 
    private List<WebElement> allProducts = locateElements(Locators.XPATH, "//h4/a");;

	
	public ViewCartPage() {
		wait = new WaitConditions(getDriver());
	}
	
	public ViewCartPage getAllProdutsinCart() {
		List<WebElement> allProducts = locateElements(Locators.XPATH, "//table[@id='cart_info_table']/tbody/tr/td[@class='cart_description']/h4/a");
		for (WebElement ProductList : allProducts) {
			
			System.out.println(getElementText(ProductList));
		}
		return this;
	}
	
	public ViewCartPage verifyTheProduct(String reqProduct) {

		for (WebElement ProductList : allProducts) {
			
			Assert.assertTrue(((List<WebElement>) ProductList).contains(reqProduct), 
			        "Product '" + reqProduct + "' not found in product list: " );
			System.out.println(getElementText(ProductList));
		}
		return this;
	}
	
	public void indivualProduct(String productName) {
        String xpath = "//table[@id='cart_info_table']//tr[td//a[text()='" + productName + "']]//td[3]/p";
	}
	
	public ViewCartPage getAllProductsPrice() {
	//	List<WebElement> allProducts = locateElements(Locators.XPATH, "//h4/a");
		for (WebElement ProductList : allProducts) {
			List<WebElement> allProductsPrice = locateElements(Locators.XPATH, "//table[@id='cart_info_table']//tr[td//a[text()='"+ getElementText(ProductList) +"']]//td[3]/p");
			for (WebElement price : allProductsPrice) {
				System.out.println(getElementText(ProductList) +" price is "+getElementText(price));	
			}
		}
		return this;
	}
	
	public ViewCartPage getAllProductsQuantity() {
	//	List<WebElement> allProducts = locateElements(Locators.XPATH, "//h4/a");
		for (WebElement ProductList : allProducts) {
			List<WebElement> allProductsQuantity = locateElements(Locators.XPATH, "//table[@id='cart_info_table']//tr[td//a[text()='"+ getElementText(ProductList) +"']]//td[4]/button");
				for (WebElement quantity : allProductsQuantity) {
					System.out.println(getElementText(ProductList) +" quantity is "+getElementText(quantity));	
				}
			}
		return this;
	}
	
	public ViewCartPage clickProceedToCheckoutWithoutLogin() {
		click(locateElement(Locators.XPATH, "//a[text()='Proceed To Checkout']"));
		return this;
	}
	
	public CheckoutPage clickProceedToCheckoutWithLogin() {
		click(locateElement(Locators.XPATH, "//a[text()='Proceed To Checkout']"));
		return new CheckoutPage();
	}
	
	public SignupLoginPage clickRegisterOrLoginLink() {
		click(locateElement(Locators.XPATH, "//u[text()='Register / Login']"));
		return new SignupLoginPage();
	}
	
	public ViewCartPage verifySubcribeHeader() {
		String elementText = getElementText(locateElement(Locators.XPATH, "//div[@class='single-widget']"));
		
		//Assert.assertEquals(elementText, "Subscription");
		return this;
	}
	
	public ViewCartPage clickSusbscribeEmail(String Email) {
		type(locateElement(Locators.ID, "susbscribe_email") , Email);
		
		return this;
	}
	
	public ViewCartPage deleteSingleProduct(String firstReqProduct) {
		click(locateElement(Locators.XPATH, "//table[@id='cart_info_table']//tr[td//a[text()='"+ firstReqProduct +"']]//td[6]"));
		return this;
	}
	
	public SignupLoginPage clickSignupLogin() {
		click(locateElement(Locators.XPATH, "//a[text()=' Signup / Login']"));
		return new SignupLoginPage();
	}

}
