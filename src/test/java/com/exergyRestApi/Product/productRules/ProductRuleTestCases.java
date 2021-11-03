package com.exergyRestApi.Product.productRules;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.exergyRestApi.Repo.Product.ProductRuleRepo;


import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class ProductRuleTestCases extends ProductRuleRepo{

	
	public static void  Tc1ToTC9(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		

        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");
		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		ExtentTest test;
		Response response;
		
		String Query = "Select * from Request where RunMe = 'Yes'";
		
		Recordset ResRecordset = null;
		Recordset ReqRecordset =DataProvider.getDataFromExcelbyQuery("TestData/ProductRules.xlsx",Query );
		
		while(ReqRecordset.next()){
			
			loadTCsData(ReqRecordset);
		    test=extent.createTest(TestCaseNumber);
		    response =  ApiHelper.sendRestGetRequest(productSitUrl, productSubKey, productSubId, "/Products?productType=NonUnderwritten&productCode="+ProductCode);
		    test.info( MarkupHelper.createCodeBlock(Description));
		    ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		    
		    if(response.statusCode() == 200 ) {
		    	
		    	loadTCExpectedResponse(TestCaseNumber);
		    	
		    	JSONArray innerJson = new JSONArray(response.getBody().asString());
			    
			    String ResproductCode = innerJson.getJSONObject(0).get("productCode").toString();
				ApiHelper.AssertEquals("productCode" ,productCode, ResproductCode, test);
		    	
		    }
		    
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			}
		
		
		
		
	}
}

