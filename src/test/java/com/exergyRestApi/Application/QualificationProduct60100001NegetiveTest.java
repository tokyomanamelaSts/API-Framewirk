package com.exergyRestApi.Application;


import com.applicationPayloads.QualificationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class QualificationProduct60100001NegetiveTest extends QualificationPayloads {

public static void  qualificationProduct60100001NegetiveTest(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Qualification Product 60100001 Negetive Test");
	Response response;
	response =  ApiHelper.sendRestPostRequest(ApiHelper.applicationSitUrl,ApiHelper.applicationSubKey, ApiHelper.applicationSubId,QualificationProduct60100000NegPayload, "/Qualification");
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
	
}


	
}
