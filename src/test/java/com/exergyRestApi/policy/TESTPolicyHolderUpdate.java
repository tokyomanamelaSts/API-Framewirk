package com.exergyRestApi.policy;

import com.applicationPayloads.CreateApplicationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.policyPayloads.policyPayloads;

import Utilities.ApiHelper;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class TESTPolicyHolderUpdate extends policyPayloads {

public static void  tESTPolicyHolderUpdate(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("TEST Policy Holder Update");
	Response response;
	response =  ApiHelper.sendRestPutRequest(ApiHelper.policySitUrl,ApiHelper.policySubKey, ApiHelper.policySubId,TESTPolicyHolderUpdate, "/Policy/50015319/PolicyHolder");
	response.prettyPrint();
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(TESTPolicyHolderUpdate,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
}



	
}
