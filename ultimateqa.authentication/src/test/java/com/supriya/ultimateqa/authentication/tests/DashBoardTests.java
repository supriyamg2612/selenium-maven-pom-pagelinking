package com.supriya.ultimateqa.authentication.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.supriya.ultimateqa.authentication.pages.DashBoardPage;
import com.supriya.ultimateqa.authentication.pages.LoginPage;

public class DashBoardTests {
	
	
	  
		
		WebDriver driver;
		LoginPage lp;
		DashBoardPage dp;
		 WebDriverWait wait;
		
		
		
		@BeforeSuite
		public void configuration() {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			 driver = new ChromeDriver();
			driver.get("https://courses.ultimateqa.com/");
			driver.manage().window().maximize();
			lp = new LoginPage(driver);
		}
		
		@Test
		public void openDashboardPage() {
			dp =lp.validLogin();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlToBe("https://courses.ultimateqa.com/collections"));
		    Assert.assertEquals(driver.getCurrentUrl(), "https://courses.ultimateqa.com/collections");
			
		
		}

}
