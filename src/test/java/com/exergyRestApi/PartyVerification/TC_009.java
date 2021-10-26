package com.exergyRestApi.PartyVerification;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

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

import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.PartyVerificationRest.Payloads.PartyApiSitPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import io.restassured.response.Response;

public class TC_009 extends PartyApiUatPayloads {
	
	public static void  TC_009_PersonVerification_RiskRating_High_ID(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		String PartyVerificationUATUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationUATUrl");
		
		String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
		
		
		ExtentTest test;
		test=extent.createTest("TC_009_PersonVerification_RiskRating_High_IdentityNumber");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationUATUrl,PartySubKey, PartySubId,PersonVerificationRRHighID, "/Person/7606060795082/Verification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
		
		//Validations
		
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());

		String verification = innerJson.get("verification").toString();
		ApiHelper.AssertEquals("verification" ,"None", verification, test);
		
		String externalReference = innerJson.get("externalReference").toString();
		ApiHelper.AssertEquals("externalReference" ,"MyRef123", externalReference, test);
		
		String riskRating = innerJson.getJSONObject("riskRatingResult").getString("riskRating");
		ApiHelper.AssertEquals("riskRating" ,"High", riskRating, test);
		

		String riskRatingReason = innerJson.getJSONObject("riskRatingResult").getString("riskRatingReason");
		ApiHelper.AssertEquals("riskRatingReason" ,"Person is on PEP/FPIP/Adverse Media list", riskRatingReason, test);

		test.info( "Requirements: ");
		String proofOfIdentity = innerJson.getJSONArray("requirements").get(0).toString();
		ApiHelper.AssertEquals("Proof Of Identity " ,"ProofOfIdentity", proofOfIdentity, test);
		
		String proofOfAddress = innerJson.getJSONArray("requirements").get(1).toString();
		ApiHelper.AssertEquals("Proof Of Address" ,"ProofOfAddress", proofOfAddress, test);
		
		String proofOfSourceOfIncome = innerJson.getJSONArray("requirements").get(2).toString();
		ApiHelper.AssertEquals("Proof Of Address" ,"ProofOfAddress", proofOfAddress, test);
	
		String proofOfSourceOfWealth = innerJson.getJSONArray("requirements").get(3).toString();
		ApiHelper.AssertEquals("Proof of source of wealth " ,"ProofOfSourceOfWealth", proofOfSourceOfWealth, test);
		
			
		test.info( "ID Number used: 7606060795082");
		
		test.info( "Find payload(Request) below");
		
		test.info( MarkupHelper.createCodeBlock(PersonIndentificationBasic,CodeLanguage.JSON));
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
		
		
	}


	


	

}