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

public class CreateApplicationBenefits extends CreateApplicationPayloads {

public static void  createApplicationBenefits(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	ExtentTest test;
	test=extent.createTest("create Application Benefits");
	Response response;
	response =  ApiHelper.sendRestPutRequest(ApiHelper.applicationSitUrl,ApiHelper.applicationSubKey, ApiHelper.applicationSubId,CreateApplicationBenefitsPayLoad,"/Application/1598/Benefits/");
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	
	//Validations
	
    JSONObject innerJson = new JSONObject(response.getBody().asString());
		
	String applicationRef = innerJson.get("applicationReference").toString();
	ApiHelper.AssertEquals("applicationReference" ,"1598", applicationRef, test);
		
    String sourceReference = innerJson.get("sourceReference").toString();
	ApiHelper.AssertEquals("sourceReference" ,"Tyme01", sourceReference, test);
		
	String premiumAmount = innerJson.getJSONObject("premiumAmount").getString("benefitPremiums");
	ApiHelper.AssertEquals("benefitPremiums" ,"256", premiumAmount, test);
		
	String productCode = innerJson.get("productCode").toString();
	ApiHelper.AssertEquals("productCode" ,"60100000", productCode, test);
	
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(CreateApplicationBenefitsPayLoad,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
}
	
}
