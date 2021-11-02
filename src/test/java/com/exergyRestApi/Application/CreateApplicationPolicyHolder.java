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
import org.xml.sax.SAXException;


public class CreateApplicationPolicyHolder extends CreateApplicationPayloads {

public static void  createApplicationPolicyHolder(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
    String applicationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSitUrl");
	
	String applicationSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");

	String applicationSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
	
	
	ExtentTest test;
	test=extent.createTest("Create Application Policy holder");
	Response response;
	response =  ApiHelper.sendRestPutRequest(applicationSitUrl,applicationSubKey,applicationSubId,CreateApplicationPolicyHolderPayload, "/Application/101936/PolicyHolder");
	
	
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(CreateApplicationPolicyHolderPayload,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
	
}


	
}
