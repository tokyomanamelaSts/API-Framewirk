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

	
	public static void  Product_1960C(ExtentReports extent, String filename) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		

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
		    loadTCExpectedResponseFor1960(filename,TestCaseNumber,"1960C" ) ;
		    
		    System.out.println("\nStarting Testcase " + TestCaseNumber+" !!!!!!!!!!! \n");
		   
		    response =  ApiHelper.sendRestPostRequest(productSitUrl, productSubKey, productSubId, reqBody,"/Products/"+ProductCode+"/Rates?campaignCode="+ ProductCode);
		    test.info( MarkupHelper.createCodeBlock(description));
		  
		    ApiHelper.AssertEquals("Status code" ,statusCode, String.valueOf(response.statusCode()) , test);
			
			
			
			if(statusCode.equals(String.valueOf(response.statusCode()))) {
				
				
				
				//Validations
				JSONObject innerJson = new JSONObject(response.getBody().asString());
				
				//Main premiums
				String premiumAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R10 000 ", MainpremiumAmount10K, premiumAmount10K, test);
				
				String premiumAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R15 000", MainpremiumAmount15K, premiumAmount15K, test);
				
				String premiumAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R20 000", MainpremiumAmount20K, premiumAmount20K, test);
				
				String premiumAmount25K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R25 000", MainpremiumAmount25K, premiumAmount25K, test);
				
				String premiumAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R30 000", MainpremiumAmount30K, premiumAmount30K, test);
				
				String premiumAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R35 000", MainpremiumAmount35K, premiumAmount35K, test);
				
				String premiumAmount40K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R40 000", MainpremiumAmount40K, premiumAmount40K, test);
				
				String premiumAmount45K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R45 000", MainpremiumAmount45K, premiumAmount45K, test);
				
				String premiumAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R50 000", MainpremiumAmount50K, premiumAmount50K, test);
				
				String premiumAmount55K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R55 000", MainpremiumAmount55K, premiumAmount55K, test);
				
				
				String premiumAmount60K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(10).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R60 000", MainpremiumAmount60K, premiumAmount60K, test);
				
				String premiumAmount65K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(11).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R65 000", MainpremiumAmount65K, premiumAmount65K, test);
				
				String premiumAmount70K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(12).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R70 000", MainpremiumAmount70K, premiumAmount70K, test);
				
				String premiumAmount75K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("premiums").getJSONObject(13).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R75 000", MainpremiumAmount75K, premiumAmount75K, test);
				
				// Memorial benefit
				String MainMemBenefit5K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R5 000", MainMemorialBenefit5K, MainMemBenefit5K, test);
				
				String MainMemBenefit10K = innerJson.getJSONArray("lifesAssured").getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R10 000", MainMemorialBenefit10K, MainMemBenefit10K, test);
				
			}
			
			test.info( "Find request body(Payload) below");
			test.info( MarkupHelper.createCodeBlock(reqBody,CodeLanguage.JSON));	
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
	}
	
	
}
}
