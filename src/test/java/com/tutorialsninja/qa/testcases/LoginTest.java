package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Titorialasninja.qa.utils.Utilities;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HOmepage;
import com.tutorialsninja.qa.pages.LoginPage;

public class LoginTest extends Base{
	
	LoginPage loginPage;
	public LoginTest() {
		super ();   //super means super class constructor  //parrent class constructor will be call
	}
	
	
	
	public WebDriver driver;

	
	@BeforeMethod
	public void setup() {
		
			
	
//		    driver=InitializebrowserOpenApplication(prop.getProperty(prop.getProperty("browers")));
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Login")).click();

			driver=InitializebrowserOpenApplication("firefox");
			HOmepage homepage=new HOmepage(driver);
			homepage.clickonMyaccount();
			loginPage = homepage.selectLoginOption();  //from page factory
	}
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	@Test(priority=1, dataProvider="validcredentialSupplier")
	public void verifyLogincredential(String email, String password) {
		
		
			
			loginPage.enteremailAdress(email);
			loginPage.enterpassword(password);
			loginPage.Clickonlogin();
//			driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail");
//			driver.findElement(By.id("input-password")).sendKeys(password);
//			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			AccountPage accoutpage=new AccountPage(driver);
			Assert.assertTrue(accoutpage.EditAccoiuntInfogetText(),"Edit ypur account infor acc is not displayed");  //if assert true then test will bepass otherswise it will throe exception
	
	}
	
	@DataProvider(name="validcredentialSupplier")
	public Object[][] supplyTestData() {
		
		Object[][] data= {{"rahul0396rathod@gmail.com","Test@123"},{"rr0699832@gmail.com","Test@123"},
				{"rr0699832@gmail.com","Test@123"}};
		return data;
		
	}
	
	
	
	
	
		@Test(priority=2)
		public void verifyloginwithInvalidcredential() {
			
			
			loginPage.enteremailAdress(Utilities.GenerateEmailWithTimestamp());
			loginPage.enterpassword(dataProp.getProperty("invalidPassword"));
			loginPage.Clickonlogin();
		
//			driver.findElement(By.id("input-email")).sendKeys(Utilities.GenerateEmailWithTimestamp());//here after 5 attemp system will give errror
//				//5 attams fails so for avoiding the fail test case here w r using date class for timestamp for providing everytime new date 
//			driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
//			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			String actual_warning_msg=loginPage.getTextActualWarningmsg();
			//String actual_warning_msg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();  //xpath by contains
			String expected_warning_msg=dataProp.getProperty("ExpectedWarningMsg");
			Assert.assertTrue(actual_warning_msg.contains(expected_warning_msg), "Expected warning msg is not displayed");
			
			
		
		}
		
		
			@Test(priority=3)
			public void verifyloginwithInvalidemanilandvalidPass() {
				
				
//				driver.findElement(By.id("input-email")).sendKeys(Utilities.GenerateEmailWithTimestamp());//here after 5 attemp system will give errror
//					//5 attams fails so for avoiding the fail test case here w r using date class for timestamp for providing everytime new date 
//				driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
//				driver.findElement(By.xpath("//input[@value='Login']")).click();
//				String actual_warning_msg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//				//String actual_warning_msg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();  //xpath by contains
//				String expected_warning_msg=dataProp.getProperty("ExpectedWarningMsg");
//				Assert.assertTrue(actual_warning_msg.contains(expected_warning_msg), "Expected warning msg is not displayed");
//				
				
				loginPage.enteremailAdress(dataProp.getProperty("invalidPassword"));
				loginPage.enterpassword(dataProp.getProperty("invalidPassword"));
				loginPage.Clickonlogin();
				String actual_warning_msg=loginPage.getTextActualWarningmsg();
				//String actual_warning_msg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();  //xpath by contains
				String expected_warning_msg=dataProp.getProperty("ExpectedWarningMsg");
				Assert.assertTrue(actual_warning_msg.contains(expected_warning_msg), "Expected warning msg is not displayed");
				
				
				
				
			}
			
			@Test(priority=4)
			public void VerifyLoginwithValidEmanilandinvalidPass() {
				
			
				driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));//here after 5 attemp system will give errror
					//5 attams fails so for avoiding the fail test case here w r using date class for timestamp for providing everytime new date 
				driver.findElement(By.id("input-password")).sendKeys("Test@1234");
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				String actual_warning_msg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
				//String actual_warning_msg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();  //xpath by contains
				String expected_warning_msg="Warning: No match for E-Mail Address and/or Password.";
				Assert.assertTrue(actual_warning_msg.contains(expected_warning_msg), "Expected warning msg is not displayed");
				
				
				
			}
			
			@Test(priority=5)
			public void verifyloginwithoutProvidingCredential() {
				
				
				driver.findElement(By.id("input-email")).sendKeys("");//here after 5 attemp system will give errror
					//5 attams fails so for avoiding the fail test case here w r using date class for timestamp for providing everytime new date 
				driver.findElement(By.id("input-password")).sendKeys("");
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				String actual_warning_msg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
				//String actual_warning_msg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();  //xpath by contains
				String expected_warning_msg="Warning: No match for E-Mail Address and/or Password.";
				Assert.assertTrue(actual_warning_msg.contains(expected_warning_msg), "Expected warning msg is not displayed");
				
				
				
			}
			
			
			
			
			
	

}
