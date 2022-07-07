package com.nitaraweb.API;



public class RegisterMilkingCattle extends GenericBase{


	public String registerMilkingCattledata(String url,String farm, int ageInMonths, String lactation , String lastCalvingDate) throws Exception {

		/*Update Farm Details*/
		ExcelUtils exceldata = new ExcelUtils();
		String filepath = properties.getProperty("TestData_API");   // src\\main\\java\\com\\nitaraweb\\testdata\\TestData_API.xlsx - Add the file at this location.
		exceldata.writeStringData("GeneralData","farmId", farm, filepath);
		String abstractname = properties.getProperty("RegisterMilkingOrDryCattle"); //  /CM/RegisterMilkingOrDryCattle - Add in Config File
		
		RestAssured.baseURI = url;
		
		FarmerLogin user = new FarmerLogin();
		// get user token
		String token = user.farmerLogin(url);

		RequestSpecification request = RestAssured.given();

		//Update tag numbers in Registration.xlsx
		ExcelUtils var = new ExcelUtils();
		String TagNo = var.generateNo(8);
		var.writeStringData("GeneralData","TagNumber",TagNo, filepath);
		String CoopNo = var.generateNo(12);
		var.writeStringData("GeneralData","CooperativeTagNumber",CoopNo, filepath);

		JSONObject dataObject = var.readCase("RegMilkingDryCattle","RegisterMilk",filepath);

		request.header("Authorization","Bearer " + token);
		for (String key: dataObject.keySet()){
			if((dataObject.get(key) instanceof String)) 
				if((dataObject.getString(key)).matches("([^\\s]+(\\.(?i)(jpe?g|png))$)")) {
					request.multiPart(key, new File(dataObject.getString(key)));}

				else {
					request.formParam(key, dataObject.get(key));
				}
			else {
				request.formParam(key, dataObject.get(key));
			}

		}

		Helper dates = new Helper();
		JSONObject obj = dates.getMonthandYear(ageInMonths);
		request.formParam("yearOfBirth", obj.get("Year"));
		request.formParam("monthOfBirth", obj.get("Month"));
		request.formParam("currentLactation", lactation);
		request.formParam("lastCalvingDate", lastCalvingDate);

		System.out.println(request.body("lastCalvingDate"));


		Response res = request.post(abstractname).then().extract().response();

		System.out.println("\n\"" + abstractname + "\"\n");
		//Print response
		res.prettyPeek();

		//Validate status code
		Assert.assertEquals( res.getStatusCode(),200);



		//Validate success message
		String jsonString = res.asString();
		String  message = JsonPath.from(jsonString).get("message");
		Assert.assertEquals(message, "Cattle Registered successfully." );
		String cattleId = JsonPath.from(jsonString).get("cattleId");

		//Write CattleId 
		filepath = properties.getProperty("TestData_API");
		var.writeStringData("GeneralData", "CattleId", cattleId, filepath);
	

		return cattleId;
	}
}
