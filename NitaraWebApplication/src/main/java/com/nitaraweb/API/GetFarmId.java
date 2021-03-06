package com.nitaraweb.API;


import org.json.JSONObject;

import com.nitaraweb.base.GenericBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetFarmId extends GenericBase{

	public String getFarmId(String url,String token) throws Exception {

		String abstractname = "AM/GetUserDetails";
		RestAssured.baseURI = url;


		RequestSpecification request = RestAssured.given();

		String username = properties.getProperty("username");

		//Create 
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", username); 

		Response response= request.body(requestParams.toString()).
				header("Content-Type", "application/json").
				header("Authorization","Bearer " + token).
				post(abstractname);

		response.prettyPeek();

		String jsonString = response.asString();
		JSONObject res = new JSONObject(jsonString);
		JSONObject userDetails = res.getJSONObject("userDetail");
		String farmId = userDetails.getString("farm");

		return farmId;



	}
}