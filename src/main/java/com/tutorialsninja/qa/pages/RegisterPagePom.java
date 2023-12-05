package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPagePom {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAcountButton;
	
	@FindBy(linkText="Register")
	private WebElement RegisterButton;
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(name="agree")
	private WebElement agreebutton;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	
	
	public RegisterPagePom(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickonMyAccountButton() {
		MyAcountButton.click();
		
	}
	
		public void ClickonRegisterButton() {
			RegisterButton.click();
			
		}
		
		public void EnterName(String name) {
			firstname.sendKeys(name);
			
		}
		
		public void Enterlastname(String lastnametext) {
			lastname.sendKeys(lastnametext);
		
		}
		
		public void Enteremail(String enteremail) {
			email.sendKeys(enteremail);
		}
		
		public void Entertelephone(String telephoneNo) {
			telephone.sendKeys(telephoneNo);
		}
		public void Enterpassword(String passwordText) {
			password.sendKeys(passwordText);
			
		}
		
		public void EnterconfirmPassword(String confirmpassword) {
			confirmPassword.sendKeys(confirmpassword);
			
		}
		
		public void clickonagreeButton() {
			
			agreebutton.click();	
			
		}
		
		public void ClickOnSubmitButton() {
			submitButton.click();
			
		}
}
