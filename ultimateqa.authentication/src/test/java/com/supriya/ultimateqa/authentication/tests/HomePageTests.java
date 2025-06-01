package com.supriya.ultimateqa.authentication.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.supriya.ultimateqa.authentication.pages.HomePage;

public class HomePageTests {
	
WebDriver driver;
HomePage hp;
	
	@BeforeSuite
	public void configuration() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://courses.ultimateqa.com/");
		hp= new HomePage(driver);
	}
	
	@Test
	public void signToApplicationTest() {
		
		hp.signInToApplication();
		Assert.assertEquals(driver.getCurrentUrl(), "https://courses.ultimateqa.com/users/sign_in");
	}
	
	@AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
