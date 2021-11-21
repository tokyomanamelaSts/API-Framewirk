package com.exergyRestApi.TestCases.PartyVerification;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

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

public class TC_015 extends PartyApiUatPayloads{
	
	public static void PersonIdentification_Basic_Invalid_ID_Format(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		String PartyVerificationUATUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationUATUrl");
		
		String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
	
		ExtentTest test;
		test=extent.createTest("TC_015_PersonIdentification_Basic_Invalid_ID_Format");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationUATUrl,PartySubKey, PartySubId,PersonIndentificationBasic, "/Person/5145018089/Identification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"400", String.valueOf(response.statusCode()) , test);
		
		
		if(response.statusCode() == 400 ) {
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		

		String errorCode = innerJson.get("ErrorCode").toString();
		ApiHelper.AssertEquals("Error Code" ,"101", errorCode, test);
		
	
		String error = innerJson.get("ErrorMessage").toString();
		ApiHelper.AssertEquals("Error Message" ,"Identity Number not in the correct format |", error, test);
		
		String uri = innerJson.get("URI").toString();
		ApiHelper.AssertEquals("uri" ,"https://hollard-life-partyapi-uat.azurewebsites.net/Person/5145018089/Identification", uri, test);
	
		String type = innerJson.get("Type").toString();
		ApiHelper.AssertEquals("type" ,"Client", type, test);
		}
		
		test.info( MarkupHelper.createCodeBlock(PersonIndentificationBasic,CodeLanguage.JSON));
		test.info( "ID Number(Invalid) used: 5145018089");
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		

		
	}

}
