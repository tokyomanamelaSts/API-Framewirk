package com.exergyRestApi.BankService;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.BankServicePayloads.BankServicePayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import io.restassured.response.Response;

public class RetrieveAuthenticatedCollection extends BankServicePayloads{

	public static void  retrieveAuthenticatedCollection(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		
		ExtentTest test;
		test=extent.createTest("Retrieve Authenticated Collection");
		Response response;
		response =  ApiHelper.sendRestPostRequest(ApiHelper.bakingSitUrl,ApiHelper.bakingSubKey, ApiHelper.bakingSubId,RetrieveAuthenticatedCollectionPayload, "/RetrieveAuthenticatedCollection");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
		
		
	}

	
}
