package com.supriya.ultimateqa.authentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	
	WebDriver driver =null;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "h1.page-heading")
    WebElement collectionsHeading;
	
	@FindBy(xpath = "//a[@href='/enrollments' and normalize-space(text())='My Dashboard']")
    WebElement myDashboardLinkFiled;
	
	
	
	public MyDashBoardPage openMyDashboardPage() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(myDashboardLinkFiled));
		    
		myDashboardLinkFiled.click();		
		return new MyDashBoardPage(driver);
		
	}
	

	
	
	
}


