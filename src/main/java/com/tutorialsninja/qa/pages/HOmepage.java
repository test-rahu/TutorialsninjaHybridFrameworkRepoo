package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HOmepage {
	WebDriver driver;

	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropmenu;
	
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	public HOmepage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Actions
	
	public void clickonMyaccount() {  //above private element are access by these public method
		
		myAccountDropmenu.click();
	}
	
	public LoginPage selectLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);
		
	}
	
	
}
