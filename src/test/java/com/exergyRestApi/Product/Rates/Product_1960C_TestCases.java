package com.exergyRestApi.Product.Rates;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.exergyRestApi.Repo.Product.ProductsRateRepo;
import com.payloads.rates.ratesPayloads;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;


public class Product_1960C_TestCases extends ProductsRateRepo{

	
	public static void  Product_1960E(ExtentReports extent, String filename) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		

        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");
		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		ExtentTest test = null;
		Response response = null;
		
		String Query = "Select * from Requests where RunMe = 'Yes'";
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/"+filename+".xlsx",Query );
		
		while(recordset.next()){
			
			loadRequestData(recordset, "1960C");
			String reqBody= ratesPayloads.getProductsRates1960( lifeAssuredType1,Age1,lifeAssuredType2,Age2,lifeAssuredType3,Age3,lifeAssuredType4,Age4,lifeAssuredType5,Age5,lifeAssuredType6,Age6);	
		    test=extent.createTest(TestCaseNumber);
		    loadTCExpectedResponseFor1960(filename,TestCaseNumber) ;
		    
		    System.out.println("\nStarting Testcase " + TestCaseNumber+" !!!!!!!!!!! \n");
		   
		    response =  ApiHelper.sendRestPostRequest(productSitUrl, productSubKey, productSubId, reqBody,"/Products/"+ProductCode+"/Rates?campaignCode="+ ProductCode);
		    test.info( MarkupHelper.createCodeBlock(description));
		  
		    ApiHelper.AssertEquals("Status code" ,statusCode, String.valueOf(response.statusCode()) , test);
			
			
			
			if(statusCode.equals(String.valueOf(response.statusCode()))) {
				
				
				System.out.println("validations to be added here");
				
				
			}
			
			test.info( "Find request body(Payload) below");
			test.info( MarkupHelper.createCodeBlock(reqBody,CodeLanguage.JSON));	
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
	}
	
	
}
}
