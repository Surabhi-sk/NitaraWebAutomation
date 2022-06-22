package com.nitaraweb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NitaraHomePage extends BasePage{

	public NitaraHomePage() {
		PageFactory.initElements(driver, this);
	}	
	
//  <!----------  Cattle Breakdown  ---------->
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
//  <!----------  Cattle Breakdown  ---------->
	
	
//  <!----------  Farm Breeding Status  ---------->
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement curOpenCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/span[1]")
	public WebElement curInseminatedCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/span[1]")
	public WebElement curPregnantCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[4]/span[1]")
	public WebElement curDryCount;
//  <!----------  Farm Breeding Status  ---------->
	
	
//  <!----------  Upcoming Activity : Breeding  ---------->
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/span[1]")
	public WebElement upcomingHeatCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[1]/span[1]")
	public WebElement upcomingCalvingCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/span[1]")
	public WebElement upcomingDryPeriodCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/span[1]")
	public WebElement upcomingPregnancyDiagnosisCount;
//  <!----------  Upcoming Activity : Breeding  ---------->
	
	
//  <!----------  Upcoming Activity : Health  ---------->
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/span[1]")
	public WebElement upcomingVaccinationsHS;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[2]/div[2]/span[1]")
	public WebElement upcomingVaccinationsBQ;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[3]/div[2]/span[1]")
	public WebElement upcomingVaccinationsFMD;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[4]/div[2]/span[1]")
	public WebElement upcomingVaccinationsBrucellosis;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[5]/div[2]/span[1]")
	public WebElement upcomingVaccinationsIBR;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[6]/div[2]/span[1]")
	public WebElement upcomingVaccinationsTheileria;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[7]/div[2]/span[1]")
	public WebElement upcomingVaccinationsAnthrax;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[8]/div[2]/span[1]")
	public WebElement upcomingVaccinationsRabies;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[3]/div[1]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement upcomingFollowUpsCount;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[3]/div[2]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement upcomingDewormingCount;
//  <!----------  Upcoming Activity : Health  ---------->
	
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
	
	// Method to get status of various upcoming breeding activities
	public String getUpcomingBreedingStatus(String activity) {
		String count = "";
		
		if(activity.equals("heat")) {
			count = upcomingHeatCount.getAttribute("textContent");
		} else if(activity.equals("calving")) {
			count = upcomingCalvingCount.getAttribute("textContent");
		} else if(activity.equals("pregnancy_diagnosis")) {
			count = upcomingPregnancyDiagnosisCount.getAttribute("textContent");
		} else if(activity.equals("dry_period")) {
			count = upcomingDryPeriodCount.getAttribute("textContent");
		}
		
		return count.replaceAll("\\s", "");
	}
	
	// Method to get status of various upcoming health activities
	public String getUpcomingHealthStatus(String activity) {
		String count = "";
		
		if(activity.equals("hs")) {
			count = upcomingVaccinationsHS.getAttribute("textContent");
		} else if(activity.equals("bq")) {
			count = upcomingVaccinationsBQ.getAttribute("textContent");
		} else if(activity.equals("fmd")) {
			count = upcomingVaccinationsFMD.getAttribute("textContent");
		} else if(activity.equals("brucellosis")) {
			count = upcomingVaccinationsBrucellosis.getAttribute("textContent");
		} else if(activity.equals("ibr")) {
			count = upcomingVaccinationsIBR.getAttribute("textContent");
		} else if(activity.equals("theileria")) {
			count = upcomingVaccinationsTheileria.getAttribute("textContent");
		} else if(activity.equals("anthrax")) {
			count = upcomingVaccinationsAnthrax.getAttribute("textContent");
		} else if(activity.equals("rabies")) {
			count = upcomingVaccinationsRabies.getAttribute("textContent");
		} else if(activity.equals("follow_ups")) {
			count = upcomingFollowUpsCount.getAttribute("textContent");
		} else if(activity.equals("deworming")) {
			count = upcomingDewormingCount.getAttribute("textContent");
		}
		
		return count.replaceAll("\\s", "");
	}
}