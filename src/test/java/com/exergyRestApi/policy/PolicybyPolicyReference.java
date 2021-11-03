package com.exergyRestApi.policy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.payloads.application.CreateApplicationPayloads;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;


public class PolicybyPolicyReference extends CreateApplicationPayloads {

public static void  policybyPolicyReference(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
    String policySitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySitUrl");
	
	String policySubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySubId");

	String policySubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySubKey");
	
	
	
	ExtentTest test;
	test=extent.createTest("Policy by Policy Reference");
	Response response;
	response =  ApiHelper.sendRestGetRequest(policySitUrl,policySubKey,policySubId,"/Policy/13402150?referenceType=Policy&lineOfBusinessSystem=Mip");
	response.prettyPrint();
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	
	//Validations
	
	JSONObject innerJson = new JSONObject(response.getBody().asString());
	System.out.println("++++++++++++++++++++++++"+ApiHelper.getJsonField(innerJson, "benefitPremiums"));
	
	String Policy = innerJson.get("policyNumber").toString();
	ApiHelper.AssertEquals("policyNumber" ,"13402150", Policy, test);
	
	String ProductCode = innerJson.get("productCode").toString();
	ApiHelper.AssertEquals("productCode" ,"1975", ProductCode, test);
	
	String premium = innerJson.getJSONObject("premiumCollection").getString("collectionMethod");
	ApiHelper.AssertEquals("collectionMethod" ,"Cash", premium, test);
	
	String amount = innerJson.getJSONObject("premiumAmount").getString("benefitPremiums");
	ApiHelper.AssertEquals("benefitPremiums" ,"876.44", amount, test);
	
	
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
}


	
}
