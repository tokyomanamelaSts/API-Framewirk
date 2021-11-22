package com.PetStore.payloads;

public class AddNewDogPayloads {

	

	public static final String addNewPet(String PetId, String categoryId, String CategoryName, String name, String photoUrls, String tagId,String TagName, String	status) {
		 String ReqBody 
		= "{\n"
				+ "  \"id\": "+PetId+",\n"
				+ "  \"category\": {\n"
				+ "    \"id\": "+categoryId+",\n"
				+ "    \"name\": \""+CategoryName+"\"\n"
				+ "  },\n"
				+ "  \"name\": \""+name+"\",\n"
				+ "  \"photoUrls\": [\n"
				+ "    \""+photoUrls+"\"\n"
				+ "  ],\n"
				+ "  \"tags\": [\n"
				+ "    {\n"
				+ "      \"id\": "+tagId+",\n"
				+ "      \"name\": \""+TagName+"\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"status\": \""+status+"\"\n"
				+ "}";
		 
		 return ReqBody;
	
	}
	
	
	
	
}

	
