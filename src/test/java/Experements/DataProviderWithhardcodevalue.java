package Experements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithhardcodevalue {
	
	WebDriver driver;
	
	@Test(priority=1, dataProvider="supplyTestData")
	public void verifyLogincredential(String email, String password) {
		
			
			driver.findElement(By.id("input-email")).sendKeys(email);
			driver.findElement(By.id("input-password")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit ypur account infor acc is not displayed");  //if assert true then test will bepass otherswise it will throe exception
	
	}
	@DataProvider
	public Object[][] supplyTestData() {
		
		Object[][] data= {{"rahul0396rathod@gmail.com","Test@123"},{"rr0699832@gmail.com","Test@123"},
				{"rr0699832@gmail.com","Test@123"}};
		return data;
		
	}

}
