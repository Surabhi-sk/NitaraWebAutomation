package com.nitaraweb.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.nitaraweb.API.ViewFarmAnalysis;
import com.nitaraweb.base.GenericBase;

public class TestUtils extends GenericBase{
	
	static DateFormat dateFormat;
	static Date date;


	public static final String DateFormat = "yyyyMMddHH:mm:ss";

	public static String getDate(String format) {
		dateFormat = new SimpleDateFormat(format);
		date = new Date();
		return dateFormat.format(date);
	}

	public static void captureScreenshot(String functionality) {
		File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("src\\test\\resources\\Screenshots\\"+functionality+"_Screenshot.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void Login_Nitara() {
		basePage.launchURL(properties.getProperty("url"));
		nitaraLoginPage.enterPhoneNumber(properties.getProperty("username"));
		nitaraLoginPage.enterPassword(properties.getProperty("password"));
		nitaraLoginPage.click_SignIn();
	}
	
	public static String getCount(JSONObject obj, String type) {
		return ((Integer) obj.get(type)).toString();
	}
	
	public static HashMap<String, String> getBreedingData(JSONObject farmBreedingStatus) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("openCount", getCount(farmBreedingStatus, "openCount"));
		map.put("inseminatedCount", getCount(farmBreedingStatus, "inseminatedCount"));
		map.put("pregnantCount", getCount(farmBreedingStatus, "pregnantCount"));
		map.put("dryCount", getCount(farmBreedingStatus, "dryCount"));
		
		return map;
	}
	
	public static HashMap<String, String> getCattleData(JSONObject farmStatus) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("cattleCount", getCount(farmStatus, "cattleCount"));
		map.put("calfCount", getCount(farmStatus, "calfCount"));
		map.put("heiferCount", getCount(farmStatus, "heiferCount"));
		map.put("milchCount", getCount(farmStatus, "milchCount"));
		map.put("bullCount", getCount(farmStatus, "bullCount"));
		
		return map;
	}
	
	public static HashMap<String, String> getUpcomingHealthData(JSONObject health) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("hsCount", getCount(health, "hsCount"));
		map.put("bqCount", getCount(health, "bqCount"));
		map.put("fmdCount", getCount(health, "fmdCount"));
		map.put("brucellosisCount", getCount(health, "brucellosisCount"));
		map.put("ibrCount", getCount(health, "ibrCount"));
		map.put("theileriaCount", getCount(health, "theileriaCount"));
		map.put("anthraxCount", getCount(health, "anthraxCount"));
		map.put("rabiesCount", getCount(health, "rabiesCount"));
		map.put("dewormingCount", getCount(health, "dewormingCount"));
		map.put("followupCount", getCount(health, "followupCount"));
		
		return map;
	}
	
	public static HashMap<String, String> getUpcomingBreedingData(JSONObject breeding) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("heatCount", getCount(breeding, "heatCount"));
		map.put("pdCount", getCount(breeding, "pdCount"));
		map.put("calvingCount", getCount(breeding, "calvingCount"));
		map.put("dryPeriodCount", getCount(breeding, "dryPeriodCount"));
		
		return map;
	}
}
