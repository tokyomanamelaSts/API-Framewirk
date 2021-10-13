package com.exergyRestApi.Application;

import com.applicationPayloads.CreateApplicationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;

public class GetApplication extends CreateApplicationPayloads {

public static void  getApplication(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Get Application");
	Response response;
	response =  ApiHelper.sendRestGetRequest(ApiHelper.applicationSitUrl,ApiHelper.applicationSubKey, ApiHelper.applicationSubId,"/Application/1598");
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	
	//Validations
	
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		
		String applicationRef = innerJson.get("applicationReference").toString();
		ApiHelper.AssertEquals("applicationReference" ,"1598", applicationRef, test);
		
		String sourceReference = innerJson.get("sourceReference").toString();
		ApiHelper.AssertEquals("sourceReference" ,"Tyme01", sourceReference, test);
		
		String campaigncode = innerJson.get("campaignCode").toString();
		ApiHelper.AssertEquals("campaignCode" ,"60100000", campaigncode, test);
		
		String premium = innerJson.getJSONObject("premiumAmount").getString("total");
		ApiHelper.AssertEquals("total" ,"256", premium, test);
		
		
		
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
	
	
	
}


	
}
