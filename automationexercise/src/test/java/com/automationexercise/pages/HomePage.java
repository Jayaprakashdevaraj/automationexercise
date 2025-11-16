package com.automationexercise.pages;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.testng.Assert;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class HomePage extends TestNGHooks {

	private WaitConditions wait;

	public HomePage() {
		wait = new WaitConditions(getDriver());
	}

	public HomePage verifyPage() {
		WebElement homeOption = wait.waitUnitlVisibilityOfElement(
				locateElement(Locators.XPATH, "//a[text()=' Home'][@style='color: orange;']"));
		System.out.println("user in homePage");
		return this;
	}

	public SignupLoginPage clickSignupLogin() {
		click(locateElement(Locators.XPATH, "//a[text()=' Signup / Login']"));
		return new SignupLoginPage();
	}

	public AccountDeletePage deleteAccount() {
		WebElement deleteOption = locateElement(Locators.XPATH, "//a[text()=' Delete Account']");
		if (deleteOption.isDisplayed()) {
			click(deleteOption);
		}
		return new AccountDeletePage();
	}

	public HomePage verifyloggedIntoApp() {
		String username = getElementText(locateElement(Locators.XPATH, "//a[text()=' Logged in as ']/b"));
		System.out.println(username);
		return this;
	}

	public SignupLoginPage clickLogoutButton() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),'Logout')]"));
		return new SignupLoginPage();
	}

	public ContactusPage clickContactus() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),'Contact us')]"));
		return new ContactusPage();
	}

	public TestCasePage clickTestCaseButton() {
		click(locateElement(Locators.XPATH, "//button[text()='Test Cases']"));
		return new TestCasePage();
	}

	public ProductsPage clickProduct() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),'Products')]"));
		return new ProductsPage();
	}

	public HomePage verifySubcribeHeader() {
		String elementText = getElementText(locateElement(Locators.XPATH, "//div[@class='single-widget']"));

		// Assert.assertEquals(elementText, "Subscription");
		return this;
	}
	
	public HomePage scrolltillSubcribeHeader() {
		WebElement subscribe = locateElement(Locators.XPATH, "//div[@class='single-widget']");
		scrollToElement(subscribe);
		return this;
	}
	
	public HomePage clickScrollUpArrow() {
		click(locateElement(Locators.ID, "scrollUp"));
		return this;
	}
	
	
	public HomePage scrollToTop() {
		WebElement subscribe = locateElement(Locators.XPATH, "//div[@class='carousel-inner']//h2");
		scrollToElement(subscribe);
		return this;
	}
	
	public HomePage getInfoAfterClickArrowUpButton() {
		String titleinfo = getElementText(locateElement(Locators.XPATH, "//div[@class='carousel-inner']//h2"));
		System.out.println(titleinfo);
		return this;
	}

	public HomePage clickSusbscribeEmail(String Email) {
		type(locateElement(Locators.ID, "susbscribe_email"), Email);

		return this;
	}

	public ViewCartPage clickCart() {
		click(locateElement(Locators.XPATH, "//a[contains(text(),'Cart')]"));
		return new ViewCartPage();
	}

	public HomePage verifyLeftSidebar(String CategoryHeader) {
		String cat = getElementText(locateElement(Locators.XPATH, "//div[@class='left-sidebar']/h2"));
		Assert.assertEquals(cat, CategoryHeader);
		return this;
	}

	public HomePage clickCategory(String requiredCategory) {
		click(locateElement(Locators.XPATH, "//a[@href='#" + requiredCategory + "']"));
		return this;
	}

	public ProductsPage clickDressinWoman() {

		WebElement dress = locateElement(Locators.XPATH, "//a[contains(text(),'Dress')]");
		wait.waitUntilElementClickable(dress);
		click(dress);
		return new ProductsPage();
	}

	public HomePage verifyRecommendedItemHeader() {
		WebElement recommended = locateElement(Locators.XPATH, "//div[@class='recommended_items']");
		Assert.assertTrue(recommended.isDisplayed(), "recommended items header is not display");
		System.out.println(getElementText(recommended));
		return this;

	}

	
	public HomePage getAllRecommendedProduct() { List<WebElement>
	  allRecommendedProducts = locateElements(Locators.XPATH,"//div[@id='recommended-item-carousel']//div[@class='productinfo text-center']/p");
		for (WebElement productList : allRecommendedProducts) {
			System.out.println(getElementText(productList)); 
		} 
		return this; 
	}
	 
	public HomePage clickaddToBag(String reqProduct) {
		click(locateElement(Locators.XPATH,
				"//div[@id='recommended-item-carousel']//div[@class='productinfo text-center']/p[text()='" + reqProduct
						+ "']//following::a"));
		return this;
	}

	public ViewCartPage clickViewCart() {
		WebElement viewCart = locateElement(Locators.XPATH, "//u[text()='View Cart']");
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -200);");
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", viewCart);
		return new ViewCartPage();
	}

/*	public HomePage getAllRecommendedProducts() {
		List<WebElement> visibleProducts = locateElements(Locators.XPATH,
				"//div[@id='recommended-item-carousel']//div[@class='productinfo text-center']/p");
		Set<String> allProducts = new LinkedHashSet<>();

		while (true) {
			int before = allProducts.size();

			for (WebElement product : visibleProducts) {
				String name = product.getText().trim();
				if (!name.isEmpty()) {
					allProducts.add(name);
				}
			}

			try {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
						"//a[@class='right recommended-item-control']");
				Thread.sleep(1000);
			} catch (Exception e) {
				break; // exit when carousel can't move
			}

			if (allProducts.size() == before)
				break;
		}

		//return new ArrayList<>(allProducts);
		return this;
	}
*/
}
