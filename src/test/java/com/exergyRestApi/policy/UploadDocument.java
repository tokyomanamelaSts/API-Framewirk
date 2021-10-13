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


public class UploadDocument extends policyPayloads {

public static void  uploadDocument(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Upload document");
	Response response;
	response =  ApiHelper.sendRestPostRequest(ApiHelper.policySitUrl,ApiHelper.policySubKey, ApiHelper.policySubId,UploadDocument, "/Policy/50000007/Attachment?policyHolderIdentityNumber=8412260245088");
	response.prettyPrint();
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	//additions
	 
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(UploadDocument,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

}



	
}
