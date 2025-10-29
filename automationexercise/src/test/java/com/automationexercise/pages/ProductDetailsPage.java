package com.automationexercise.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class ProductDetailsPage extends TestNGHooks{
	
	private WaitConditions wait;
	
	public ProductDetailsPage() {
		wait= new WaitConditions(getDriver());
	}
	
	public ProductDetailsPage getProductName(String reqProduct) {
		String productName = getElementText(locateElement(Locators.XPATH, "//div[@class='product-information']/h2"));
		Assert.assertEquals(productName, reqProduct, "Product is matched");
/*		if(productName.equalsIgnoreCase(reqProduct)) {
			System.out.println(productName);
		}
*/		return this;
	}
	public ProductDetailsPage getCategory() {
		String productCategory = getElementText(locateElement(Locators.XPATH, "//div[@class='product-information']/p"));
			System.out.println(productCategory);		
		return this;
	}

	public ProductDetailsPage getPrice() {
		String productPrice = getElementText(locateElement(Locators.XPATH, "//div[@class='product-information']/span/span"));
			System.out.println(productPrice);		
		return this;
	}
	
	
	public ProductDetailsPage checkAvailablity() {
		String productAvailability = getElementText(locateElement(Locators.XPATH, "//div[@class='product-information']/p[2]"));
			System.out.println(productAvailability);		
		return this;
	}
	
	public ProductDetailsPage checkCondition() {
		String productcondition = getElementText(locateElement(Locators.XPATH, "//div[@class='product-information']/p[3]"));
			System.out.println(productcondition);		
		return this;
	}
	
	public ProductDetailsPage checkBrand() {
		String productBrand = getElementText(locateElement(Locators.XPATH, "//div[@class='product-information']/p[4]"));
			System.out.println(productBrand);		
		return this;
	}
	
	public ProductDetailsPage changeQuantity(String newQuantity) {
		clearAndType(locateElement(Locators.ID, "quantity"), newQuantity );
		return this;
	}
	

	public ProductDetailsPage clickAddToCart() {
		WebElement addtoCart = locateElement(Locators.XPATH, "//button[@type='button']");
		wait.waitUntilElementClickable(addtoCart);
		click(addtoCart);
		return this;
	}
	
	public ProductDetailsPage clickContinueShopping() {
		
		WebElement continueButton = locateElement(Locators.XPATH, "//button[text()='Continue Shopping']");
		wait.waitUntilElementClickable(continueButton);    
		click(continueButton);
		return this;
	}
	public ViewCartPage clickViewCart() {
	
		
		WebElement viewCart = locateElement(Locators.XPATH, "//u[text()='View Cart']");
		wait.waitUntilElementClickable(viewCart);
		click(viewCart);
//		 ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -200);");
//         ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", viewCart);
         return new ViewCartPage();
	}

	

}
