package com.supriya.ultimateqa.authentication.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.supriya.ultimateqa.authentication.pages.CreateAccountPage;
import com.supriya.ultimateqa.authentication.pages.HomePage;
import com.supriya.ultimateqa.authentication.pages.LoginPage;

public class CreateAccountPageTests {
	
    WebDriverWait wait;
	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	CreateAccountPage cp;
		
		@BeforeSuite
		public void configuration() {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			 driver = new ChromeDriver();
			driver.get("https://courses.ultimateqa.com/");
			driver.manage().window().maximize();
			hp =  new HomePage(driver);
			lp = new LoginPage(driver);
		}
		
		
		@Test
		public void createNewAccountTest() {
			
		hp.signInToApplication();
		cp=lp.navigateToCreateAccountlink();
		cp.createNewAccount("Alvin", "Ferns", "ferns123@gmail.com", "Ferns@123456");
		wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.urlToBe("https://courses.ultimateqa.com/collections"));
	    Assert.assertEquals(driver.getCurrentUrl(), "https://courses.ultimateqa.com/collections");
		
			
		}
		
		

}
