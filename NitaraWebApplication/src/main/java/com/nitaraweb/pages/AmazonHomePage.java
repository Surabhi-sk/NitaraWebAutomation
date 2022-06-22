package com.nitaraweb.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonHomePage extends BasePage{


	@FindBy(id="PhoneNumber")
	public WebElement PhoneNumber;
	
	@FindBy(id="password_input")
	public WebElement Password;
	
	@FindBy(className = "btn")
	public WebElement btn;

	public AmazonHomePage() {
		PageFactory.initElements(driver, this);	
	}

	public void click_SignIn() {
		PhoneNumber.sendKeys("2270722909");
		Password.sendKeys("123456");
		btn.click();	
	}

}
