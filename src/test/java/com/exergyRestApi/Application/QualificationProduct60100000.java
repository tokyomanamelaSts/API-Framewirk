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

import org.json.JSONObject;
import org.xml.sax.SAXException;


public class QualificationProduct60100000 extends QualificationPayloads {

public static void  qualificationProduct60100000(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Qualification Product 60100000");
	Response response;
	response =  ApiHelper.sendRestPostRequest(ApiHelper.applicationSitUrl,ApiHelper.applicationSubKey, ApiHelper.applicationSubId,QualificationProduct60100000Payload, "/Qualification");
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
	
	//Validations
	
	JSONObject innerJson = new JSONObject(response.getBody().asString());
	
	String productCode = innerJson.get("productCode").toString();
	ApiHelper.AssertEquals("productCode" ,"60100000", productCode, test);
		
    //String sourceReference = innerJson.get("qualificationReference").toString();
	//ApiHelper.AssertEquals("qualificationReference" ,"1MBJ6XRY", sourceReference, test);
		
	String results = innerJson.get("qualificationResult").toString();
	ApiHelper.AssertEquals("qualificationResult" ,"true", results, test);
		
	
	
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
}


	
}
