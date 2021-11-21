package com.exergyRestApi.TestCases.PartyVerification;

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

public class TC_010 extends PartyApiUatPayloads {

	
	public static void PersonVerification_RiskRating_HighIdentityNumber_Invalid_ID(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
		String PartyVerificationUATUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationUATUrl");
		
		 String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		 String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
				

		ExtentTest test;
		test=extent.createTest("TC_010_PersonVerificationRiskRatinghigh_Identitynumber_invalid_ID");
		Response response;

		response =  ApiHelper.sendRestPostRequest(PartyVerificationUATUrl,PartySubKey,PartySubId, PersonVerificationRRHighID,"/Person/7606060791111/Verification");

		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"400", String.valueOf(response.statusCode()) , test);
		
		
		if(response.statusCode() == 400 ) {
		
		
        JSONObject innerJson = new JSONObject(response.getBody().asString());
		
        String errorCode = innerJson.get("ErrorCode").toString();
		ApiHelper.AssertEquals("ErrorCode" ,"404", errorCode, test);
		
        

		String Ref = innerJson.get("reference").toString();
		ApiHelper.AssertEquals("reference" ,"Pascal12", Ref, test);
		
		String error = innerJson.get("errorMessage").toString();
		ApiHelper.AssertEquals("errorMessage" ,"The person is not found using specified Identity Number", error, test);
		
		}
		
		test.info( "ID Number used(Invalid): 7606060791111");
		
		test.info( "Find payload(Request) below");
	    test.info( MarkupHelper.createCodeBlock(PersonVerificationRRHighID,CodeLanguage.JSON));
	    test.info( "Find response below");
	    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
		
	}
}
