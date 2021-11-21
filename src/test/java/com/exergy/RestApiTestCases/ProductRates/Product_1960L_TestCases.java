package com.exergy.RestApiTestCases.ProductRates;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
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


public class Product_1960L_TestCases extends ProductsRateRepo{

	
	public static void  Product_1960L(ExtentReports extent, String filename) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		

        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");
		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		ExtentTest test = null;
		Response response = null;
		
		String Query = "Select * from Requests where RunMe = 'Yes'";
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/"+filename+".xlsx",Query );
		
		while(recordset.next()){
			
			loadRequestData(recordset, filename);
			String reqBody= ratesPayloads.getProductsRates1960( lifeAssuredType1,Age1,lifeAssuredType2,Age2,lifeAssuredType3,Age3,lifeAssuredType4,Age4,lifeAssuredType5,Age5,lifeAssuredType6,Age6);	
		    test=extent.createTest(TestCaseNumber);
		    loadTCExpectedResponseFor1960(filename,TestCaseNumber, filename) ;
		    
		    System.out.println("\nStarting Testcase " + TestCaseNumber+" !!!!!!!!!!! \n");
		   
		    response =  ApiHelper.sendRestPostRequest(productSitUrl, productSubKey, productSubId, reqBody,"/Products/"+ProductCode+"/Rates?campaignCode="+ ProductCode);
		    test.info( MarkupHelper.createCodeBlock(description));
		   //response.prettyPrint();
		    ApiHelper.AssertEquals("Status code" ,statusCode, String.valueOf(response.statusCode()) , test);
			
			
			
			if(statusCode.equals(String.valueOf(response.statusCode()))) {
				
				
				//Validations
				JSONObject innerJson = new JSONObject(response.getBody().asString());
				
				//Main premiums
				setindexes(response, "MainLife"); 
				String premiumAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R10 000 ", MainpremiumAmount10K, premiumAmount10K, test);
				
				String premiumAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R15 000", MainpremiumAmount15K, premiumAmount15K, test);
				
				String premiumAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R20 000", MainpremiumAmount20K, premiumAmount20K, test);
				
				String premiumAmount25K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R25 000", MainpremiumAmount25K, premiumAmount25K, test);
				
				String premiumAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R30 000", MainpremiumAmount30K, premiumAmount30K, test);
				
				String premiumAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R35 000", MainpremiumAmount35K, premiumAmount35K, test);
				
				String premiumAmount40K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R40 000", MainpremiumAmount40K, premiumAmount40K, test);
				
				String premiumAmount45K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R45 000", MainpremiumAmount45K, premiumAmount45K, test);
				
				String premiumAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R50 000", MainpremiumAmount50K, premiumAmount50K, test);
				
				String premiumAmount55K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R55 000", MainpremiumAmount55K, premiumAmount55K, test);
				
				
				String premiumAmount60K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(10).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R60 000", MainpremiumAmount60K, premiumAmount60K, test);
				
				String premiumAmount65K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(11).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R65 000", MainpremiumAmount65K, premiumAmount65K, test);
				
				String premiumAmount70K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(12).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R70 000", MainpremiumAmount70K, premiumAmount70K, test);
				
				String premiumAmount75K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(13).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R75 000", MainpremiumAmount75K, premiumAmount75K, test);
				
				
				if(Integer.parseInt(Age1)<66) {
					
				// Memorial benefit
					String MainMemBenefit5K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
					ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R5 000", MainMemorialBenefit5K, MainMemBenefit5K, test);
					
					String MainMemBenefit10K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
					ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R10 000", MainMemorialBenefit10K, MainMemBenefit10K, test);
					
					//monthly assistance
					
					String MainMonthlyAssist0_5K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
					ApiHelper.AssertEquals("Monthly Assistance  for MainLife premium amount on R5 00", MainMonthlyAssistance0_5K, MainMonthlyAssist0_5K, test);
					
					String MainMonthlyAssist1K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
					ApiHelper.AssertEquals("Monthly Assistance  for MainLife premium amount on R1 000", MainMonthlyAssistance1K, MainMonthlyAssist1K, test);
					
					String MainMonthlyAssist1_5K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
					ApiHelper.AssertEquals("Monthly Assistance  for MainLife premium amount on R1 500", MainMonthlyAssistance1_5K, MainMonthlyAssist1_5K, test);
				
				}
				// Airtime benefit
				
				String MainLifeAirtimeBenefit = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(AirBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Airtime Bemefits for MainLife premium amount on R250", NonePayeable, MainLifeAirtimeBenefit, test);
				
				
				// Funeral Benefit for partner
				setindexes(response, "Partner"); 

				String partnerPremAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R10 000", partnerPremiumAmount10K, partnerPremAmount10K, test);
				
				String partnerPremAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R15 000", partnerPremiumAmount15K, partnerPremAmount15K, test);
				
				String partnerPremAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R20 000", partnerPremiumAmount20K, partnerPremAmount20K, test);
				
				String partnerPremAmount25K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R25 000", partnerPremiumAmount25K, partnerPremAmount25K, test);
				
				String partnerPremAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R30 000", partnerPremiumAmount30K, partnerPremAmount30K, test);
				
				String partnerPremAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R35 000", partnerPremiumAmount35K, partnerPremAmount35K, test);
				
				String partnerPremAmount40K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R40 000", partnerPremiumAmount40K, partnerPremAmount40K, test);
				
				String partnerPremAmount45K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R45 000", partnerPremiumAmount45K, partnerPremAmount45K, test);
				
				String partnerPremAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R50 000", partnerPremiumAmount50K, partnerPremAmount50K, test);
		
				String partnerPremAmount55K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R55 000", partnerPremiumAmount55K, partnerPremAmount55K, test);
		
				String partnerPremAmount60K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(10).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R60 000", partnerPremiumAmount60K, partnerPremAmount60K, test);
		
				String partnerPremAmount65K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(11).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R65 000", partnerPremiumAmount65K, partnerPremAmount65K, test);
		
				String partnerPremAmount70K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(12).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R70 000", partnerPremiumAmount70K, partnerPremAmount70K, test);
		
				String partnerPremAmount75K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(13).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R75 000", partnerPremiumAmount75K, partnerPremAmount75K, test);
		
				
//				Funeral Benefit with Retirement Paid Up	for Partner			
//
//				String partnerPremAmount_Retirement10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R10 000", partnerRetirementPaidUp10K, partnerPremAmount_Retirement10K, test);
//				
//				String partnerPremAmount_Retirement15K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R15 000", partnerRetirementPaidUp15K, partnerPremAmount_Retirement15K, test);
//				
//				String partnerPremAmount_Retirement20K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R20 000", partnerRetirementPaidUp20K, partnerPremAmount_Retirement20K, test);
//				
//				String partnerPremAmount_Retirement25K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R25 000", partnerRetirementPaidUp25K, partnerPremAmount_Retirement25K, test);
//				
//				String partnerPremAmount_Retirement30K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R30 000", partnerRetirementPaidUp30K, partnerPremAmount_Retirement30K, test);
//				
//				String partnerPremAmount_Retirement35K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R35 000", partnerRetirementPaidUp35K, partnerPremAmount_Retirement35K, test);
//				
//				String partnerPremAmount_Retirement40K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R40 000", partnerRetirementPaidUp40K, partnerPremAmount_Retirement40K, test);
//				
//				String partnerPremAmount_Retirement45K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R45 000", partnerRetirementPaidUp45K, partnerPremAmount_Retirement45K, test);
//				
//				String partnerPremAmount_Retirement50K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R50 000", partnerRetirementPaidUp50K, partnerPremAmount_Retirement50K, test);
//		
//				String partnerPremAmount_Retirement55K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R55 000", partnerRetirementPaidUp55K, partnerPremAmount_Retirement55K, test);
//		
//				String partnerPremAmount_Retirement60K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(10).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R60 000", partnerRetirementPaidUp60K, partnerPremAmount_Retirement60K, test);
//		
//				String partnerPremAmount_Retirement65K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(11).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R65 000", partnerRetirementPaidUp65K, partnerPremAmount_Retirement65K, test);
//		
//				String partnerPremAmount_Retirement70K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(12).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R70 000", partnerRetirementPaidUp70K, partnerPremAmount_Retirement70K, test);
//		
//				String partnerPremAmount_Retirement75K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(3).getJSONArray("premiums").getJSONObject(13).get("premiumAmount").toString();
//				ApiHelper.AssertEquals("Funeral Benefit with Retirement Paid Up	 for partner premium amount on R75 000", partnerRetirementPaidUp75K, partnerPremAmount_Retirement75K, test);
//		
				if(Integer.parseInt(Age2)<66) {
				
				// Memorial benefit for Partner
				String PartnerMemBenefit5K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial benefit for Partner premium amount on R5 000", partnerMemorialBenefit5K, PartnerMemBenefit5K, test);
				
				String PartnerMemBenefit10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial benefit for Partner premium amount on R10 000", partnerMemorialBenefit10K, PartnerMemBenefit10K, test);
				
				//monthly assistance Partner
				
				
				String PartnerMonthlyAssist5K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistance Benefit for Partner premium amount on R5 000", partnerMonthlyBenefit5K, PartnerMonthlyAssist5K, test);
				
				String PartnerMonthlyAssist10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistance Benefit for Partner premium amount on R10 000", partnerMonthlyBenefit1K, PartnerMonthlyAssist10K, test);
				}
				
				/*
				// Child
				setindexes(response, "Child"); 
				String ChildpremiumAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R10 000 ", ChildPremiumAmount10K, ChildpremiumAmount10K, test);
				
				String ChildpremiumAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R15 000", ChildPremiumAmount15K, ChildpremiumAmount15K, test);
				
				String ChildpremiumAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Childpremium amount on R20 000", ChildPremiumAmount20K, ChildpremiumAmount20K, test);
				
				String ChildpremiumAmount25K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R25 000", ChildPremiumAmount25K, ChildpremiumAmount25K, test);
				
				String ChildpremiumAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R30 000", ChildPremiumAmount30K, ChildpremiumAmount30K, test);
				
				String ChildpremiumAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R35 000", ChildPremiumAmount35K, ChildpremiumAmount35K, test);
				
				String ChildpremiumAmount40K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R40 000", ChildPremiumAmount40K, ChildpremiumAmount40K, test);
				
				String ChildpremiumAmount45K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R45 000", ChildPremiumAmount45K, ChildpremiumAmount45K, test);
				
				String ChildpremiumAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R50 000", ChildPremiumAmount50K, ChildpremiumAmount50K, test);
				*/
				
	// Parent
				setindexes(response, "Parent"); 
				
				String ParentPremAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R10 000 ", ParentPremiumAmount10K, ParentPremAmount10K, test);
				
				String ParentPremAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R15 000", ParentPremiumAmount15K, ParentPremAmount15K, test);
				
				String ParentPremAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R20 000", ParentPremiumAmount20K, ParentPremAmount20K, test);
				
				String ParentPremAmount25K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R25 000", ParentPremiumAmount25K, ParentPremAmount25K, test);
				
				String ParentPremAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R30 000", ParentPremiumAmount30K, ParentPremAmount30K, test);
				
				String ParentPremAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R35 000", ParentPremiumAmount35K, ParentPremAmount35K, test);
				
				String ParentPremAmount40K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R40 000", ParentPremiumAmount40K, ParentPremAmount40K, test);
				
				String ParentPremAmount45K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parentpremium amount on R45 000", ParentPremiumAmount45K, ParentPremAmount45K, test);
				
				String ParentPremAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R50 000", ParentPremiumAmount50K, ParentPremAmount50K, test);
			
				
// Extended child
				
				setindexes(response, "ExtendedFamilyChild"); 
				String extendedChildPremAmount5K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family child premium amount on R5 000", ExtendedChildPremium5K, extendedChildPremAmount5K, test);
				
				
				String extendedChildPremAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family child premium amount on R10 000 ", ExtendedChildPremium10K, extendedChildPremAmount10K, test);
				
				String extendedChildPremAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family child premium amount on R15 000", ExtendedChildPremium15K, extendedChildPremAmount15K, test);
				
				String extendedChildPremAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family child premium amount on R20 000", ExtendedChildPremium20K, extendedChildPremAmount20K, test);
				
				String extendedChildPremAmount25K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family child premium amount on R25 000", ExtendedChildPremium25K, extendedChildPremAmount25K, test);
				
				String extendedChildPremAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family child premium amount on R30 000", ExtendedChildPremium30K, extendedChildPremAmount30K, test);
				
				
				
				// Extended adult
				
				setindexes(response, "ExtendedFamilyAdult"); 
				
				String extendedAdultPremAmount5K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R5 000", ExtendedAdultPremium5K, extendedAdultPremAmount5K, test);
				
				
				String extendedAdultPremAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R10 000 ", ExtendedAdultPremium10K, extendedAdultPremAmount10K, test);
				
				String extendedAdultPremAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R15 000", ExtendedAdultPremium15K, extendedAdultPremAmount15K, test);
				
				String extendedAdultPremAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R20 000", ExtendedAdultPremium20K, extendedAdultPremAmount20K, test);
				
				String extendedAdultPremAmount25K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R25 000", ExtendedAdultPremium25K, extendedAdultPremAmount25K, test);
				
				String extendedAdultPremAmount30K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R30 000", ExtendedAdultPremium30K, extendedAdultPremAmount30K, test);
				
				
			}
			test.info( "Find request body(Payload) below");
			test.info( MarkupHelper.createCodeBlock(reqBody,CodeLanguage.JSON));	
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
	}
	
	
	
}
}
