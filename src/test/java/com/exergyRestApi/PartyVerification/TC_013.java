package com.exergyRestApi.PartyVerification;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.PartyVerificationRest.Payloads.PartyApiSitPayloads;
import com.PartyVerificationRest.Payloads.PartyApiUatPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class TC_013 extends PartyApiUatPayloads {

	public static void PersonVerification_RiskRating_High_Passport(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		 String PartyVerificationUATUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationUATUrl");
		
		 String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		 String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
				

		ExtentTest test;
		test=extent.createTest("TC_013_PersonVerification_RiskRating_High_Passport");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationUATUrl,PartySubKey,PartySubId, PersonVerificationRRHighPassport,"/Person/A08977150/Verification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
		
		//Validations
		
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		
		
		
		String Ref = innerJson.get("externalReference").toString();
		ApiHelper.AssertEquals("externalReference" ,"MyRef123", Ref, test);
					
		String risk = innerJson.getJSONObject("riskRatingResult").getString("riskRating");
		ApiHelper.AssertEquals("riskRating" ,"High", risk, test);
					
		test.info( "Requirements: ");
		String proofOfIdentity = innerJson.getJSONArray("requirements").get(3).toString();
		ApiHelper.AssertEquals("Proof Of Identity " ,"ProofOfIdentity", proofOfIdentity, test);
		
		String proofOfAddress = innerJson.getJSONArray("requirements").get(2).toString();
		ApiHelper.AssertEquals("Proof Of Address" ,"ProofOfAddress", proofOfAddress, test);
		
		String proofOfSourceOfIncome = innerJson.getJSONArray("requirements").get(1).toString();
		ApiHelper.AssertEquals("Proof Of Address" ,"ProofOfSourceOfIncome", proofOfSourceOfIncome, test);
	
		String proofOfSourceOfWealth = innerJson.getJSONArray("requirements").get(0).toString();
		ApiHelper.AssertEquals("Proof of source of wealth " ,"ProofOfSourceOfWealth", proofOfSourceOfWealth, test);
		
		String watchlist = innerJson.getJSONArray("watchListHits").get(0).toString();
	
		
		ApiHelper.AssertEquals("WatchList " ,"PEP", watchlist, test);
					
	    			
				
		test.info( "Passport Number used: A08977150");
				
	    test.info( "Find payload(Request) below");
		test.info( MarkupHelper.createCodeBlock(PersonVerificationRRHighPassport,CodeLanguage.JSON));
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
		
		
	}
	 
}
