package com.automationexercise.selenium.api.design;

import org.openqa.selenium.WebElement;

public interface Element {
	
	public void click(WebElement ele);

	public void click(WebElement ele, String jsExpression);

	public void type(WebElement ele, String data);

	public void typeAndEnter(WebElement ele, String data);
	
	public void clearAndType(WebElement ele, String data);

	public void dropdownSelectByValue(WebElement ele, String value);
	
	public void dropdownSelectByVisibleText(WebElement ele, String value);

	public String getElementText(WebElement ele);

	public String getAttributeValue(WebElement ele, String value);
	
	public void switchToFrame(WebElement ele);
	
	public void switchToMainDocument();
	
	public void acceptAlert();
	
	public void dismissAlert();
	
	public void alertText();
	
	public void hover(WebElement ele); 
	
	public void hoverAndClick(WebElement ele);
	
	

}