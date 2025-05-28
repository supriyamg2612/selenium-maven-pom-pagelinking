package com.supriya.ultimateqa.authentication.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.supriya.ultimateqa.authentication.pages.LoginPage;


public class LoginTests {
	
WebDriver driver = null;
	
	@BeforeSuite
	public void configuration() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://courses.ultimateqa.com/");
	}
	
	@Test
	public void testOne() {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication("celinaredden123@gmail.com", "Celinaredden123");
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout

		wait.until(ExpectedConditions.urlToBe("https://courses.ultimateqa.com/collections"));

		Assert.assertEquals(driver.getCurrentUrl(), "https://courses.ultimateqa.com/collections");
	}

}
