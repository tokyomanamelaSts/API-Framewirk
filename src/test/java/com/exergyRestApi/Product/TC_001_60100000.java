package com.exergyRestApi.Product;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class TC_001_60100000 {

	

	public static void Tc_001_60100000(ExtentReports extent) throws IOException, SAXException, ParserConfigurationException {
		
		
        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");

		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		
		
		ExtentTest test;
		test=extent.createTest("TC_001_60100000");
		Response response;
		response =  ApiHelper.sendRestGetRequest(productSitUrl,productSubKey,productSubId, "/Products?productType=NonUnderwritten&productCode=60100000");
		
		
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
		
		if(response.statusCode() == 200 ) {
			
			JSONArray innerJson = new JSONArray(response.getBody().asString());
		
			
			test.info("productCode");
			String productCode = innerJson.getJSONObject(0).get("productCode").toString();
			ApiHelper.AssertEquals("productCode" ,"60100000", productCode, test);
			System.out.println(productCode);
			test.info("productName");
			String productName = innerJson.getJSONObject(0).get("productName").toString();
			ApiHelper.AssertEquals("productName" ,"Tyme Bank Funeral", productName, test);
			
			test.info("productRules");
			String debit = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("premiumCollectionMethodsAllowed").get(0).toString();
			ApiHelper.AssertEquals("premium Collection Method Debit Order" ,"DebitOrder", debit, test);
			
			String cash = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("premiumCollectionMethodsAllowed").get(1).toString();
			ApiHelper.AssertEquals("premium Collection Method cash Allowed" ,"Cash", cash, test);
			
			
			String beneficiary = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("allowedRolePlayers").get(0).toString();
			ApiHelper.AssertEquals(" Beneficiary Role Player" ,"Beneficiary", beneficiary, test);
			
			String policyPlayer = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("allowedRolePlayers").get(1).toString();
			ApiHelper.AssertEquals("Policy player Role Player" ,"PolicyPayer", policyPlayer, test);
			
			String policyHolder = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("allowedRolePlayers").get(2).toString();
			ApiHelper.AssertEquals("Policy holder Role Player" ,"PolicyHolder", policyHolder, test);
			
			//String proofOfSourceOfIncome = innerJson.getJSONArray("requirements").get(2).toString();
			//ApiHelper.AssertEquals("Proof Of Address" ,"ProofOfAddress", proofOfAddress, test);
		
			
		}
		
		
		
        test.info( "Product code used: 60100000");
		
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
		
	}
}
