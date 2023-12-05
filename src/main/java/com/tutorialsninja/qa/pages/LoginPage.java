package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailAdressField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement actualwarningmsg;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enteremailAdress(String emailText) {
		emailAdressField.sendKeys(emailText);
		
	}
	
	public void enterpassword(String passwordtext) {
		passwordField.sendKeys(passwordtext);
		
	}
	
	public void Clickonlogin() {
		loginButton.click();
		
	}
	
	public String getTextActualWarningmsg() {
		
		String actualwarning=actualwarningmsg.getText();
		return actualwarning ;
	}
	
	

}
