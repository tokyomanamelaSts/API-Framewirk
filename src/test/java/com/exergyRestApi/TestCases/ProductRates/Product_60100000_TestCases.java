package com.exergyRestApi.TestCases.ProductRates;

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


public class Product_60100000_TestCases extends ProductsRateRepo{

	
	public static void  Product_60100000(ExtentReports extent, String filename) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		

        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");
		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		ExtentTest test = null;
		Response response = null;
		
		String Query = "Select * from Requests where RunMe = 'Yes'";
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/"+filename+".xlsx",Query );
		
		while(recordset.next()){
			
			loadRequestData(recordset,"60100000");
			
			String reqBody= ratesPayloads.getProductsRates( lifeAssuredType1,Age1,lifeAssuredType2,Age2,lifeAssuredType3,Age3,lifeAssuredType4,Age4);	
		    test=extent.createTest(TestCaseNumber);
		    loadTCExpectedResponse(filename, TestCaseNumber,filename) ;
		    
		    System.out.println("\nStarting Testcase " + TestCaseNumber+" !!!!!!!!!!! \n");
		   
		    response =  ApiHelper.sendRestPostRequest(productSitUrl, productSubKey, productSubId, reqBody,"/Products/"+ProductCode+"/Rates?campaignCode="+ ProductCode);
		    test.info( MarkupHelper.createCodeBlock(description));
		  
		    ApiHelper.AssertEquals("Status code" ,statusCode, String.valueOf(response.statusCode()) , test);
			
			
			
			if(statusCode.equals(String.valueOf(response.statusCode()))) {
			
			//Validations
			JSONObject innerJson = new JSONObject(response.getBody().asString());
			
			//Main premiums
			setindexes(response, "MainLife"); 
			String premiumAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Main premium amount on R10 000 ", MainpremiumAmount10K, premiumAmount10K, test);
			
			
			String premiumAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Main premium amount on R20 000 ", MainpremiumAmount20K, premiumAmount20K, test);
			
			String premiumAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Main premium amount on R30 000 ", MainpremiumAmount30K, premiumAmount30K, test);
			
			String premiumAmount40K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Main premium amount on R40 000 ", MainpremiumAmount40K, premiumAmount40K, test);
			
			
			String premiumAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Main premium amount on R50 000 ", MainpremiumAmount50K, premiumAmount50K, test);
			
			String AirtimeBenefit = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(AirBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Airtime Benefit for main member ",NonePayeable, AirtimeBenefit, test);
			
			//Grocery Benefit premiums

			String GroceryAmount1K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(GrocBen).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Grocery R1000 ", NonePayeable, GroceryAmount1K, test);
			
			String GroceryAmount2K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(GrocBen).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Grocery R2000 ", NonePayeable, GroceryAmount2K, test);
			
			String GroceryAmount3K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(GrocBen).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Grocery R3000 ", NonePayeable, GroceryAmount3K, test);
			
			String GroceryAmount4K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(GrocBen).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Grocery R4000 ", NonePayeable, GroceryAmount4K, test);
			
			//Monthly Assistance Benefit
			
			String MonthlyAssistanceBenefit2K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Monthly Assistance Benefit for R2000 ", NonePayeable, MonthlyAssistanceBenefit2K, test);
			
			String MonthlyAssistanceBenefit4K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Monthly Assistance Benefit for R4000", NonePayeable, MonthlyAssistanceBenefit4K, test);
		
			String MonthlyAssistanceBenefit6K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Monthly Assistance Benefit R6000 ", NonePayeable, MonthlyAssistanceBenefit6K, test);
		
			String MonthlyAssistanceBenefit8K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(MonAssIndex).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Monthly Assistance Benefit R8000", NonePayeable, MonthlyAssistanceBenefit8K, test);
			
			
			//Partner premiums
			setindexes(response, "Partner"); 
			
			String partnerAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("partner premium amount on R10 000 ", partnerPremiumAmount10K, partnerAmount10K, test);
			
			
			String partnerAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
			ApiHelper.AssertEquals("partner premium amount on R20 000 ", partnerPremiumAmount20K, partnerAmount20K, test);
			
			String partnerAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
			ApiHelper.AssertEquals("partner premium amount on R30 000 ", partnerPremiumAmount30K, partnerAmount30K, test);
			
			String partnerAmount40K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
			ApiHelper.AssertEquals("partner premium amount on R40 000 ", partnerPremiumAmount40K, partnerAmount40K, test);
			
			
			String partnerAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
			ApiHelper.AssertEquals("partner premium amount on R50 000 ", partnerPremiumAmount50K, partnerAmount50K, test);
			
			
			
			
			
			//Child premiums
			setindexes(response, "Child"); 
			
			String ChildAmount5K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("child premium amount on R5 000 ", ChildPremiumAmount5K, ChildAmount5K, test);
			
			String ChildAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
			ApiHelper.AssertEquals("child premium amount on R10 000 ", ChildPremiumAmount10K, ChildAmount10K, test);
			
			String ChildAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
			ApiHelper.AssertEquals("child premium amount on R15 000 ", ChildPremiumAmount15K, ChildAmount15K, test);
			
			String ChildAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
			ApiHelper.AssertEquals("child premium amount on R20 000 ", ChildPremiumAmount20K, ChildAmount20K, test);
			
			
			String ChildAirtimeBenefit = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(AirBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Child Airtime Benefit ", NonePayeable, ChildAirtimeBenefit, test);
			
			
		    //Parent premiums
			setindexes(response, "Parent"); 
			
			String ParentAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Parent premium amount on R5 000 ", ParentPremiumAmount10K, ParentAmount10K, test);
			
			
			String ParentAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Parent premium amount on R20 000 depend amount 20000.0 ", ParentPremiumAmount20K, ParentAmount20K, test);
			

			String ParentAmount20K_2 = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Parent premium amount on R20 000 depend amount 30000.0 ", ParentPremiumAmount20K, ParentAmount20K_2, test);
			
			String ParentAirtimeBenefit = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(AirBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
			ApiHelper.AssertEquals("Parent Airtime Benefit" , NonePayeable, ParentAirtimeBenefit, test);
			
			}
			
			
			test.info( "Find request body(Payload) below");
			test.info( MarkupHelper.createCodeBlock(reqBody,CodeLanguage.JSON));	
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));	
			}
		
			
	}
	
	
}
