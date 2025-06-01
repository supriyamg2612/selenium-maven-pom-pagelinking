package com.supriya.ultimateqa.authentication.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver =null;
	WebDriverWait wait;
	
	
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
	
	@FindBy(linkText =  "Create a new account")
	WebElement createNewAccountField;
	
	

    public void  loginToApplication(String uname, String pass) {
		emailField.sendKeys("ferns123@gmail.com");
		passwordField.sendKeys("Ferns@123456");
		signInButtonField.click();
		
	
		
	}
    public DashBoardPage validLogin() {
    	emailField.sendKeys(null);
    	passwordField.sendKeys(null);
    	signInButtonField.click();
    	return new DashBoardPage(driver);
    }
    
    
    public CreateAccountPage navigateToCreateAccountlink() {
    	//driver.switchTo().frame(null)
    	  wait = new WebDriverWait(driver, 15);
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Create a new account")));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", createNewAccountField);
    	wait.until(ExpectedConditions.elementToBeClickable(createNewAccountField));
    	createNewAccountField.click();
    	
    	
        return new CreateAccountPage(driver);
}
}