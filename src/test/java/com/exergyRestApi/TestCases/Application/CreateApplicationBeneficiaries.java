package com.exergyRestApi.TestCases.Application;

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

public class CreateApplicationBeneficiaries extends CreateApplicationPayloads {

public static void  createApplicationBeneficiaries(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	

	String applicationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSitUrl");
	
	String applicationSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");

	String applicationSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
	
	
	
	ExtentTest test;
	test=extent.createTest("Create Application Beneficiaries");
	Response response;
	response =  ApiHelper.sendRestPutRequest(applicationSitUrl,applicationSubKey,applicationSubId,CreateApplicationBeneficiariesPayLoad, "/Application/1598/Beneficiaries");
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	//Validations
	if(response.statusCode() == 200 ) {
	
	JSONObject innerJson = new JSONObject(response.getBody().asString());
	String applicationRef = innerJson.get("applicationReference").toString();
	ApiHelper.AssertEquals("application Reference" ,"1598", applicationRef, test);
	
	String sourceReference = innerJson.get("sourceReference").toString();
	ApiHelper.AssertEquals("source Reference" ,"Tyme01", sourceReference, test);
	
	String benefitPremiums = innerJson.getJSONObject("premiumAmount").getString("benefitPremiums");
	ApiHelper.AssertEquals("benefit Premiums" ,"256", benefitPremiums, test);
	
	//String bankAccount = innerJson.getJSONObject("premiumCollection").getJSONObject("bankAccount").getString("accountNumber");
	//ApiHelper.AssertEquals("Account Number" ,"123123123", bankAccount, test);
	
	}
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(CreateApplicationBeneficiariesPayLoad,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
	
	
	//String pageName = innerJson.getJSONObject("applicationReference").getString("deviceSerialNumber");
	
    

}
}
