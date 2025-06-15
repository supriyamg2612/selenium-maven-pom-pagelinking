package com.supriya.ultimateqa.authentication.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.supriya.ultimateqa.authentication.pages.DashBoardPage;
import com.supriya.ultimateqa.authentication.pages.HomePage;
import com.supriya.ultimateqa.authentication.pages.LoginPage;
import com.supriya.ultimateqa.authentication.pages.MyDashBoardPage;


public class MyDashboardPageTest {
	
	WebDriver driver;
	DashBoardPage dp;
	MyDashBoardPage mp;
	LoginPage lp;
	HomePage hp;
	
	
	@BeforeClass
	public void configuration() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://courses.ultimateqa.com/");
		dp= new DashBoardPage(driver);
		lp= new LoginPage(driver);
		hp= new HomePage(driver);
		
	}
	
	@Test
	public void getMyDashboardPageTest() {
		hp.signInToApplication();
		dp=lp.validLogin();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		mp=dp.openMyDashboardPage();
		Assert.assertEquals(driver.getCurrentUrl(), "https://courses.ultimateqa.com/enrollments");
		
	
	}

	 @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
