package com.nitaraweb.API;

import java.io.FileInputStream;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nitaraweb.base.GenericBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ViewFarmAnalysis {

	@Test
	public JSONObject viewFarmAnalysis() throws Exception {
		
		Properties properties = new Properties();
		
		FileInputStream ip = new FileInputStream("src\\main\\java\\com\\nitaraweb\\config\\config.properties");
		properties.load(ip);
		
		String url = properties.getProperty("APIBaseUrl");
		String abstractname = properties.getProperty("ViewFarmAnalysis");
		
		RestAssured.baseURI = url;
			
		FarmerLogin user = new FarmerLogin();
		
		// get user token
		String token = user.farmerLogin(url);

		//read user name and password
		JSONObject requestParams =  new JSONObject();
		GetFarmId farm = new GetFarmId();
		
		requestParams.put("farmId",farm.getFarmId(url, token)); 
		
		RequestSpecification request = RestAssured.given();

		Response response = request.body(requestParams.toString())
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + token)
				.post(abstractname);

		//System.out.println("\n abstractname = " + abstractname + "\"\n");
		
		//Print response
		response.prettyPeek();

		//Validate status code
		Assert.assertEquals(response.getStatusCode(),200 );

		//System.out.println(response.getClass().getName());
		
		JSONObject responseObject = new JSONObject(response.asString());
		
		//System.out.println(responseObject);
		
		return responseObject;
	}
}	