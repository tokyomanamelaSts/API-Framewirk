package com.exergyRestApi.Application;


import com.applicationPayloads.QualificationPayloads;
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
import org.xml.sax.SAXException;


public class QualificationProduct1960 extends QualificationPayloads {

public static void  qualificationProduct1960(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
    String applicationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSitUrl");
	
	String applicationSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSubId");

	String applicationSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSubKey");
	
	
	
	ExtentTest test;
	test=extent.createTest("Qualification Product 1960");
	Response response;
	response =  ApiHelper.sendRestPostRequest(applicationSitUrl,applicationSubKey,applicationSubId,QualificationProduct1960Payload, "/Qualification");
	ApiHelper.AssertEquals("Status code" ,"200", "200" , test);
	
	
	String res = "{\n"
			+ "    \"productCode\": \"1960\",\n"
			+ "    \"qualificationReference\": \"NOU8FCME\",\n"
			+ "    \"qualificationResult\": false,\n"
			+ "    \"rejectionReason\": null,\n"
			+ "    \"policyList\": {\n"
			+ "        \"policy\": []\n"
			+ "    }\n"
			+ "}";
	
	

	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(QualificationProduct1960Payload,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(res,CodeLanguage.JSON));

   
	
}


	
}
