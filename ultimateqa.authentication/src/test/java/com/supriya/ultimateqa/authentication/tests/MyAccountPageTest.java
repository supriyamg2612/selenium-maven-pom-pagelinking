package com.supriya.ultimateqa.authentication.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.supriya.ultimateqa.authentication.pages.DashBoardPage;
import com.supriya.ultimateqa.authentication.pages.HomePage;
import com.supriya.ultimateqa.authentication.pages.LoginPage;
import com.supriya.ultimateqa.authentication.pages.MyAccountPage;
import com.supriya.ultimateqa.authentication.pages.UserMenuComponent;

public class MyAccountPageTest {
	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	DashBoardPage dp;
	UserMenuComponent up;
	WebDriverWait wait;
	MyAccountPage myAccountPage;
	
	
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
	
	 @Test
	    public void testMyAccountNavigationAndTitle() {
		 up=dp.clickUserMenuButton();
		 myAccountPage = up.clickMyAccount();
		 String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, "Edit Profile - UltimateQA", "Page title does not match for My Account page");

		 
	 }

}
