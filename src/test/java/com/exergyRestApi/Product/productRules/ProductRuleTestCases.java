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
		    
		    loadTCExpectedResponse(TestCaseNumber);
		    
		    ApiHelper.AssertEquals("Status code" , String.valueOf(StatusCode), String.valueOf(response.statusCode()) , test);
		    
		    if(response.statusCode() ==  StatusCode) {
		    	
		    	
		    	
		    	JSONArray innerJson = new JSONArray(response.getBody().asString());
			    
			    String ResproductCode = innerJson.getJSONObject(0).get("productCode").toString();
				ApiHelper.AssertEquals("productCode" ,productCode, ResproductCode, test);
				
				//Child
				
				String ChildLifeAssuredType = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(2).get("lifeAssuredType").toString();
				ApiHelper.AssertEquals("ChildLifeAssuredType", "Child", ChildLifeAssuredType, test);
				
				String ChildMinAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(2).get("minAllowed").toString();
				ApiHelper.AssertEquals("ChildMinAllowed", "0", ChildMinAllowed, test);
			
				String ChildMaxAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(2).get("maxAllowed").toString();
				ApiHelper.AssertEquals("ChildMaxAllowed", "5", ChildMaxAllowed, test);
				
				String ChildMinCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(2).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("ChildMinCoverAllowed" ,"5000", ChildMinCoverAllowed, test);
				
				String ChildMaxCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(2).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("ChildMaxCoverAllowed" ,"20000", ChildMaxCoverAllowed, test);
				
				String ChildMinAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(2).get("minAge").toString();
				ApiHelper.AssertEquals("ChildMinAge", "0", ChildMinAge, test);
			
				String ChildMaxAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(2).get("maxAge").toString();
				ApiHelper.AssertEquals("ChildMaxAge", "20", ChildMaxAge, test);
		
				//Parent
				String ParentLifeAssuredType = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(3).get("lifeAssuredType").toString();
				ApiHelper.AssertEquals("ParentLifeAssuredType", "Parent", ParentLifeAssuredType, test);
				
				String ParentMinAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(3).get("minAllowed").toString();
				ApiHelper.AssertEquals("ParentMinAllowed", "0", ParentMinAllowed, test);
			
				String ParentMaxAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(3).get("maxAllowed").toString();
				ApiHelper.AssertEquals("ParentMaxAllowed", "2", ParentMaxAllowed, test);
				
				String ParentMinCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(3).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("ParentMinCoverAllowed" ,"10000", ParentMinCoverAllowed, test);
				
				String ParentMaxCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(3).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("ParentMaxCoverAllowed" ,"20000", ParentMaxCoverAllowed, test);
				
				String ParentMinAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(3).get("minAge").toString();
				ApiHelper.AssertEquals("ParentMinAge", "18", ParentMinAge, test);
			
				String ParentMaxAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(3).get("maxAge").toString();
				ApiHelper.AssertEquals("ParentMaxAge", "79", ParentMaxAge, test);
		
				
		    	
		    }
		    
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			}
		
		
		
		
	}
}

