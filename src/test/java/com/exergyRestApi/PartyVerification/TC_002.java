package com.exergyRestApi.PartyVerification;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

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

public class TC_002 extends PartyApiUatPayloads{
	
	public static void PersonIdentification_Basic_Invalid_ID(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		String PartyVerificationUATUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationUATUrl");
		
		String PartySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubId");

		String PartySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "PartyVerificationSubKey");
	
	
		
		
		ExtentTest test;
		test=extent.createTest("TC_002_PersonIdentification_Basic_Invalid_ID");
		Response response;
		response =  ApiHelper.sendRestPostRequest(PartyVerificationUATUrl,PartySubKey, PartySubId,PersonIndentificationBasic, "/Person/0706145018084/Identification");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"400", String.valueOf(response.statusCode()) , test);
		
		
		//Validations
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		
	
		String error = innerJson.get("ErrorMessage").toString();
		ApiHelper.AssertEquals("Error Message" ,"The person is not found using specified Identity Number", error, test);
		
		String uri = innerJson.get("URI").toString();
		ApiHelper.AssertEquals("uri" ,"/Person/0706145018084/Identification", uri, test);
		
		test.info( MarkupHelper.createCodeBlock(PersonIndentificationBasic,CodeLanguage.JSON));
		test.info( "ID Number(Invalid) used: 0706145018084");
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		

		
	}

}
