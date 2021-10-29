package com.exergyRestApi.PartyVerification;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.PartyVerificationRest.Payloads.PartyApiUatPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class TC_020 extends PartyApiUatPayloads {

	
	public static void TC_020_PersonVerification_RiskRating_Low_Invalid_Passport_Format(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		 String PartyVerificationUATUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationUATUrl");
		
		 String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		 String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
				

		ExtentTest test;
		test=extent.createTest("TC_020_PersonVerification_RiskRating_Low_Invalid_Passport_Format");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationUATUrl,PartySubKey,PartySubId, PersonVerificationRRLowPassport,"/Person/A288654836/Verification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"400", String.valueOf(response.statusCode()) , test);
	
	
		if(response.statusCode() == 400 ) {
		
		
        JSONObject innerJson = new JSONObject(response.getBody().asString());
		
		
		String Ref = innerJson.get("Type").toString();
		ApiHelper.AssertEquals("Type" ,"Client", Ref, test);
		
		String code = innerJson.get("ErrorCode").toString();
		ApiHelper.AssertEquals("ErrorCode" ,"101", code, test);
		
		
		String msg = innerJson.get("FriendlyErrorMessage").toString();
		ApiHelper.AssertEquals("FriendlyErrorMessage" ,"Passport Number not in the correct format | ", msg, test);
		}	
		
        test.info( "Passport Number used: A288654836");
		
	    test.info( "Find payload(Request) below");
		test.info( MarkupHelper.createCodeBlock(PersonVerificationRRLowPassport,CodeLanguage.JSON));
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
		
	}
	
}
