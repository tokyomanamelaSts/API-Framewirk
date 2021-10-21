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

public class TC_001 extends PartyApiSitPayloads {
	
	public static void  TC_001_PersonIdentification_Basic(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		String PartyVerificationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSitUrl");
		
		String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
		
		
		ExtentTest test;
		test=extent.createTest("TC_001_PersonIdentification_Basic");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationSitUrl,PartySubKey, PartySubId,PersonIndentificationBasic, "/Person/9706145018084/Identification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());
	
		
		String firstName = innerJson.getJSONObject("personIdentification").getJSONObject("person").getString("firstNames");
		ApiHelper.AssertEquals("firstNames" ,"LEONARDO RENALDO", firstName, test);
		
		String surname = innerJson.getJSONObject("personIdentification").getJSONObject("person").getString("surname");
		ApiHelper.AssertEquals("surname" ,"HOLLAND", surname, test);
		
		String gender = innerJson.getJSONObject("personIdentification").getJSONObject("person").getString("gender");
		ApiHelper.AssertEquals("gender" ,"Male", gender, test);
		
		String birthDate = innerJson.getJSONObject("personIdentification").getJSONObject("person").getString("birthDate");
		ApiHelper.AssertEquals("Birth Date" ,"1997-06-14T00:00:00", birthDate, test);
	
		String livingStatus = innerJson.getJSONObject("personIdentification").getJSONObject("person").getString("livingStatus");
		ApiHelper.AssertEquals("Living status" ,"Alive", livingStatus, test);
	
		test.info( "ID Number used: 9706145018084");
		
		test.info( "Find payload(Request) below");
		
		test.info( MarkupHelper.createCodeBlock(PersonIndentificationBasic,CodeLanguage.JSON));
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
		
		
	}


	


	

}
