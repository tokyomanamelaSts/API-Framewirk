package com.exergyRestApi.Product.productRules;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class TC_003_1975 {

	public static void TC_003_1975(ExtentReports extent) throws IOException, SAXException, ParserConfigurationException {
		
		
        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");

		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		
		
		ExtentTest test;
		test=extent.createTest("TC_003_1975");
		Response response;
		response =  ApiHelper.sendRestGetRequest(productSitUrl,productSubKey,productSubId, "/Products?productType=NonUnderwritten&productCode=1975");
		response.prettyPrint();
		
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
		
	}

	
	
}
