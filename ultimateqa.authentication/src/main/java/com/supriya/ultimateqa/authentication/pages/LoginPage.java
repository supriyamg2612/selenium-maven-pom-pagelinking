package com.supriya.ultimateqa.authentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver =null;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user[email]")
	WebElement emailField;
	
	@FindBy(id="user[password]")
	WebElement passwordField;
	
	@FindBy(css="button[type='submit']")
	WebElement signInButtonField;
	
	@FindBy(css = "a[href='/users/sign_up']")
	WebElement createAccountField;

  
	
	
	public void loginToApplication(String uname, String pass) {
		emailField.sendKeys(uname);
		passwordField.sendKeys(pass);
		signInButtonField.click();
	
		
	

}
}
