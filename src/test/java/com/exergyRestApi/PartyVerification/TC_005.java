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

public class TC_005 extends PartyApiSitPayloads {
	
public static void PersonIdentificationComprehensiveWithMortalityInformation(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
			
		 String PartyVerificationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSitUrl");
		
		 String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		 String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
				
	
		ExtentTest test;
		test=extent.createTest("Person Verification Risk Rating High Passport");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationSitUrl,PartySubKey,PartySubId, PersonIndentificationWCMI,"/Person/9706145018084/Identification");
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
		
		
		//Validations
		
		
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		
		
			String Ref = innerJson.get("externalReference").toString();
			ApiHelper.AssertEquals("externalReference" ,"Pascal12", Ref, test);
			
			String firstNames = innerJson.getJSONObject("personIdentification").getJSONObject("person").getString("firstNames");
			ApiHelper.AssertEquals("firstNames" ,"LEONARDO RENALDO", firstNames, test);
			
			String Birth = innerJson.getJSONObject("personIdentification").getJSONObject("person").getString("birthDate");
			ApiHelper.AssertEquals("birthDate" ,"1997-06-14T00:00:00", Birth, test);
			
			String IDType = innerJson.getJSONObject("personIdentification").getString("identificationType");
			ApiHelper.AssertEquals("identificationType" ,"Enhanced", IDType, test);
			
		
		
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
		
	}

	

}
