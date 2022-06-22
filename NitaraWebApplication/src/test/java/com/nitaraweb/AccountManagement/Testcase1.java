package com.nitaraweb.AccountManagement;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nitaraweb.API.ViewFarmAnalysis;
import com.nitaraweb.base.GenericBase;


public class Testcase1 extends GenericBase{
	  

	//	public static WebDriver driver = null;

	@Test(priority=1)
	public void validateCattleCount() throws Exception {

		basePage.launchURL(properties.getProperty("url"));

		nitaraLoginPage.click_SignIn();
		Thread.sleep(5000);
		nitaraHomePage.click_all();

		nitaraHomePage.getCattleCount();
		

		ViewFarmAnalysis farmAnalysis = new ViewFarmAnalysis();
		JSONObject response = farmAnalysis.viewFarmAnalysis();
		JSONObject allDetails = ((JSONObject) ((JSONObject) response.get("farmAnalysis")).get("allDetails"));
		JSONObject farmStatus = (JSONObject) ((JSONObject) allDetails.get("farmStatus"));
		//Getting values
		int calfCount = (Integer) farmStatus.get("calfCount");
		int heiferCount = (Integer) farmStatus.get("heiferCount");
		int bullCount = (Integer) farmStatus.get("bullCount");
		int milchCount = (Integer) farmStatus.get("milchCount");
		int cattleCount = (Integer) farmStatus.get("cattleCount");
		

		String calf_string = nitaraHomePage.getCount("calf");
		String heifer_string = nitaraHomePage.getCount("heifer");
		String milch_string = nitaraHomePage.getCount("milch");
		String bull_string = nitaraHomePage.getCount("bull");
		String total_string = nitaraHomePage.getCount("total").substring(0, 2).trim();
	
		
		int heifer = Integer.parseInt(heifer_string);
		int milch= Integer.parseInt(milch_string);
		int bull = Integer.parseInt(bull_string);
		int total = Integer.parseInt(total_string);
		int calf = Integer.parseInt(calf_string);


		//Asserting values
		Assert.assertEquals(heiferCount, heifer, "The heifer count does not match.");
		Assert.assertEquals(bullCount, bull, "The bull count does not match.");
		Assert.assertEquals(milchCount, milch, "The milch count does not match.");
		Assert.assertEquals(cattleCount, total, "The total count does not match.");
		Assert.assertEquals(calfCount, calf, "The calf count does not match.");

		
	}

