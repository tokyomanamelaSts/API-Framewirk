package com.exergyRestApi.Application;

import com.applicationPayloads.CreateApplicationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;


public class CreateAplication extends CreateApplicationPayloads {

public static void  CreateApplication(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	String applicationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSitUrl");
	
	String applicationSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSubId");

	String applicationSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSubKey");
	
	
	ExtentTest test;
	test=extent.createTest("Create Application");
	Response response;
	response =  ApiHelper.sendRestPostRequest(applicationSitUrl,applicationSubKey,applicationSubId, CreateApplicationPayLoad, "Application");
	
	
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	
	//Validations
	
	JSONObject innerJson = new JSONObject(response.getBody().asString());
	
	String applicationRef = innerJson.getJSONObject("application").getString("applicationReference");
	ApiHelper.AssertEquals("application Reference" ,"101929", applicationRef, test);
	
	String sourceReference = innerJson.getJSONObject("application").getString("sourceReference");
	ApiHelper.AssertEquals("source Reference" ,"T0005100", sourceReference, test);
	
	String campaigncode = innerJson.getJSONObject("application").getString("campaignCode");
	ApiHelper.AssertEquals("campaignCode" ,"60200000", campaigncode, test);
	
	String product = innerJson.getJSONObject("product").getString("productName");
	ApiHelper.AssertEquals("productName" ,"Tyme Bank Funeral", product, test);
	
	
	
	//Additions
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(CreateApplicationPayLoad,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));


	
}


	
}
