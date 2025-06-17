package com.supriya.ultimateqa.authentication.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.supriya.ultimateqa.authentication.pages.DashBoardPage;
import com.supriya.ultimateqa.authentication.pages.HomePage;
import com.supriya.ultimateqa.authentication.pages.LoginPage;
import com.supriya.ultimateqa.authentication.pages.UserMenuComponent;

public class UserMenuComponentTest {

	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	DashBoardPage dp;
	UserMenuComponent up;
	WebDriverWait wait;
	
	
	@BeforeClass

	public void configuration() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://courses.ultimateqa.com/");
		lp= new LoginPage(driver);
		hp= new HomePage(driver);
		dp = new DashBoardPage(driver);
		 hp.signInToApplication();
	     dp = lp.validLogin();
		
		
	}
	 @Test(priority = 1)
	public void testUserMenuButtonIsDisplayed() {
        Assert.assertTrue(dp.isUserMenuButtonDisplayed(), "User menu button should be visible on dashboard");
    }
	
	    @Test(priority = 2)
	public void verifyUserMenuButtonClickable() {
		
		up=dp.clickUserMenuButton();
        Assert.assertTrue(up.isDropdownVisible(), "Dropdown should be visible after clicking the user menu button");

	    }
	    
	    @Test(priority = 3,dependsOnMethods = {"verifyUserMenuButtonClickable"})

	    public void testMyAccountOptionIsDisplayed() {

	    Assert.assertTrue(up.isMyAccountVisible(), "'My Account' option should be displayed in dropdown");

	    }

	      

	    @Test(priority = 4, dependsOnMethods = {"verifyUserMenuButtonClickable"})

	    public void testSupportOptionIsDisplayed() {

	    Assert.assertTrue(up.isSupportVisible(), "'Support' option should be displayed in dropdown");

	    }

	      

	    @Test(priority = 5, dependsOnMethods = {"verifyUserMenuButtonClickable"})

	    public void testSignOutOptionIsDisplayed() {

	    Assert.assertTrue(up.isSignOutVisible(), "'Sign Out' option should be displayed in dropdown");

	    }

	    

	    @Test(priority = 5,dependsOnMethods = "verifyUserMenuButtonClickable")
	    public void verifyDropdownOptionsText() {
	        Assert.assertEquals(up.getMyAccountText(), "My Account");
	        Assert.assertEquals(up.getSupportText(), "Support");
	        Assert.assertEquals(up.getSignOutText(), "Sign Out");
	    }
	    
	  
	 @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
}
}
