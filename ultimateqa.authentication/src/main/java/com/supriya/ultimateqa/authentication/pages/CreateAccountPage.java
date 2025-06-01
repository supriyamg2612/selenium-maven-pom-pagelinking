package com.supriya.ultimateqa.authentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	
	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id = "user[first_name]")
	WebElement firstNameField;
	
	@FindBy(id = "user[last_name]")
	WebElement lastNameField;
	
	@FindBy(id = "user[email]")
	WebElement emailField;
	
	@FindBy(id = "user[password]")
	WebElement passwordField;
	
	@FindBy(id = "user[terms]")
	WebElement termsCheckboxField;
	
	@FindBy(css = "button[type='submit']")
	WebElement signUpButtonField;
	
	@FindBy(linkText =  "I already have an account")
	WebElement alreadyHaveAccountLinkField;
	
	
	public DashBoardPage createNewAccount(String firstName, String lastName, String email, String password) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		termsCheckboxField.click();
		signUpButtonField.click();
		return new DashBoardPage(driver);
		
	}
    
    
	
	
	

	
	

}
