package com.supriya.ultimateqa.authentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMenuComponent {
	

	WebDriver driver =null;
	WebDriverWait wait;
	
	
	public UserMenuComponent(WebDriver driver) {
		this.driver=driver;
		 this.wait = new WebDriverWait(driver, 10);

		PageFactory.initElements(driver, this);
	}
	
	
	 @FindBy(id = "header-dropdown-menu")
	    WebElement dropdownMenu;
	 
	 @FindBy(xpath = "//li[@class='dropdown__menu-item']/a[contains(text(),'My Account')]")
	    WebElement myAccountLink;
	
	 @FindBy(xpath = "//li[@class='dropdown__menu-item']/a[contains(text(),'Support')]")
	    WebElement supportLink;

	  @FindBy(xpath = "//li[@class='dropdown__menu-item']/a[contains(text(),'Sign Out')]")
	    WebElement signOutLink;
	  
	  
	  public boolean isDropdownVisible() {
	        wait.until(ExpectedConditions.visibilityOf(dropdownMenu));
	        return dropdownMenu.isDisplayed();
	    }
	  
	  
	  public boolean isMyAccountVisible() {
	        wait.until(ExpectedConditions.visibilityOf(myAccountLink));
	        return myAccountLink.isDisplayed();
	    }
	  
	  
	  public boolean isSupportVisible() {
	        wait.until(ExpectedConditions.visibilityOf(supportLink));
	        return supportLink.isDisplayed();
	    }
	  

	    public boolean isSignOutVisible() {
	        wait.until(ExpectedConditions.visibilityOf(signOutLink));
	        return signOutLink.isDisplayed();
	    }
	    
	    
	    public String getMyAccountText() {
	        return myAccountLink.getText().trim();
	    }

	    public String getSupportText() {
	        return supportLink.getText().trim();
	    }

	    public String getSignOutText() {
	        return signOutLink.getText().trim();
	    }
	    
	    public MyAccountPage clickMyAccount() {
	        myAccountLink.click();
	        return new MyAccountPage(driver);
	    }
	    
	    public SupportPage clickSupport() {
	        supportLink.click();
			return new SupportPage(driver);
	    }
	    
	    public LoginPage clickSignOut() {
	        signOutLink.click();
	        return new LoginPage(driver);
	    }
	    
	    
	
	

}
