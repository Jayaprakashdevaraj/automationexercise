package com.automationexercise.selenium.api.base;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automationexercise.selenium.api.constants.Browsers;


public class DriverManager {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public void setDriver(Browsers browserName) {
		switch (browserName) {
		case CHROME:
			//driver.set(new ChromeDriver());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-notifications");
			options.addArguments("--blink-settings=imagesEnabled=false");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("profile.default_content_settings.popups", 2);
			options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			options.addArguments("--disable-blink-features=AutomationControlled");
			driver.set(new ChromeDriver(options));
			
			DevTools devTools = ((ChromeDriver) getDriver()).getDevTools();
			devTools.createSession();
			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), java.util.Optional.empty()));
			devTools.send(Network.setBlockedURLs(Arrays.asList(
			  "*.doubleclick.net",
			  "*.googlesyndication.com",
			  "*ads*"
			)));
			break;
		case EDGE:
			driver.set(new EdgeDriver());
			break;
		case FIREFOX:
			driver.set(new FirefoxDriver());
			break;
		default:
			throw new IllegalArgumentException("Currently, given browser option wasn't support by this framework");
		}
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}

}