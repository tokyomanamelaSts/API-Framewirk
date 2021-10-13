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


public class QualificationProduct60200001NegetiveTest extends QualificationPayloads {

public static void  qualificationProduct60200001NegetiveTest(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Qualification Product 60200001 Negetive Test");
	Response response;
	response =  ApiHelper.sendRestPostRequest(ApiHelper.applicationSitUrl,ApiHelper.applicationSubKey, ApiHelper.applicationSubId,QualificationProduct60200000NegPayload, "/Qualification");
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
	response.prettyPrint();
	
    //Validations
	
    JSONObject innerJson = new JSONObject(response.getBody().asString());
	
	String productCode = innerJson.get("productCode").toString();
	ApiHelper.AssertEquals("productCode" ,"60200000", productCode, test);
		
    //String sourceReference = innerJson.get("qualificationReference").toString();
	//ApiHelper.AssertEquals("qualificationReference" ,"L632JG1QA", sourceReference, test);
		
	String reason = innerJson.get("rejectionReason").toString();
	ApiHelper.AssertEquals("rejectionReason" ,"The applicant already has a policy for this product and is not allowed to take additional policies", reason, test);
		
	
	String results = innerJson.get("qualificationResult").toString();
	ApiHelper.AssertEquals("qualificationResult" ,"false", results, test);
		
	
	
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
}


	
}
