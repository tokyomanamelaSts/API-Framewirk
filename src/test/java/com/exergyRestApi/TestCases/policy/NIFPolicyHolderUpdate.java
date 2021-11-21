package com.exergyRestApi.TestCases.policy;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.policyPayloads.policyPayloads;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class NIFPolicyHolderUpdate extends policyPayloads {

public static void  nIFPolicyHolderUpdate(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
    String policySitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySitUrl");
	
	String policySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySubId");

	String policySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySubKey");
	
	
	
	ExtentTest test;
	test=extent.createTest("NIF Policy Holder Update");
	Response response;
	response =  ApiHelper.sendRestPutRequest(policySitUrl,policySubKey,policySubId,NIFPolicyHolderUpdatepayload, "/Policy/50000541/PolicyHolder");
	response.prettyPrint();
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	//Additions
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(NIFPolicyHolderUpdatepayload,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
}



	
}
