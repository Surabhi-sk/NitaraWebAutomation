package com.nitaraweb.API;


public class AddInsemination extends GenericBase{
public void addInsemination(String date,String token,String url) throws Exception  {

		String abstractname = properties.getProperty("AddVaccination"); // /CM/AddVaccination - in config file
		RestAssured.baseURI = url;
		String filepath = properties.getProperty("TestData_API"); // src\\main\\java\\com\\nitaraweb\\testdata\\TestData_API.xlsx - Add the file at this location.


		RequestSpecification request = RestAssured.given();

		//Read from excel to JSONArray
		ExcelUtils data = new ExcelUtils();
	JSONObject requestParams = data.readCase("AddInsemination","AddInseminationwithValidData",filepath);
		requestParams.put("inseminationDate", date.getPastDate(19));

	Response response = request.body(requestParams.toString())
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + usertoken)
				.post(abstractname);
		System.out.println("\n\"" + abstractname + "\"\n");
		//Print response
		res.prettyPeek();

		//Validate status code
		Assert.assertEquals( res.getStatusCode(),200);

		String id = null;
		//Validate success message
		String jsonString = res.asString();	
		String  message = JsonPath.from(jsonString).get("message");
		Assert.assertEquals("Insemination Data Added Successfully.", message);
		

	}
  
  
  
  }
