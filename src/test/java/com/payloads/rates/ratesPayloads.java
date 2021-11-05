package com.payloads.rates;

public class ratesPayloads {

	public static String  getProductsRates( String lifeAssuredType1, String Age1, String lifeAssuredType2	, String Age2, String lifeAssuredType3, String Age3, String lifeAssuredType4, String Age4){
		
		String payload =  
				"{\n"
				+ "    \"lifeAssured\": [\n"
				+ "        {\n"
				+ "            \"lifeAssuredReference\": \"1\",\n"
				+ "            \"lifeAssuredType\": \""+lifeAssuredType1+"\",\n"
				+ "            \"age\": "+Age1+"\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"lifeAssuredReference\": \"2\",\n"
				+ "            \"lifeAssuredType\": \""+lifeAssuredType2+"\",\n"
				+ "            \"age\": "+Age2+"\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"lifeAssuredReference\": \"3\",\n"
				+ "            \"lifeAssuredType\": \""+lifeAssuredType3+"\",\n"
				+ "            \"age\": "+Age3+"\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"lifeAssuredReference\": \"4\",\n"
				+ "            \"lifeAssuredType\": \""+lifeAssuredType4+"\",\n"
				+ "            \"age\": "+Age4+"\n"
				+ "        }\n"      
				+ "    ]\n"
				+ "}\n"
				+ "";
		
		return payload;
		
	}
	
	
}