	@Test(priority=2)
	public void validateCowCount() throws Exception {

//		basePage.launchURL(properties.getProperty("url"));
//
//		nitaraLoginPage.click_SignIn();
		Thread.sleep(5000);

		nitaraHomePage.click_cow();
		
		nitaraHomePage.getCattleCount();
		

		ViewFarmAnalysis farmAnalysis = new ViewFarmAnalysis();
		JSONObject response = farmAnalysis.viewFarmAnalysis();
		JSONObject cowDetails = ((JSONObject) ((JSONObject) response.get("farmAnalysis")).get("cowDetails"));
		JSONObject farmStatus = (JSONObject) ((JSONObject) cowDetails.get("farmStatus"));
		//Getting values
		int calfCount = (Integer) farmStatus.get("calfCount");
		int heiferCount = (Integer) farmStatus.get("heiferCount");
		int bullCount = (Integer) farmStatus.get("bullCount");
		int milchCount = (Integer) farmStatus.get("milchCount");
		int cattleCount = (Integer) farmStatus.get("cattleCount");

		String calf_string = nitaraHomePage.getCount("calf");
		String heifer_string = nitaraHomePage.getCount("heifer");
		String milch_string = nitaraHomePage.getCount("milch");
		String bull_string = nitaraHomePage.getCount("bull");
		String total_string = nitaraHomePage.getCount("total").substring(0, 2).trim();
		//		
		int calf = Integer.parseInt(calf_string);
		int heifer = Integer.parseInt(heifer_string);
		int milch= Integer.parseInt(milch_string);
		int bull = Integer.parseInt(bull_string);
		int total = Integer.parseInt(total_string);


		//Asserting values
		Assert.assertEquals(calfCount, calf, "The calf count does not match.");
		Assert.assertEquals(heiferCount, heifer, "The heifer count does not match.");
		Assert.assertEquals(bullCount, bull, "The bull count does not match.");
		Assert.assertEquals(milchCount, milch, "The milch count does not match.");
		Assert.assertEquals(cattleCount, total, "The total count does not match.");
		
		

	}
//	
//
//
	@Test(priority=3)
	public void validateBullCount() throws Exception {
		
//		basePage.launchURL(properties.getProperty("url"));
//
//		nitaraLoginPage.click_SignIn();
		
		Thread.sleep(5000);
		nitaraHomePage.click_bull();
		
		nitaraHomePage.getCattleCount();
		

		ViewFarmAnalysis farmAnalysis = new ViewFarmAnalysis();
		JSONObject response = farmAnalysis.viewFarmAnalysis();
		JSONObject cowDetails = ((JSONObject) ((JSONObject) response.get("farmAnalysis")).get("buffaloDetails"));
		JSONObject farmStatus = (JSONObject) ((JSONObject) cowDetails.get("farmStatus"));
		//Getting values
		int calfCount = (Integer) farmStatus.get("calfCount");
		int heiferCount = (Integer) farmStatus.get("heiferCount");
		int bullCount = (Integer) farmStatus.get("bullCount");
		int milchCount = (Integer) farmStatus.get("milchCount");
		int cattleCount = (Integer) farmStatus.get("cattleCount");

		String calf_string = nitaraHomePage.getCount("calf");
		String heifer_string = nitaraHomePage.getCount("heifer");
		String milch_string = nitaraHomePage.getCount("milch");
		String bull_string = nitaraHomePage.getCount("bull");
		String total_string = nitaraHomePage.getCount("total").substring(0, 1);
		//		
		int calf = Integer.parseInt(calf_string);
		int heifer = Integer.parseInt(heifer_string);
		int milch= Integer.parseInt(milch_string);
		int bull = Integer.parseInt(bull_string);
		int total = Integer.parseInt(total_string);


		//Asserting values
		Assert.assertEquals(calfCount, calf, "The calf count does not match.");
		Assert.assertEquals(heiferCount, heifer, "The heifer count does not match.");
		Assert.assertEquals(bullCount, bull, "The bull count does not match.");
		Assert.assertEquals(milchCount, milch, "The milch count does not match.");
		Assert.assertEquals(cattleCount, total, "The total count does not match.");

	}
	
	@Test(priority=4)
	public void validateFarmBreedingStatus() throws Exception {
		
		
		nitaraHomePage.click_all();
		Thread.sleep(5000);
		nitaraHomePage.getBreedingData();
		

		ViewFarmAnalysis farmAnalysis = new ViewFarmAnalysis();
		JSONObject response = farmAnalysis.viewFarmAnalysis();
		JSONObject cowDetails = ((JSONObject) ((JSONObject) response.get("farmAnalysis")).get("allDetails"));
		JSONObject farmStatus = (JSONObject) ((JSONObject) cowDetails.get("farmBreedingStatus"));
		//Getting values
		int openCount = (Integer) farmStatus.get("openCount");
		int inseminatedCount = (Integer) farmStatus.get("inseminatedCount");
		int pregnantCount = (Integer) farmStatus.get("pregnantCount");
		int dryCount = (Integer) farmStatus.get("dryCount");

		
		int open = Integer.parseInt(nitaraHomePage.getBreedCount("open"));
		int insemenated = Integer.parseInt(nitaraHomePage.getBreedCount("insemenated"));
		int pregnent= Integer.parseInt(nitaraHomePage.getBreedCount("pregnent"));
		int dry = Integer.parseInt(nitaraHomePage.getBreedCount("dry"));
		


		//Asserting values
		Assert.assertEquals(openCount, open, "The calf count does not match.");
		Assert.assertEquals(inseminatedCount, insemenated, "The heifer count does not match.");
		Assert.assertEquals(pregnantCount, pregnent, "The bull count does not match.");
		Assert.assertEquals(dryCount, dry, "The milch count does not match.");
		

	}
}
