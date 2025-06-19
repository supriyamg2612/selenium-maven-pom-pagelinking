package com.supriya.ultimateqa.authentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	
	WebDriver driver =null;
	WebDriverWait wait;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		 this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "h1.page-heading")
    WebElement collectionsHeading;
	
	@FindBy(xpath = "//a[@href='/enrollments' and normalize-space(text())='My Dashboard']")
    WebElement myDashboardLinkFiled;
	
	@FindBy(xpath = "//button[contains(@class,'dropdown__toggle-button')]")
	public
	WebElement userMenuComponentButtonLink;
	
	 @FindBy(id="header-dropdown-menu")
	    WebElement dropdownMenu; // Note: this is used inside UserMenuComponent
	
	
	public MyDashBoardPage openMyDashboardPage() {
		
		
	    wait.until(ExpectedConditions.elementToBeClickable(myDashboardLinkFiled));
		    
		myDashboardLinkFiled.click();		
		return new MyDashBoardPage(driver);
		
	}
	
	
	 public boolean isUserMenuButtonDisplayed() {
	        wait.until(ExpectedConditions.visibilityOf(userMenuComponentButtonLink));
	        return userMenuComponentButtonLink.isDisplayed();
	    }
	
	 public UserMenuComponent clickUserMenuButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(userMenuComponentButtonLink));
	        userMenuComponentButtonLink.click();
	        return new UserMenuComponent(driver);
	    }
	

	
	
	
}


