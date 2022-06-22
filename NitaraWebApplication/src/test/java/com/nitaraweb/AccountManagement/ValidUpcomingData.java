package com.nitaraweb.AccountManagement;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nitaraweb.API.ViewFarmAnalysis;
import com.nitaraweb.base.GenericBase;


public class ValidUpcomingData extends GenericBase{
	  

	//	public static WebDriver driver = null;

	@Test(priority=1)
	public void validUpcomingData_all() throws Exception {

		basePage.launchURL(properties.getProperty("url"));

		nitaraLoginPage.click_SignIn();
		Thread.sleep(5000);
		nitaraHomePage.click_all();

		nitaraHomePage.getUpcomingData();
		

		ViewFarmAnalysis farmAnalysis = new ViewFarmAnalysis();
		JSONObject response = farmAnalysis.viewFarmAnalysis();
		JSONObject allDetails = ((JSONObject) ((JSONObject) response.get("farmAnalysis")).get("allDetails"));
		JSONObject upcomingActivities = (JSONObject) ((JSONObject) allDetails.get("upcomingActivities"));
		JSONObject upcomingActivitiesHealth = (JSONObject) ((JSONObject) upcomingActivities.get("health"));
		JSONObject upcomingActivitiesBreeding = (JSONObject) ((JSONObject) upcomingActivities.get("breeding"));

		//Getting values from json
		int hsCount = (Integer) upcomingActivitiesHealth.get("hsCount");
		int bqCount = (Integer) upcomingActivitiesHealth.get("bqCount");
		int fmdCount = (Integer) upcomingActivitiesHealth.get("fmdCount");
		int brucellisCount = (Integer) upcomingActivitiesHealth.get("brucellosisCount");
		int ibrCount = (Integer) upcomingActivitiesHealth.get("ibrCount");
		int theileriaCount = (Integer) upcomingActivitiesHealth.get("theileriaCount");
		int anthrexCount = (Integer) upcomingActivitiesHealth.get("anthraxCount");
		int rabiesCount = (Integer) upcomingActivitiesHealth.get("rabiesCount");
		int dewormingCount = (Integer) upcomingActivitiesHealth.get("dewormingCount");
		int followUpCount = (Integer) upcomingActivitiesHealth.get("followupCount");
		
		int heatCount = (Integer) upcomingActivitiesBreeding.get("heatCount");
		int pdCount = (Integer) upcomingActivitiesBreeding.get("pdCount");
		int calvingCount = (Integer) upcomingActivitiesBreeding.get("calvingCount");
		int dryPeriodCount = (Integer) upcomingActivitiesBreeding.get("dryPeriodCount");
		
//		System.out.println(hsCount);
//		System.out.println(bqCount);
//		System.out.println(theileriaCount);
//		System.out.println(anthrexCount);
//		System.out.println(followUpCount);
//		System.out.println(heatCount);
//		System.out.println(dryPeriodCount);

		
		
		// Getting data from UI
		
		String UI_heatCount1 = nitaraHomePage.getUpcomingCount("heat_count").trim();
		String UI_pdCount1 = nitaraHomePage.getUpcomingCount("pd_count").trim();
		String UI_followUpCount1 = nitaraHomePage.getUpcomingCount("followUps_count").trim();
		String UI_calvingCount1 = nitaraHomePage.getUpcomingCount("calving_count").trim();
		String UI_dryPeriodCount1 = nitaraHomePage.getUpcomingCount("dryPeriod_count").trim();
		String UI_dewormingCount1 = nitaraHomePage.getUpcomingCount("deworming_count").trim();
		String UI_hsCount1 = nitaraHomePage.getUpcomingCount("vaccination_hs_count").trim();
		String UI_bqCount1 = nitaraHomePage.getUpcomingCount("vaccination_bq_count").trim();
		String UI_fmdCount1 = nitaraHomePage.getUpcomingCount("vaccination_fmd_count").trim();
		String UI_brucellisCount1 = nitaraHomePage.getUpcomingCount("vaccination_brucellis_count").trim();
		String UI_ibrCount1 = nitaraHomePage.getUpcomingCount("vaccination_ibr_count").trim();
		String UI_theileriaCount1 = nitaraHomePage.getUpcomingCount("vaccination_theileria_count").trim();
		String UI_anthrexCount1 = nitaraHomePage.getUpcomingCount("vaccination_anthrex_count").trim();
		String UI_rabiesCount1 = nitaraHomePage.getUpcomingCount("rabies_count").trim();
		
	
		
		int UI_heatCount = Integer.parseInt(UI_heatCount1);
		int UI_pdCount= Integer.parseInt(UI_pdCount1);
		int UI_followUpCount = Integer.parseInt(UI_followUpCount1);
		int UI_calvingCount = Integer.parseInt(UI_calvingCount1);
		int UI_dryPeriodCount = Integer.parseInt(UI_dryPeriodCount1);
		int UI_dewormingCount = Integer.parseInt(UI_dewormingCount1);
		int UI_hsCount= Integer.parseInt(UI_hsCount1);
		int UI_bqCount = Integer.parseInt(UI_bqCount1);
		int UI_fmdCount = Integer.parseInt(UI_fmdCount1);
		int UI_brucellisCount = Integer.parseInt(UI_brucellisCount1);
		int UI_ibrCount= Integer.parseInt(UI_ibrCount1);
		int UI_theileriaCount = Integer.parseInt(UI_theileriaCount1);
		int UI_anthrexCount = Integer.parseInt(UI_anthrexCount1);
		int UI_rabiesCoun = Integer.parseInt(UI_rabiesCount1);
//		System.out.println(UI_heatCount);


		//Asserting values
		Assert.assertEquals(heatCount, UI_heatCount, "The heat count does not match.");
		Assert.assertEquals(hsCount, UI_hsCount, "The hs count does not match.");
		Assert.assertEquals(bqCount, UI_bqCount, "The bq count does not match.");
		Assert.assertEquals(fmdCount, UI_fmdCount, "The fmd count does not match.");
		Assert.assertEquals(brucellisCount, UI_brucellisCount, "The brucellis count does not match.");
		Assert.assertEquals(ibrCount, UI_ibrCount, "The ibr count does not match.");
		Assert.assertEquals(theileriaCount, UI_theileriaCount, "The theileria count does not match.");
		Assert.assertEquals(anthrexCount, UI_anthrexCount, "The anthrex count does not match.");
		Assert.assertEquals(rabiesCount, UI_rabiesCoun, "The rabies count does not match.");
		Assert.assertEquals(dewormingCount, UI_dewormingCount, "The deworming count does not match.");
		Assert.assertEquals(followUpCount, UI_followUpCount, "The followup count does not match.");
		Assert.assertEquals(pdCount, UI_pdCount, "The pd count does not match.");
		Assert.assertEquals(calvingCount, UI_calvingCount, "The calving count does not match.");
		Assert.assertEquals(dryPeriodCount, UI_dryPeriodCount, "The dryPeriod count does not match.");
		

		
	}

//	@Test(priority=2)
//	public void validUpcomingData_cow() throws Exception {
//
////		basePage.launchURL(properties.getProperty("url"));
////
////		nitaraLoginPage.click_SignIn();
//		Thread.sleep(5000);
//
//		nitaraHomePage.click_cow();
//		
//		nitaraHomePage.getCattleCount();
//		
//
//		ViewFarmAnalysis farmAnalysis = new ViewFarmAnalysis();
//		JSONObject response = farmAnalysis.viewFarmAnalysis();
//		JSONObject cowDetails = ((JSONObject) ((JSONObject) response.get("farmAnalysis")).get("cowDetails"));
//		JSONObject farmStatus = (JSONObject) ((JSONObject) cowDetails.get("farmStatus"));
//		//Getting values
//		int calfCount = (Integer) farmStatus.get("calfCount");
//		int heiferCount = (Integer) farmStatus.get("heiferCount");
//		int bullCount = (Integer) farmStatus.get("bullCount");
//		int milchCount = (Integer) farmStatus.get("milchCount");
//		int cattleCount = (Integer) farmStatus.get("cattleCount");
//
//		String calf_string = nitaraHomePage.getCount("calf");
//		String heifer_string = nitaraHomePage.getCount("heifer");
//		String milch_string = nitaraHomePage.getCount("milch");
//		String bull_string = nitaraHomePage.getCount("bull");
//		String total_string = nitaraHomePage.getCount("total").substring(0, 2);
//		//		
//		int calf = Integer.parseInt(calf_string);
//		int heifer = Integer.parseInt(heifer_string);
//		int milch= Integer.parseInt(milch_string);
//		int bull = Integer.parseInt(bull_string);
//		int total = Integer.parseInt(total_string);
//
//
//		//Asserting values
//		Assert.assertEquals(calfCount, calf, "The calf count does not match.");
//		Assert.assertEquals(heiferCount, heifer, "The heifer count does not match.");
//		Assert.assertEquals(bullCount, bull, "The bull count does not match.");
//		Assert.assertEquals(milchCount, milch, "The milch count does not match.");
//		Assert.assertEquals(cattleCount, total, "The total count does not match.");
//		
//		
//
//	}
//
//	
//	@Test(priority=3)
//	public void validUpcomingData_bull() throws Exception {
//		
////		basePage.launchURL(properties.getProperty("url"));
////
////		nitaraLoginPage.click_SignIn();
//		
//		Thread.sleep(5000);
//		nitaraHomePage.click_bull();
//		
//		nitaraHomePage.getCattleCount();
//		
//
//		ViewFarmAnalysis farmAnalysis = new ViewFarmAnalysis();
//		JSONObject response = farmAnalysis.viewFarmAnalysis();
//		JSONObject cowDetails = ((JSONObject) ((JSONObject) response.get("farmAnalysis")).get("buffaloDetails"));
//		JSONObject farmStatus = (JSONObject) ((JSONObject) cowDetails.get("farmStatus"));
//		//Getting values
//		int calfCount = (Integer) farmStatus.get("calfCount");
//		int heiferCount = (Integer) farmStatus.get("heiferCount");
//		int bullCount = (Integer) farmStatus.get("bullCount");
//		int milchCount = (Integer) farmStatus.get("milchCount");
//		int cattleCount = (Integer) farmStatus.get("cattleCount");
//
//		String calf_string = nitaraHomePage.getCount("calf");
//		String heifer_string = nitaraHomePage.getCount("heifer");
//		String milch_string = nitaraHomePage.getCount("milch");
//		String bull_string = nitaraHomePage.getCount("bull");
//		String total_string = nitaraHomePage.getCount("total").substring(0, 1);
//		//		
//		int calf = Integer.parseInt(calf_string);
//		int heifer = Integer.parseInt(heifer_string);
//		int milch= Integer.parseInt(milch_string);
//		int bull = Integer.parseInt(bull_string);
//		int total = Integer.parseInt(total_string);
//
//
//		//Asserting values
//		Assert.assertEquals(calfCount, calf, "The calf count does not match.");
//		Assert.assertEquals(heiferCount, heifer, "The heifer count does not match.");
//		Assert.assertEquals(bullCount, bull, "The bull count does not match.");
//		Assert.assertEquals(milchCount, milch, "The milch count does not match.");
//		Assert.assertEquals(cattleCount, total, "The total count does not match.");
//
//	}

}
