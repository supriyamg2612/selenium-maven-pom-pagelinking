package com.supriya.ultimateqa.authentication.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.supriya.ultimateqa.authentication.pages.CreateAccountPage;
import com.supriya.ultimateqa.authentication.pages.DashBoardPage;
import com.supriya.ultimateqa.authentication.pages.HomePage;
import com.supriya.ultimateqa.authentication.pages.LoginPage;

public class DashBoardTests {
	
	
	  
		
		WebDriver driver;
		LoginPage lp;
		DashBoardPage dp;
		CreateAccountPage cp;
		 WebDriverWait wait;
		 HomePage hp;
		 
		
		
		
			@BeforeClass

		public void configuration() {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			 driver = new ChromeDriver();
			driver.get("https://courses.ultimateqa.com/");
			driver.manage().window().maximize();
			lp = new LoginPage(driver);
			hp =  new HomePage(driver);
			
		}
		
		@Test
		public void openDashboardPageAfterValidLogin() {
			lp = hp.signInToApplication();
			dp =lp.validLogin();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlToBe("https://courses.ultimateqa.com/collections"));
		    Assert.assertEquals(driver.getCurrentUrl(), "https://courses.ultimateqa.com/collections");
			
		
		}
		
		 @AfterClass
		    public void tearDown() {
		        driver.quit();
		    }
		
		
}
