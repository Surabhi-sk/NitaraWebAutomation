package com.nitaraweb.utils;


public class Helper{
  
  	public String generateNo(int digits) {
		Faker faker = new Faker();
		String number = faker.number().digits(digits);
		System.out.println(number);
		return number;

	}
  
  public JSONObject getMonthandYear(int months) {
		JSONObject obj = new JSONObject();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH,-months);
		obj.put("Year", new SimpleDateFormat("yyyy").format(cal.getTime()));
		obj.put("Month", new SimpleDateFormat("MM").format(cal.getTime()));
		obj.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
		return obj;
	}
	
	
	public String getPastDate(int days) throws Exception {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -(days));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateValue = format.format(cal.getTime());
		return dateValue;
	}
	
  
}
