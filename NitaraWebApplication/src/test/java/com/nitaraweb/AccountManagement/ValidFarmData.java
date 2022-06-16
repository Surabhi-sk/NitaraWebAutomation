package com.nitaraweb.AccountManagement;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nitaraweb.API.ViewFarmAnalysis;
import com.nitaraweb.base.GenericBase;
import com.nitaraweb.utils.TestUtils;

public class ValidFarmData extends GenericBase{
	
	JSONObject response;

	@BeforeClass
	public void Preconfig_Methods() {
		
		// Log In into Nitara using valid credentials
		TestUtils.Login_Nitara();	
		
		// Fetch response object from the API
		try {
			ViewFarmAnalysis farmAnalysis = new ViewFarmAnalysis();
			response = new JSONObject(farmAnalysis.viewFarmAnalysis().toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void Validate_All_CattleBreakdownData() {
		
		// Fetch data from the response JSONObject
		JSONObject farmDetails = response.getJSONObject("farmAnalysis");
		JSONObject allDetails = farmDetails.getJSONObject("allDetails");
		JSONObject farmStatus = allDetails.getJSONObject("farmStatus");
		JSONObject farmBreedingStatus = allDetails.getJSONObject("farmBreedingStatus");
		
		HashMap<String, String> cattleData = TestUtils.getCattleData(farmStatus);
		HashMap<String, String> breedingData = TestUtils.getBreedingData(farmBreedingStatus);
		
		nitaraHomePage.chooseFilter("all");
		
		Assert.assertEquals(cattleData.get("cattleCount"), nitaraHomePage.getCattleCount("cur_cattle"));
		Assert.assertEquals(cattleData.get("calfCount"), nitaraHomePage.getCattleCount("calf"));
		Assert.assertEquals(cattleData.get("heiferCount"), nitaraHomePage.getCattleCount("heifer"));
		Assert.assertEquals(cattleData.get("milchCount"), nitaraHomePage.getCattleCount("milch"));
		Assert.assertEquals(cattleData.get("bullCount"), nitaraHomePage.getCattleCount("bull"));
		
		Assert.assertEquals(breedingData.get("openCount"), nitaraHomePage.getBreedingCattleCount("open"));
		Assert.assertEquals(breedingData.get("inseminatedCount"), nitaraHomePage.getBreedingCattleCount("inseminated"));
		Assert.assertEquals(breedingData.get("pregnantCount"), nitaraHomePage.getBreedingCattleCount("pregnant"));
		Assert.assertEquals(breedingData.get("dryCount"), nitaraHomePage.getBreedingCattleCount("dry"));	
	
	}
	
	@Test
	public void Validate_Cow_CattleBreakdownData() {

		// Fetch data from the response JSONObject
		JSONObject farmDetails = response.getJSONObject("farmAnalysis");
		JSONObject cowDetails = farmDetails.getJSONObject("cowDetails");
		JSONObject farmStatus = cowDetails.getJSONObject("farmStatus");
		JSONObject farmBreedingStatus = cowDetails.getJSONObject("farmBreedingStatus");
		
		HashMap<String, String> cattleData = TestUtils.getCattleData(farmStatus);
		HashMap<String, String> breedingData = TestUtils.getBreedingData(farmBreedingStatus);
		
		nitaraHomePage.chooseFilter("cow");
		
		Assert.assertEquals(cattleData.get("cattleCount"), nitaraHomePage.getCattleCount("cur_cattle"));
		Assert.assertEquals(cattleData.get("calfCount"), nitaraHomePage.getCattleCount("calf"));
		Assert.assertEquals(cattleData.get("heiferCount"), nitaraHomePage.getCattleCount("heifer"));
		Assert.assertEquals(cattleData.get("milchCount"), nitaraHomePage.getCattleCount("milch"));
		Assert.assertEquals(cattleData.get("bullCount"), nitaraHomePage.getCattleCount("bull"));
		
		Assert.assertEquals(breedingData.get("openCount"), nitaraHomePage.getBreedingCattleCount("open"));
		Assert.assertEquals(breedingData.get("inseminatedCount"), nitaraHomePage.getBreedingCattleCount("inseminated"));
		Assert.assertEquals(breedingData.get("pregnantCount"), nitaraHomePage.getBreedingCattleCount("pregnant"));
		Assert.assertEquals(breedingData.get("dryCount"), nitaraHomePage.getBreedingCattleCount("dry"));	
				
	}
	
	@Test
	public void Validate_Buffalo_CattleBreakdownData() {

		// Fetch data from the response JSONObject
		JSONObject farmDetails = response.getJSONObject("farmAnalysis");
		JSONObject buffaloDetails = farmDetails.getJSONObject("buffaloDetails");
		JSONObject farmStatus = buffaloDetails.getJSONObject("farmStatus");
		JSONObject farmBreedingStatus = buffaloDetails.getJSONObject("farmBreedingStatus");
		
		HashMap<String, String> cattleData = TestUtils.getCattleData(farmStatus);
		HashMap<String, String> breedingData = TestUtils.getBreedingData(farmBreedingStatus);
		
		nitaraHomePage.chooseFilter("buffalo");
		
		Assert.assertEquals(cattleData.get("cattleCount"), nitaraHomePage.getCattleCount("cur_cattle"));
		Assert.assertEquals(cattleData.get("calfCount"), nitaraHomePage.getCattleCount("calf"));
		Assert.assertEquals(cattleData.get("heiferCount"), nitaraHomePage.getCattleCount("heifer"));
		Assert.assertEquals(cattleData.get("milchCount"), nitaraHomePage.getCattleCount("milch"));
		Assert.assertEquals(cattleData.get("bullCount"), nitaraHomePage.getCattleCount("bull"));
		
		Assert.assertEquals(breedingData.get("openCount"), nitaraHomePage.getBreedingCattleCount("open"));
		Assert.assertEquals(breedingData.get("inseminatedCount"), nitaraHomePage.getBreedingCattleCount("inseminated"));
		Assert.assertEquals(breedingData.get("pregnantCount"), nitaraHomePage.getBreedingCattleCount("pregnant"));
		Assert.assertEquals(breedingData.get("dryCount"), nitaraHomePage.getBreedingCattleCount("dry"));	
	
	}
}
