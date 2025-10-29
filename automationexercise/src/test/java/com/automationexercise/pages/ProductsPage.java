package com.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class ProductsPage extends TestNGHooks{
	
	public WebElement productList;
	private WaitConditions wait;
	
	public ProductsPage() {
		wait = new WaitConditions(getDriver());
	}

	public ProductsPage verifyAllProducts() {
		
		String allProducts = getElementText(locateElement(Locators.XPATH, "//h2[text()='All Products']"));
		if(allProducts.equalsIgnoreCase("All Products")) {
			System.out.println("All product displayed");
		}
		return this;
	}
	public ProductsPage getAllProduct()  {
		List<WebElement> allProducts = locateElements(Locators.XPATH, "//div[@class='single-products']/div[@class='productinfo text-center']/p");
		for (WebElement productList : allProducts) {
			System.out.println(getElementText(productList));
		}
		return this;
	}
	

	public ProductDetailsPage selectProduct(String reqProduct) {
		click(locateElement(Locators.XPATH, "//p[contains(text(),'"+reqProduct+"')]/ancestor::div[@class='productinfo text-center']/following::div//a[contains(text(),'View Product')]"));
		return new ProductDetailsPage();
	}
	
	public ProductsPage searchProduct(String search) {
		type(locateElement(Locators.ID, "search_product"), search);
		click(locateElement(Locators.ID, "submit_search"));
		return this;		
	}
	
	
	public ProductsPage hoveTheProduct(String firstReqProduct) {

		WebElement productContainer = locateElement(Locators.XPATH,"//p[text()='"+firstReqProduct+"']//parent::div[@class='productinfo text-center']");
		wait.waitUnitlVisibilityOfElement(productContainer);
        hover(productContainer);
        System.out.println(productContainer.isDisplayed());
        System.out.println(productContainer.getLocation());
        return this;
	}
	
	public ProductsPage clickAddToBaginOverlay(String firstReqProduct) {
		
		WebElement addToCartBtn = locateElement(Locators.XPATH, "//p[text()='"+firstReqProduct+"']//parent::div[@class='overlay-content']/a[text()='Add to cart']");		
		wait.waitUntilElementClickable(addToCartBtn);
		click(addToCartBtn);
		return this;
	}
	
	public ProductsPage clickContinueShopping() {
		
		WebElement continueButton = locateElement(Locators.XPATH, "//button[text()='Continue Shopping']");
		wait.waitUntilElementClickable(continueButton);
//		 ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -200);");
//       ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", continueButton);
         
		click(continueButton);
		return this;
	}
/*	public ProductsPage clickAddToBaginOverlaySecondProduct(String secondReqProduct) {
		hoverAndClick(locateElement(Locators.XPATH, "//div[@class='overlay-content']/p[text()='"+secondReqProduct+"']/ancestor::div[@class='product-overlay']//a[text()='Add to cart']"));
		return this;
	}
*/	
	public ViewCartPage clickViewCart() {
		WebElement viewCart = locateElement(Locators.XPATH, "//u[text()='View Cart']");
		 ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -200);");
         ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", viewCart);
         return new ViewCartPage();
	}
	
	
	
}
