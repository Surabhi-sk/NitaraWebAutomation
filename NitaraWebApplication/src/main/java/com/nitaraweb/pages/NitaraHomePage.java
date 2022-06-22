package com.nitaraweb.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NitaraHomePage extends BasePage{
	@FindBy(css  = "#content > div > div > div.overflow-y-80vh > div:nth-child(1) > div:nth-child(1) > div > div > div > div.col-12.text-blue.h2.text-center.my-4.ng-binding")
	public WebElement cattle;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div[1]/div/div/div/div[3]/div/span[1]")
	public WebElement bull;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div/div/div[3]/div/span[1]")
	public WebElement calf;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[2]/div/div/div[3]/div[1]/div/div/div/div[3]/div/span[1]")
	public WebElement milch;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[1]/div[2]/div/div/div[3]/div[2]/div/div/div/div[3]/div/span[1]")
	public WebElement heifer;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/div[1]/div/div/div/div[2]")
	public WebElement cowBtn;
	
	@FindBy(xpath = "//*[@id=\"buffalo\"]")
	public WebElement bullBtn;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/div[1]/div/div/div/div[1]")
	public WebElement allBtn;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement open;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[2]/span[1]")
	public WebElement insemenated;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/span[1]")
	public WebElement pregnent;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/div/div/div/div[2]/div[4]/span[1]")
	public WebElement dry;
	
	
	public NitaraHomePage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void click_all() {
		allBtn.click();
	}
	
	public void click_cow() {
		cowBtn.click();
	}
	
	public void click_bull() {
		bullBtn.click();
	}
	
	public static Map<String, String> breedData = new HashMap<String, String>();
	public Map<String, String> getBreedingData() throws InterruptedException{
		
		String openCnt = open.getText();
		String insemenatedCnt = insemenated.getText();
		String pregnentCnt = pregnent.getText();
		String dryCnt = dry.getText();
		
		
		breedData.put("open", openCnt);
		breedData.put("insemenated", insemenatedCnt);
		breedData.put("pregnent", pregnentCnt);
		breedData.put("dry", dryCnt);
		

		return breedData;
		
	}
	public String getBreedCount(String breed) {
		if(breed.equals("open")) {
			return breedData.get("open");
		}else if(breed.equals("insemenated")) {
			return breedData.get("insemenated");
		}else if(breed.equals("pregnent")) {
			return breedData.get("pregnent");
		}else return breedData.get("dry");
	}
	
	public static Map<String, String> data = new HashMap<String, String>();
	public Map<String, String> getCattleCount() throws InterruptedException{
		
		String heifer_count = heifer.getText();
		String milch_count = milch.getText();
		String calf_count = calf.getText();
		String bull_count = bull.getText();
		String total = cattle.getText();
		
		data.put("total", total);
		data.put("bull", bull_count);
		data.put("milch", milch_count);
		data.put("heifer", heifer_count);
		data.put("calf", calf_count);

		return data;
		
	}
	
	public String getCount(String CattleType) {
		if(CattleType.equals("calf")) {
			return data.get("calf");
		}else if(CattleType.equals("heifer")) {
			return data.get("heifer");
		}else if(CattleType.equals("milch")) {
			return data.get("milch");
		}else if(CattleType.equals("bull")) {
			return data.get("bull");
		}else return data.get("total");
	}
	//*[@id="content"]/div/div/div[2]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/span[1]
	// Upcoming activities code starts here;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/span[1]")
	public WebElement heat;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/span[1]")
	public WebElement pd;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[3]/div[1]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement followUps;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[1]/span[1]")
	public WebElement calving;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/span[1]")
	public WebElement dryPeriod;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[3]/div[2]/div/div/div/div[2]/div[1]/span[1]")
	public WebElement deworming;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/span[1]")
	public WebElement vaccination_hs;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[2]/div[2]/span[1]")
	public WebElement vaccination_bq;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[3]/div[2]/span[1]")
	public WebElement vaccination_fmd;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[4]/div[2]/span[1]")
	public WebElement vaccination_brucellis;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[5]/div[2]/span[1]")
	public WebElement vaccination_ibr;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[6]/div[2]/span[1]")
	public WebElement vaccination_theileria;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[7]/div[2]/span[1]")
	public WebElement vaccination_anthrex;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[8]/div[2]/span[1]")
	public WebElement rabies;
	
	public static Map<String, String> upcoming_data = new HashMap<String, String>();
	public Map<String, String> getUpcomingData() throws InterruptedException{
		
		String heat_count = heat.getAttribute("textContent");
		String pd_count = pd.getAttribute("textContent");
		String followUps_count = followUps.getAttribute("textContent");
		String calving_count = calving.getAttribute("textContent");
		String dryPeriod_count = dryPeriod.getAttribute("textContent");
		String deworming_count = deworming.getAttribute("textContent");
		
		
		// upcoming Vaccination data
		String vaccination_hs_count = vaccination_hs.getAttribute("textContent");
		String vaccination_bq_count = vaccination_bq.getAttribute("textContent");
		String vaccination_fmd_count = vaccination_fmd.getAttribute("textContent");
		String vaccination_brucellis_count = vaccination_brucellis.getAttribute("textContent");
		String vaccination_ibr_count = vaccination_ibr.getAttribute("textContent");
		String vaccination_theileria_count = vaccination_theileria.getAttribute("textContent");
		String vaccination_anthrex_count = vaccination_anthrex.getAttribute("textContent");
		String rabies_count = rabies.getAttribute("textContent");
		
		System.out.println(heat_count +" Heat count ");
		System.out.println(dryPeriod_count  + " period is");
		System.out.println(pd_count  + " period is");
		System.out.println(calving_count  + " period is");
		System.out.println(vaccination_bq_count  + " period is");
		System.out.println(vaccination_fmd_count  + " period is");
		System.out.println(vaccination_anthrex_count  + " period is");
		
		
		upcoming_data.put("heat_count", heat_count);
		upcoming_data.put("pd_count", pd_count);
		upcoming_data.put("followUps_count", followUps_count);
		upcoming_data.put("calving_count", calving_count);
		upcoming_data.put("dryPeriod_count", dryPeriod_count);
		upcoming_data.put("deworming_count", deworming_count);
		
		
		upcoming_data.put("vaccination_hs_count", vaccination_hs_count);
		upcoming_data.put("vaccination_bq_count", vaccination_bq_count);
		upcoming_data.put("vaccination_fmd_count", vaccination_fmd_count);
		upcoming_data.put("vaccination_brucellis_count", vaccination_brucellis_count);
		upcoming_data.put("vaccination_ibr_count", vaccination_ibr_count);
		upcoming_data.put("vaccination_theileria_count", vaccination_theileria_count);
		upcoming_data.put("vaccination_anthrex_count", vaccination_anthrex_count);
		upcoming_data.put("rabies_count", rabies_count);
		
		
		return upcoming_data;
		
	}
	
	public String getUpcomingCount(String paramName) {
		return upcoming_data.get(paramName);
	}
}
