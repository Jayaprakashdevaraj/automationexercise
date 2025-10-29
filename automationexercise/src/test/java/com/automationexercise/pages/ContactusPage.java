package com.automationexercise.pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.testng.Assert;

import com.automationexercise.hooks.TestNGHooks;
import com.automationexercise.selenium.api.base.WaitConditions;
import com.automationexercise.selenium.api.constants.Locators;

public class ContactusPage extends TestNGHooks{
	
	private WaitConditions wait;
	
	public ContactusPage() {
		wait = new WaitConditions(getDriver());
	}
	
	public ContactusPage verifyGetInTouch() {
		String title = getElementText(locateElement(Locators.XPATH, "//h2[text()='Get In Touch']"));
		System.out.println(title);
		return this;
	}
	
	
	public ContactusPage enterName(String name) {
		type(locateElement(Locators.XPATH, "//input[@name='name']"), name);
		return this;
	}
	public ContactusPage enterEmail(String email) {
		type(locateElement(Locators.XPATH, "//input[@name='email']"), email);
		return this;
	}
	public ContactusPage enterSubject(String subject) {
		type(locateElement(Locators.XPATH, "//input[@name='subject']"), subject);
		return this;
	}
	public ContactusPage enterMessage(String message) {
		type(locateElement(Locators.XPATH, "//textarea[@name='message']"), message);
		return this;
	}
	public ContactusPage uploadFile() {
		File file = new File("src/main/resources/data/AutomationExerciseTestData.xlsx");
        String absolutePath = file.getAbsolutePath();
        
		type(locateElement(Locators.XPATH, "//input[@name='upload_file']"), absolutePath);
		return this;
	}
	public ContactusPage clickSubmitButton() {
		click(locateElement(Locators.XPATH, "//input[@name='submit']"));
		return this;
	}
	
	public ContactusPage clickOKinAlert() {
		acceptAlert();
		return this;
	}
	public ContactusPage checkSuccessMessage(String successmessage) {
		String elementText = getElementText(locateElement(Locators.XPATH, "//div[@class='status alert alert-success']"));
		if(elementText.equalsIgnoreCase(successmessage)) {
			System.out.println("Details submitted successfully");
		}
		return this;
	}


}
