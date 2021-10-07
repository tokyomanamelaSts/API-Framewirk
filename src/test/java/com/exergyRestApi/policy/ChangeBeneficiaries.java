package com.exergyRestApi.policy;


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


public class ChangeBeneficiaries extends policyPayloads {

public static void  changeBeneficiaries(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("Change Beneficiaries");
	Response response;
	response =  ApiHelper.sendRestPutRequest(ApiHelper.policySitUrl,ApiHelper.policySubKey, ApiHelper.policySubId,ChangeBeneficiariesPayload, "/Policy/50002008/Beneficiary?policyHolderIdentityNumber=8912111014088");
	response.prettyPrint();
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
	
	
}



	
}
