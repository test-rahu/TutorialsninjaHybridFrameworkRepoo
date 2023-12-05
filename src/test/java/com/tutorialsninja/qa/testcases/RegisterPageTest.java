package com.tutorialsninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Titorialasninja.qa.utils.Utilities;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.RegisterPagePom;

public class RegisterPageTest extends Base{
	
	RegisterPagePom registerpage;
	
	public RegisterPageTest() {
		super ();   //super means super class constructor  //parrent class constructor will be call
	}
	
	public WebDriver driver;

	
	@BeforeMethod
	public void setup() {
		
		
		driver=InitializebrowserOpenApplication("firefox");  	//w r getting driver from this method so we have write driver and store
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Register")).click();
//		
		registerpage=new RegisterPagePom(driver);
		registerpage.ClickonMyAccountButton();
		registerpage.ClickonRegisterButton();
		
		
	}
	
	
	
	@AfterMethod(enabled=false)
	public void teardown() {
		
		driver.quit();
		
	}
	
	
	
	@Test(priority=1)
	public void VerifiRegisterAccount() {
		
		
//	driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstname"));
//	driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastname"));
//	driver.findElement(By.id("input-email")).sendKeys(Utilities.GenerateEmailWithTimestamp());
//	driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telefone"));
//	driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
//	driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validpassword"));
//	driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		registerpage.EnterName(dataProp.getProperty("firstnamee"));
		registerpage.Enterlastname(dataProp.getProperty("lastname"));
		registerpage.Enteremail(Utilities.GenerateEmailWithTimestamp());
		registerpage.Entertelephone(dataProp.getProperty("telefone"));
		registerpage.Enterpassword(prop.getProperty("validpassword"));
		registerpage.EnterconfirmPassword(prop.getProperty("validpassword"));
		registerpage.clickonagreeButton();
		registerpage.ClickOnSubmitButton();
	
	String actualSuccessHeading= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("successregistermassage"), "Account success page is not Displayed");
	
	
	
}
	@Test(priority=2)
	public void veriRegisterPagewithAllMandotoryFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.GenerateEmailWithTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telefone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String actualSuccessHeading= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("successregistermassage"), "Account success page is not Displayed");
		
		
	}
	
	@Test(priority=3)
	public void VerifyRegisterpagewithExistingEmail() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("rahul");
		driver.findElement(By.id("input-lastname")).sendKeys("rathod");
		driver.findElement(By.id("input-email")).sendKeys("rr0699832@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123456");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ActualWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(ActualWarning.contains("Warning: E-Mail Address is already registered!"), "warning msg is not displayed regarding duplicate email");
		
	}
	
	@Test(priority=4)
	public void verifyRegisterpageWithoutFillingAnyDetails() {
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String actual_privacy_policy=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actual_privacy_policy.contains("Warning: You must agree to the Privacy Policy!"),"not displayed the top warning msg");
		
		String actualFirstNameWarning= driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText();
		Assert.assertEquals(actualFirstNameWarning, "First Name must be between 1 and 32 characters!","First name warning msg is not displayed");
		
		String actualLastNameWarning= driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div")).getText();
		Assert.assertEquals(actualLastNameWarning, "Last Name must be between 1 and 32 characters!","Last name warning msg is not displayed");
		
		String actualEmailWarning= driver.findElement(By.xpath("//input[@name='email']/following-sibling::div")).getText();
		Assert.assertEquals(actualEmailWarning, "E-Mail Address does not appear to be valid!","Email warning msg is not displayed");
		
		String actualTelefoneWarning= driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div")).getText();
		Assert.assertEquals(actualTelefoneWarning, "Telephone must be between 3 and 32 characters!","Telefone warning msg is not displayed");
		
		String actualpasswordWarning= driver.findElement(By.xpath("//input[@name='password']/following-sibling::div")).getText();
		Assert.assertEquals(actualpasswordWarning, "Password must be between 4 and 20 characters!","password warning msg is not displayed");
		
	}
	
	
}
