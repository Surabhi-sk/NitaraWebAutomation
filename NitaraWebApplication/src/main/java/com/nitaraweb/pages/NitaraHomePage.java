package com.nitaraweb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NitaraHomePage extends BasePage{

	public NitaraHomePage() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/div[2]/div/div/label")
	public WebElement totalCattleCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]")
	public WebElement curCattleCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div[1]/div/div/div/div[3]/div/span[1]")
	public WebElement curBullCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div/div/div[3]/div/span[1]")
	public WebElement curCalfCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[2]/div/div/div[3]/div[1]/div/div/div/div[3]/div/span[1]")
	public WebElement curMilchCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[2]/div/div/div[3]/div[2]/div/div/div/div[3]/div/span[1]")
	public WebElement curHeiferCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement curOpenCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/span[1]")
	public WebElement curInseminatedCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/span[1]")
	public WebElement curPregnantCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[4]/span[1]")
	public WebElement curDryCount;
	
	// Method to get total count of various cattle types
	public String getCattleCount(String cattleType) {
		String count = "";
		if(cattleType.equals("bull")) {
			count = curBullCount.getText();
		} else if(cattleType.equals("calf")) {
			count = curCalfCount.getText();
		} else if(cattleType.equals("milch")) {
			count = curMilchCount.getText();
		} else if(cattleType.equals("heifer")) {
			count = curHeiferCount.getText();
		} else if(cattleType.equals("cur_cattle")) {
			count = curCattleCount.getText().substring(0, 2);
		} else {
			count = totalCattleCount.getText();
		}
		
		return count.replaceAll("\\s", "");
	}
	
	// Method to get breeding status of various cattle types
	public String getBreedingCattleCount(String status) {
		String count = "";
		if(status.equals("open")) {
			count = curOpenCount.getAttribute("textContent");
		} else if(status.equals("inseminated")) {
			count = curInseminatedCount.getAttribute("textContent");
		} else if(status.equals("pregnant")) {
			count = curPregnantCount.getAttribute("textContent");
		} else if(status.equals("dry")) {
			count = curDryCount.getAttribute("textContent");
		}
		
		return count.replaceAll("\\s", "");
	}
	
	// Method to select options from filter
	public void chooseFilter(String option) {
		WebElement optionRadioButton = null;
		
		if(option.equals("all")) {
			optionRadioButton = driver.findElement(By.id("all"));
		} else if(option.equals("cow")) {
			optionRadioButton = driver.findElement(By.id("cow"));
		} else if(option.equals("buffalo")) {
			optionRadioButton = driver.findElement(By.id("buffalo")); 
		}
		
		optionRadioButton.click();
	}
}