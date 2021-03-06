package com.nitaraweb.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonHomePage extends BasePage{


	@FindBy(id="nav-link-accountList")
	public WebElement SignInButton;

	public AmazonHomePage() {
		PageFactory.initElements(driver, this);	
	}

	public void click_SignIn() {
		SignInButton.click();
	}

}
