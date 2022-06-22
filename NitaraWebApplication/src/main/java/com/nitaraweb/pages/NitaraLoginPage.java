package com.nitaraweb.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NitaraLoginPage extends BasePage{
	

		@FindBy(id = "PhoneNumber")
		public WebElement phoneNumber;
		
		@FindBy(id = "password_input")
		public WebElement password;
		
		@FindBy(xpath  = "//*[@id=\"content\"]/div/div/div[2]/div[4]/div[2]/form/button")
		public WebElement sign_in;

		public NitaraLoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void click_SignIn() {
			phoneNumber.sendKeys(properties.getProperty("username"));
			password.sendKeys(properties.getProperty("password"));
			sign_in.click();	
		}
//		public void enterPhoneNumber(String phoneNumber) {
//			phoneNumber.sendKeys(properties.getProperty("username"));
//		}
//		
//		public void enterPassword(String password) {
//			password.sendKeys(password);
//		}
//		
//		public void click_SignIn() {
//			sign_in.click();
//		}

	
}
