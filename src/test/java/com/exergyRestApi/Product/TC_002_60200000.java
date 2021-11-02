package com.exergyRestApi.Product;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class TC_002_60200000 {

	public static void Tc_002_60200000(ExtentReports extent) throws IOException, SAXException, ParserConfigurationException {
		
		
		
        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");

		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		
		
		ExtentTest test;
		test=extent.createTest("TC_002_60200000");
		Response response;
		response =  ApiHelper.sendRestGetRequest(productSitUrl,productSubKey,productSubId, "/Products?productType=NonUnderwritten&productCode=60200000");
		response.prettyPrint();
		
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
		
		
	}

	
	
}
