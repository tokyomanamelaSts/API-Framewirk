package com.exergyRestApi.Product;

import java.io.IOException;
import com.applicationPayloads.CreateApplicationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;

import org.json.*;
import org.xml.sax.SAXException;


public class TC_006_1977 {
	
	public static void  Tc_006_1977(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		
	    String ProductURL = DataProvider.GetPropVal(DataProvider.propertyFilePath, "ProductURL");
		
		String ProductSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "ProductSubID");

		String ProductSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySubKey");
		
		
		
		ExtentTest test;
		test=extent.createTest("TC_006_1977");
		Response response;
		response =  ApiHelper.sendRestGetRequest(ProductURL,ProductSubKey,ProductSubId,"/Products?productType=FullyUnderwritten&productCode=1977");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
			if(response.statusCode() == 200 ) {
		
			JSONArray innerJson = new JSONArray (response.getBody().asString());
			
		
		
		}


}
	
}
