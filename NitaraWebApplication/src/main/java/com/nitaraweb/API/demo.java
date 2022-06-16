package com.nitaraweb.API;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class demo {
	public static void main(String args[]) {
		

		RestAssured.baseURI = "https://test.nitara.co.in";

		RequestSpecification request = RestAssured.given();

//		String username = properties.getProperty("username");
//		String password = properties.getProperty("password");

		JSONObject requestParams = new JSONObject();
		requestParams.put("countryCode", "+91");
		requestParams.put("phone","atish"); 
		requestParams.put("Pin","password"); 
		requestParams.put("deviceName", "DELL_PC"); 		 
		requestParams.put("deviceType",  "LAPTOP");
		requestParams.put("key",  "com.nitara.farmer");
		
		
		System.out.println(requestParams.toString());
		System.out.println(requestParams.get("phone"));
		
	}
}
