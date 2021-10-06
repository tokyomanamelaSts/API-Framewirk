package com.exergyRestApi.policy;

import com.applicationPayloads.CreateApplicationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class DocumentsbyPolicyReference extends CreateApplicationPayloads {

public static void  documentsbyPolicyReference(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Documents by Policy Reference");
	Response response;
	response =  ApiHelper.sendRestGetRequest(ApiHelper.policySitUrl,ApiHelper.policySubKey, ApiHelper.policySubId,"/Policy/50000007/Attachments?policyHolderIdentityNumber=8412260245088");
	response.prettyPrint();
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
}



	
}
