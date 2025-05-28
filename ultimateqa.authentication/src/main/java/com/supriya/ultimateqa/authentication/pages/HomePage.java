package com.supriya.ultimateqa.authentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
WebDriver driver =null;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText = "Sign In")
	WebElement signInButtonField;
	
	public LoginPage signInToApplication() {
		signInButtonField.click();
		return new LoginPage(driver);
	}
	
	
	
}
