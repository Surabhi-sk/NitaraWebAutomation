package com.nitaraweb.API;


public class AddVaccination extends GenericBase{
public void addVaccination(String date,String token,String url) throws Exception  {

		String abstractname = properties.getProperty("AddTreatment"); // /CM/AddTreatment - in config file
		RestAssured.baseURI = url;
		String filepath = properties.getProperty("TestData_API"); // src\\main\\java\\com\\nitaraweb\\testdata\\TestData_API.xlsx - Add the file at this location.


		RequestSpecification request = RestAssured.given();

		//Read from excel to JSONArray
		ExcelUtils data = new ExcelUtils();
		JSONObject dataObject = data.readCase("AddTreatment","AddTreatmentData",filepath);
    dataObject.put("dateOfVisit", date);

		System.out.println(dataObject);

		request.header("Authorization","Bearer " + token);
		for (String key: dataObject.keySet()){
			if((dataObject.get(key) instanceof String)) {
				if((dataObject.getString(key)).contains(".png")) {
					request.multiPart(key, new File(dataObject.getString(key)));}
				else {
					request.formParam(key, dataObject.get(key));}
			}
			else {
				request.formParam(key, dataObject.get(key));
			}
		}

		Response res = request.post(abstractname).then().extract().response();
		System.out.println("\n\"" + abstractname + "\"\n");
		//Print response
		res.prettyPeek();

		//Validate status code
		Assert.assertEquals( res.getStatusCode(),200);

		String id = null;
		//Validate success message
		String jsonString = res.asString();	
		String  message = JsonPath.from(jsonString).get("message");
		Assert.assertEquals("Treatment Data Added Successfully.", message);
		

	}
  
  }
