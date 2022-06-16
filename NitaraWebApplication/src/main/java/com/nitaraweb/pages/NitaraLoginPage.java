package com.nitaraweb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NitaraLoginPage extends BasePage{

	@FindBy(id="PhoneNumber")
	public WebElement phnNoField;
	
	@FindBy(id="password_input")
	public WebElement passwordField;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div[2]/div[4]/div[2]/form/button")
	public WebElement signInButton;
	
	public NitaraLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		phnNoField.sendKeys(phoneNumber);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void click_SignIn() {
		signInButton.click();
	}
}
