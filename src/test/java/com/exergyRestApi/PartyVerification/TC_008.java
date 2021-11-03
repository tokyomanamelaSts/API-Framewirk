package com.exergyRestApi.PartyVerification;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.payloads.PartyVerificationRest.PartyApiSitPayloads;
import com.payloads.PartyVerificationRest.PartyApiUatPayloads;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import io.restassured.response.Response;

public class TC_008 extends PartyApiUatPayloads {
	
	public static void  TC_008_PersonVerification_RiskRating_Low_ID_Invalid_ID(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		String PartyVerificationUATUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationUATUrl");
		
		String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
		
		
		ExtentTest test;
		test=extent.createTest("TC_008_PersonVerification RiskRating_Low_IdentityNumber Invalid ID");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationUATUrl,PartySubKey, PartySubId,PersonVerificationRRLowID, "/Person/9306116219089/Verification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"400", String.valueOf(response.statusCode()) , test);

		
		if(response.statusCode() == 400 ) {
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		
		String errorCode = innerJson.get("ErrorCode").toString();
		ApiHelper.AssertEquals("Error Code" ,"404", errorCode, test);
	
		String error = innerJson.get("ErrorMessage").toString();
		ApiHelper.AssertEquals("Error Message" ,"The person is not found using specified Identity Number", error, test);
		}
		
		test.info( "ID Number used(Invalid): 9306116219089");
		test.info( "Find payload(Request) below");
		test.info( MarkupHelper.createCodeBlock(PersonIndentificationBasic,CodeLanguage.JSON));
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	}


	


	

}

