package com.exergyRestApi.Application;

import com.applicationPayloads.CreateApplicationPayloads;
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


public class QualificationProduct60200000 extends QualificationPayloads {

public static void  qualificationProduct60200000(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Qualification Produc t60200000");
	Response response;
	response =  ApiHelper.sendRestPostRequest(ApiHelper.applicationSitUrl,ApiHelper.applicationSubKey, ApiHelper.applicationSubId,QualificationProduct60200000Payload, "/Qualification");
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	
	//Validations
	
	JSONObject innerJson = new JSONObject(response.getBody().asString());
	
	String ProductCode = innerJson.get("productCode").toString();
	ApiHelper.AssertEquals("productCode" ,"60200000", ProductCode, test);
	
	String results = innerJson.get("qualificationResult").toString();
	ApiHelper.AssertEquals("qualificationResult" ,"true", results, test);
	
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(QualificationProduct60200000Payload,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
}


	
}
