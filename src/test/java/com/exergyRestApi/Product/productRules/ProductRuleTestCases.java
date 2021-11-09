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

	
	public static void ProductRules(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		

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
		    
		    System.out.println("TESTCASE: "+TestCaseNumber+"\n");
		    
		    ApiHelper.AssertEquals("Status code" , String.valueOf(StatusCode), String.valueOf(response.statusCode()) , test);
		    
		    if(response.statusCode() ==  StatusCode) {
		    	
		    	
		    	
		    	JSONArray innerJson = new JSONArray(response.getBody().asString());
			    
			    String ResproductCode = innerJson.getJSONObject(0).get("productCode").toString();

				ApiHelper.AssertEquals("productCode" ,productCode, ResproductCode, test);
				
				
				loadProductIndex() ;

		    	
				String ResproductVersion = innerJson.getJSONObject(0).get("version").toString();
				ApiHelper.AssertEquals("version" ,version, ResproductVersion, test);
		    	
				String ResproductName = innerJson.getJSONObject(0).get("productName").toString();
				ApiHelper.AssertEquals("product Name" ,productName, ResproductName, test);

		    	
				String maxBen = innerJson.getJSONObject(0).getJSONObject("productRules").get("maxBeneficiaries").toString();
				ApiHelper.AssertEquals("maximum Beneficiaries" ,maxBeneficiaries, maxBen, test);
				
				//MainLife Assured
				String AssuredType = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("lifeAssuredType").toString();
				ApiHelper.AssertEquals("MainLife life Assured Type" ,MainLife_lifeAssuredType, AssuredType, test);
				
				
				String MaxCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals(" MainLife maximum Cover Allowed" ,Mainlife_maxCoverAllowed, MaxCoverAllowed, test);
				
				
				String MinCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MainLife minimum Cover Allowed" ,Mainlife_minCoverAllowed, MinCoverAllowed, test);
				
				
				String MinBenAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MainLife minimum benefits Allowed" ,Mainlife_minAllowed, MinBenAllowed, test);
						
				
				String MaxBenAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MainLife maximum benefits Allowed" ,Mainlife_maxAllowed, MaxBenAllowed, test);
				
				String MinAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAge").toString();
				ApiHelper.AssertEquals(" MainLife minimum age" ,Mainlife_minAge, MinAge, test);
				
				
				String MaxAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAge").toString();
				ApiHelper.AssertEquals("MainLife maximum age" ,Mainlife_maxAge, MaxAge, test);
				
				
				//Child
				
				String ChildLifeAssuredType = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(childBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(childCoverIndex).get("lifeAssuredType").toString();
				ApiHelper.AssertEquals("ChildLifeAssuredType", Child_lifeAssuredType, ChildLifeAssuredType, test);
				
				String ChildMinAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(childBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(childCoverIndex).get("minAllowed").toString();
				ApiHelper.AssertEquals("ChildMinAllowed", Child_minAllowed, ChildMinAllowed, test);
			
				String ChildMaxAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(childBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(childCoverIndex).get("maxAllowed").toString();
				ApiHelper.AssertEquals("ChildMaxAllowed", Child_maxAllowed, ChildMaxAllowed, test);
				
				String ChildMinCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(childBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(childCoverIndex).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("ChildMinCoverAllowed" , Child_minCoverAllowed, ChildMinCoverAllowed, test);
				
				String ChildMaxCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(childBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(childCoverIndex).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("ChildMaxCoverAllowed" , Child_maxCoverAllowed, ChildMaxCoverAllowed, test);
				
				String ChildMinAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(childBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(childCoverIndex).get("minAge").toString();
				ApiHelper.AssertEquals("ChildMinAge", Child_minAge, ChildMinAge, test);
			
				String ChildMaxAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(childBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(childCoverIndex).get("maxAge").toString();
				ApiHelper.AssertEquals("ChildMaxAge", Child_MaxAge, ChildMaxAge, test);
		
				//Parent
				String ParentLifeAssuredType = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(parentBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(parentCoverIndex).get("lifeAssuredType").toString();
				ApiHelper.AssertEquals("ParentLifeAssuredType", parent_lifeAssuredType, ParentLifeAssuredType, test);
				
				String ParentMinAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(parentBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(parentCoverIndex).get("minAllowed").toString();
				ApiHelper.AssertEquals("ParentMinAllowed", parent_minAllowed, ParentMinAllowed, test);
			
				String ParentMaxAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(parentBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(parentCoverIndex).get("maxAllowed").toString();
				ApiHelper.AssertEquals("ParentMaxAllowed", parent_maxAllowed, ParentMaxAllowed, test);
				
				String ParentMinCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(parentBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(parentCoverIndex).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("ParentMinCoverAllowed" ,parent_minCoverAllowed, ParentMinCoverAllowed, test);
				
				String ParentMaxCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(parentBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(parentCoverIndex).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("ParentMaxCoverAllowed" ,parent_maxCoverAllowed, ParentMaxCoverAllowed, test);
				
				String ParentMinAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(parentBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(parentCoverIndex).get("minAge").toString();
				ApiHelper.AssertEquals("ParentMinAge", parent_minAge, ParentMinAge, test);
			
				String ParentMaxAge = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(parentBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(parentCoverIndex).get("maxAge").toString();
				ApiHelper.AssertEquals("ParentMaxAge", parent_MaxAge, ParentMaxAge, test);
		
				

				
				
				//Partner LifeAssured
				
				String AssuredType2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(partnerBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(partnerCoverIndex).get("lifeAssuredType").toString();
				ApiHelper.AssertEquals("Partner life Assured Type" ,Partner_lifeAssuredType, AssuredType2, test);
				
				
				String MaxCoverAllowed2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(partnerBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(partnerCoverIndex).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals(" Partner maximum Cover Allowed" ,Partner_maxCoverAllowed, MaxCoverAllowed2, test);
				
				
				String MinCoverAllowed2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(partnerBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(partnerCoverIndex).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("Partner minimum Cover Allowed" ,Partner_minCoverAllowed, MinCoverAllowed2, test);
				
				
				String MinBenAllowed2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(partnerBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(partnerCoverIndex).get("minAllowed").toString();
				ApiHelper.AssertEquals("Partner minimum benefits Allowed" ,Partner_minAllowed, MinBenAllowed2, test);
						
				
				String MaxBenAllowed2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(partnerBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(partnerCoverIndex).get("maxAllowed").toString();
				ApiHelper.AssertEquals("Partner maximum benefits Allowed" ,Partner_maxAllowed, MaxBenAllowed2, test);
				
				String MinAge2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(partnerBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(partnerCoverIndex).get("minAge").toString();
				ApiHelper.AssertEquals(" Partner minimum age" ,Partner_minAge, MinAge2, test);
				
				
				String MaxAge2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(partnerBenIndex).getJSONArray("allowedLifesAssured").getJSONObject(partnerCoverIndex).get("maxAge").toString();
				ApiHelper.AssertEquals("Partner maximum age" ,Partner_maxAge, MaxAge2, test);
				
				
				
		    }
		    
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			}
		
		
		
		
	}
}

