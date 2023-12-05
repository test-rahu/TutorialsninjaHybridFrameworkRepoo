package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class SearchTest extends Base {
	
	public SearchTest() {
		super ();   //super means super class constructor  //parrent class constructor will be call
	}
	
	
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=InitializebrowserOpenApplication("firefox");  //this method will return object of the driver
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifySearchwithValidProduct() {
		
		driver.findElement(By.xpath("(//input[@name='search'])[1]")).sendKeys(dataProp.getProperty("validsearch"));
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		//WebElement searchResult=driver.findElement(By.linkText("HP LP3065"));
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"valid HP isnot Displayed in the search result");  // if displayed then pass otherwise failed the test
		
	}
	
	@Test(priority=2)
		public void verifySearchwithInvalidProduct() {
		
		//div[@id='content']/h2/following-sibling::p
		driver.findElement(By.xpath("(//input[@name='search'])[1]")).sendKeys(dataProp.getProperty("invalidsearch"));
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		//WebElement searchResult=driver.findElement(By.linkText("HP LP3065"));
		String ActualSearchMsg= driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());  // if displayed then pass otherwise failed the test
		Assert.assertEquals(ActualSearchMsg, dataProp.getProperty("Expectedwarningsearchmsg"),"No prduct mesage in search results");
			
		}
		
	@Test(priority=3)
		public void verifySearchWithoutanyProduct() {
		driver.findElement(By.xpath("(//input[@name='search'])[1]")).sendKeys("");
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		String ActualSearchMsg= driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());  // if displayed then pass otherwise failed the test
		Assert.assertEquals(ActualSearchMsg, "There is no product that matches the search criteria.","No prduct mesage in search results");
			
		}
	
	
	
	
	
	
}
