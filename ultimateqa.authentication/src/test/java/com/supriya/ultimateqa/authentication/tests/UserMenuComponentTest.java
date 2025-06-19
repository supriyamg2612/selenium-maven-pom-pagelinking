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
	    
	    @Test( priority = 6)
	    public void testSignOutFunctionality() {
	    	if (up == null || !up.isDropdownVisible()) {
	            up = dp.clickUserMenuButton();
	        }
	        Assert.assertTrue(up.isDropdownVisible(), "Dropdown should be visible after clicking the user menu button");
	        lp = up.clickSignOut();
	        String expectedTitle = "UltimateQA"; 
	    	    String actualTitle = driver.getTitle();
	    	    Assert.assertEquals(actualTitle, expectedTitle, "User should be redirected to Login page after sign out");

	    }
	    
	    @Test(priority = 7)
	    public void verifySupportLinkIsMailTo() {
	    	
	            hp.signInToApplication();  // Or appropriate login steps
	            dp = lp.validLogin();
	            up = null;
	            
	            wait = new WebDriverWait(driver, 15);
	            wait.until(ExpectedConditions.elementToBeClickable(dp.userMenuComponentButtonLink));
	        

	            up = dp.clickUserMenuButton();

	            // Wait explicitly for dropdown to be visible before getting href
	            wait.until(driver -> up.isDropdownVisible());

	            String href = up.getSupportLinkHref();
	            Assert.assertTrue(href.startsWith("mailto:info@ultimateqa.com"), "Support link should be mailto");
	        
	    }
	    
	  
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
}
}
