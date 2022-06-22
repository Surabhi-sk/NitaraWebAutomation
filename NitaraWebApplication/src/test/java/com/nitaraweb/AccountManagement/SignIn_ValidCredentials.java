package com.nitaraweb.AccountManagement;

import java.util.Map;

import org.testng.annotations.Test;
import com.nitaraweb.base.GenericBase;
import com.nitaraweb.utils.DataproviderUtils;
import com.nitaraweb.utils.GetUserData;
import com.nitaraweb.utils.TestUtils;

public class SignIn_ValidCredentials extends GenericBase{

//	@Test(dataProvider = "getData",dataProviderClass = DataproviderUtils.class)
//	public void signIn_ValidCredentials(Map<String,String> data) {
//		
//		/** Launch url using get(url) method
//		 * Parameter: Read url from Config file
//		 */
//		basePage.launchURL(properties.getProperty("url"));
//		
//		/** Amazon Page click SignIn Button **/
//		amazonHomePage.click_SignIn();
//		
//		/** Screenshot **/
//		TestUtils.captureScreenshot("SignIn");
//		
//	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataproviderUtils.class)
	public void signIn_ValidCredentials(Map<String, String> data) {
		
		basePage.launchURL(properties.getProperty("url"));
		
		nitaraLoginPage.enterPhoneNumber(data.get("Username"));
		
		nitaraLoginPage.enterPassword(data.get("Password"));
		
		nitaraLoginPage.click_SignIn();
		
		//TestUtils.captureScreenshot("SignIn_Nitara");
	}

}


//System.out.println(openCount);
//System.out.println(inseminatedCount);
//System.out.println(pregnantCount);
//System.out.println(dryCount);

//System.out.println(nitaraHomePage.getTotalBreedingCattleCount("open"));
//System.out.println(nitaraHomePage.getTotalBreedingCattleCount("inseminated"));
//System.out.println(nitaraHomePage.getTotalBreedingCattleCount("pregnant"));
//System.out.println(nitaraHomePage.getTotalBreedingCattleCount("dry"));
