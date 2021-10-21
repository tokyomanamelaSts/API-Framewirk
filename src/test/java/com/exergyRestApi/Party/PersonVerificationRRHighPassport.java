package com.exergyRestApi.Party;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.PartyApi.Payloads.PartyApiSitPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import io.restassured.response.Response;

public class PersonVerificationRRHighPassport extends PartyApiSitPayloads {
	
public static void  personVerificationRRHighPassport(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		
		ExtentTest test;
		test=extent.createTest("Person Verification Risk Rating High Passport");
		Response response;
		response =  ApiHelper.sendRestPostRequest(ApiHelper.PartyVerificationSitUrl,ApiHelper.PartySubKey, ApiHelper.PartySubId, PersonVerificationRRHighPassport,"A08977150/Verification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
	}

	

}
