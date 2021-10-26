package com.exergyRestApi.policy;

import com.applicationPayloads.CreateApplicationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;


public class PolicyListbyPolicyNumber extends CreateApplicationPayloads {

public static void  policyListbyPolicyNumber(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
    String policySitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySitUrl");
	
	String policySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySubId");

	String policySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySubKey");
	
	
	
	ExtentTest test;
	test=extent.createTest("Policy by Policy number");
	Response response;
	response =  ApiHelper.sendRestGetRequest(policySitUrl,policySubKey,policySubId,"/Policies/50000007");
	response.prettyPrint();
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
	//Validations
	/*
	JSONObject innerJson = new JSONObject(response.getBody().asString());
	System.out.println("++++++++++++++++++++++++"+ApiHelper.getJsonField(innerJson, "benefitPremiums"));
	
	String Policy = innerJson.get("policyNumber").toString();
	ApiHelper.AssertEquals("policyNumber" ,"50000007", Policy, test);
	
	String ProductCode = innerJson.get("productCode").toString();
	ApiHelper.AssertEquals("productCode" ,"13200000", ProductCode, test);
	
	String premium = innerJson.getJSONObject("premiumCollection").getString("$type");
	ApiHelper.AssertEquals("$type" ,"DebitOrder", premium, test);
	
	String amount = innerJson.getJSONObject("premiumCollection").getJSONObject("bankAccount").getString("accountHolderName");
	ApiHelper.AssertEquals("accountHolderName" ,"Boitumelo VictorMmolawa", amount, test);
	*/
}
	
}
