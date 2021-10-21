package com.exergyRestApi.PartyVerification;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.PartyVerificationRest.Payloads.PartyApiSitPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class TC_004 extends PartyApiSitPayloads {
	
public static void PersonIdentification_Enhanced_Invalid_ID(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		
    String PartyVerificationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSitUrl");
	
	String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

	String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
		
	
	
	ExtentTest test;
	test=extent.createTest("Person Identification Enhanced invalid");
	Response response;
	response =  ApiHelper.sendRestPostRequest(PartyVerificationSitUrl,PartySubKey, PartySubId,PersonIndentificationEnhanced, "/Person/9705145018089/Identification");
	
	ApiHelper.AssertEquals("Status code" ,"400", String.valueOf(response.statusCode()) , test);
	
	
	//Validations
	
	JSONObject innerJson = new JSONObject(response.getBody().asString());
	
	
	String Ref = innerJson.get("reference").toString();
	ApiHelper.AssertEquals("reference" ,"Pascal12", Ref, test);
	
	String error = innerJson.get("errorMessage").toString();
	ApiHelper.AssertEquals("errorMessage" ,"The person is not found using specified Identity Number", error, test);
	
	
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
	}

	

}
