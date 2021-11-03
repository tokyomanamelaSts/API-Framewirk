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

public class TC_012 extends PartyApiUatPayloads {
	
	
	public static void PersonVerification_RiskRating_Low_Passport_Invalid_Passport(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		 String PartyVerificationUATUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationUATUrl");
		
		 String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		 String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
				

		ExtentTest test;
		test=extent.createTest("TC_012_PersonVerification_RiskRating_Low_Passport_Invalid_Passport");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationUATUrl,PartySubKey,PartySubId, PersonVerificationRRLowPassport,"/Person/A28849645/Verification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"400", String.valueOf(response.statusCode()) , test);
	
		
		if(response.statusCode() == 400 ) {
		
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		
		
		String Ref = innerJson.get("externalReference").toString();
		ApiHelper.AssertEquals("externalReference" ,"MyRef123", Ref, test);
					
		String risk = innerJson.getJSONObject("riskRatingResult").getString("riskRating");
		ApiHelper.AssertEquals("riskRating" ,"Low", risk, test);
					
		//String Birth = innerJson.get("reference").toString();
		//ApiHelper.AssertEquals("reference" ,"6309", Birth, test);
		}		
	    			
				
		test.info( "Passport Number used: A28849645");
				
	    test.info( "Find payload(Request) below");
		test.info( MarkupHelper.createCodeBlock(PersonVerificationRRLowPassport,CodeLanguage.JSON));
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
		
		
	}

	
	
}
