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


public class UpdatePolicyHolder extends policyPayloads {

public static void  updatePolicyHolder(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Update Policy Holder");
	Response response;
	response =  ApiHelper.sendRestPutRequest(ApiHelper.policySitUrl,ApiHelper.policySubKey, ApiHelper.policySubId,UpdatePolicyHolderPayloads, "/Policy/50015319/PolicyHolder");

	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(UpdatePolicyHolderPayloads,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
	
}



	
}
