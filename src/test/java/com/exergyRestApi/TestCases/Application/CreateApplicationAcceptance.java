package com.exergyRestApi.TestCases.Application;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.payloads.application.CreateApplicationPayloads;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class CreateApplicationAcceptance extends CreateApplicationPayloads {

public static void  createApplicationAcceptance(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
    String applicationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSitUrl");
	
	String applicationSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");

	String applicationSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
	
	
	
	ExtentTest test;
	test=extent.createTest("Create Application Acceptance");
	Response response;
	response =  ApiHelper.sendRestPostRequest(applicationSitUrl,applicationSubKey,applicationSubId,"", "/Application/1598/Acceptance?OTP=4171");
	
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(CreateApplicationPayLoad,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

    
	
}


	
}
