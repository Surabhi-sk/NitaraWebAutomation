package com.nitaraweb.API;

import org.json.JSONObject;
import org.testng.Assert;

import com.nitaraweb.base.GenericBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FarmerLogin extends GenericBase {

	public String farmerLogin(String url) {

		RestAssured.baseURI = url;

		RequestSpecification request = RestAssured.given();

		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		JSONObject requestParams = new JSONObject();
		requestParams.put("countryCode", "+91");
		requestParams.put("phone",username); 
		requestParams.put("Pin",password); 
		requestParams.put("deviceName", "DELL_PC"); 		 
		requestParams.put("deviceType",  "LAPTOP");
		requestParams.put("key",  "com.nitara.farmer");

		request.body(requestParams.toString());

		request.header("Content-Type", "application/json");

		Response response = request.post("/v3/AM/UserLogin");
		//Print response
		response.prettyPeek();


		int statusCode = response.getStatusCode();

		//System.out.println("The status code recieved: " + statusCode);

		//Validate Status code
		Assert.assertEquals(response.getStatusCode(),200);
		String jsonString = response.asString();
		String  message = JsonPath.from(jsonString).get("message");
		
		//Validate success message
		Assert.assertEquals(message,"Logged in successfully.");

		String token = JsonPath.from(jsonString).get("token");
		return (token);
	}

}
