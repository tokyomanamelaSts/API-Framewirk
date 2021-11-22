package com.exergyRestApi.TestCases.ProductRates;

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


public class Product_1977_TestCases extends ProductsRateRepo{

	
	public static void  Product_1977(ExtentReports extent, String filename) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		

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
		    loadTCExpectedResponseFor1960(filename,TestCaseNumber,filename ) ;
		    
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
				
				String premiumAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R35 000", MainpremiumAmount35K, premiumAmount35K, test);
				
				
				String premiumAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R50 000", MainpremiumAmount50K, premiumAmount50K, test);
				
				String premiumAmount55K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R55 000", MainpremiumAmount55K, premiumAmount55K, test);
				
				
				String premiumAmount60K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R60 000", MainpremiumAmount60K, premiumAmount60K, test);
				
				String premiumAmount65K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R65 000", MainpremiumAmount65K, premiumAmount65K, test);
				
				String premiumAmount70K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R70 000", MainpremiumAmount70K, premiumAmount70K, test);
				
				String premiumAmount75K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit MainLife premium amount on R75 000", MainpremiumAmount75K, premiumAmount75K, test);
				
				// Memorial benefit
				
				String MainMemBenefit10K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R10 000", MainMemorialBenefit10K, MainMemBenefit10K, test);
				
				String MainMemBenefit15K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R15 000", MainMemorialBenefit15K, MainMemBenefit15K, test);
				
				String MainMemBenefit20K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R20 000", MainMemorialBenefit20K, MainMemBenefit20K, test);
				
				String MainMemBenefit35K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R35 000", MainMemorialBenefit35K, MainMemBenefit35K, test);
				
				String MainMemBenefit50K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R50 000", MainMemorialBenefit50K, MainMemBenefit50K, test);
				
				String MainMemBenefit55K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R55 000", MainMemorialBenefit55K, MainMemBenefit55K, test);
				
				String MainMemBenefit60K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R60 000", MainMemorialBenefit60K, MainMemBenefit60K, test);
				
				String MainMemBenefit65K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R65 000", MainMemorialBenefit65K, MainMemBenefit65K, test);
				
				String MainMemBenefit70K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R70 000", MainMemorialBenefit70K, MainMemBenefit70K, test);
				

				String MainMemBenefit75K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for MainLife premium amount on R75 000", MainMemorialBenefit75K, MainMemBenefit75K, test);
				
				// monthly Assistance
				
				String MainMonthlyAss10K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R10 000", MainMonthlyAssistance10K, MainMonthlyAss10K, test);
				

				String MainMonthlyAss15K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R15 000", MainMonthlyAssistance15K, MainMonthlyAss15K, test);
				

				String MainMonthlyAss20K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R20 000", MainMonthlyAssistance20K, MainMonthlyAss20K, test);
				

				String MainMonthlyAss35K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R35 000", MainMonthlyAssistance35K, MainMonthlyAss35K, test);
				

				String MainMonthlyAss50K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R50 000", MainMonthlyAssistance50K, MainMonthlyAss50K, test);
				

				String MainMonthlyAss55K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R55 000", MainMonthlyAssistance55K, MainMonthlyAss55K, test);
				

				String MainMonthlyAss60K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R60 000", MainMonthlyAssistance60K, MainMonthlyAss60K, test);
				

				String MainMonthlyAss65K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R65 000", MainMonthlyAssistance65K, MainMonthlyAss65K, test);
				

				String MainMonthlyAss70K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R70 000", MainMonthlyAssistance70K, MainMonthlyAss70K, test);
				

				String MainMonthlyAss75K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistances Benefit for MainLife premium amount on R75 000", MainMonthlyAssistance75K, MainMonthlyAss75K, test);
				
				//hospital benefits
				
				String MainHospiBen10K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R10 000", MainHospitalBenefit10K, MainHospiBen10K, test);
				

				String MainHospiBen15K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R15 000", MainHospitalBenefit15K, MainHospiBen15K, test);
				

				String MainHospiBen20K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R20 000", MainHospitalBenefit20K, MainHospiBen20K, test);
				

				String MainHospiBen35K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R35 000", MainHospitalBenefit35K, MainHospiBen35K, test);
				

				String MainHospiBen50K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R50 000", MainHospitalBenefit50K, MainHospiBen50K, test);
				

				String MainHospiBen55K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R55 000", MainHospitalBenefit55K, MainHospiBen55K, test);
				

				String MainHospiBen60K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R60 000", MainHospitalBenefit60K, MainHospiBen60K, test);
				

				String MainHospiBen65K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R65 000", MainHospitalBenefit65K, MainHospiBen65K, test);
				

				String MainHospiBen70K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R70 000", MainHospitalBenefit70K, MainHospiBen70K, test);
				

				String MainHospiBen75K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(HospitalBenindex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Hospital Cashback Benefit for MainLife premium amount on R75 000", MainHospitalBenefit75K, MainHospiBen75K, test);
				
				// vehicle benefits
				
				

				String MainVehicleBen4_5K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(VehAccIndex-1).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Vehicle Benefit for MainLife premium amount on R4500", MainVehicleAccessBenefit4_5K, MainVehicleBen4_5K, test);
				

				String MainVehicleAccessBen6K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(VehAccIndex-1).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Vehicle Benefit for MainLife premium amount on R6000", MainVehicleAccessBenefit6K, MainVehicleAccessBen6K, test);
				

				String MainVehicleAccessBen10_5K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(VehAccIndex-1).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Vehicle Benefit for MainLife premium amount on R10 500", MainVehicleAccessBenefit10_5K, MainVehicleAccessBen10_5K, test);
				

				String MainVehicleAccessBen15K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(VehAccIndex-1).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Vehicle Benefit for MainLife premium amount on R15 000", MainVehicleAccessBenefit15K, MainVehicleAccessBen15K, test);
				
				// lifecover main
				
				
				String mainlifeCoverBen10K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R10 000 ", MainLifeCoverBenefit10K, mainlifeCoverBen10K, test);
				
				String mainlifeCoverBen15K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R15 000", MainLifeCoverBenefit15K, mainlifeCoverBen15K, test);
				
				String mainlifeCoverBen20K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R20 000", MainLifeCoverBenefit20K, mainlifeCoverBen20K, test);
				
				String mainlifeCoverBen35K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R35 000", MainLifeCoverBenefit35K, mainlifeCoverBen35K, test);
				
				
				String mainlifeCoverBen50K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R50 000", MainLifeCoverBenefit50K, mainlifeCoverBen50K, test);
				
				String mainlifeCoverBen55K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R55 000", MainLifeCoverBenefit55K, mainlifeCoverBen55K, test);
				
				
				String mainlifeCoverBen60K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R60 000", MainLifeCoverBenefit60K, mainlifeCoverBen60K, test);
				
				String mainlifeCoverBen65K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R65 000", MainLifeCoverBenefit65K, mainlifeCoverBen65K, test);
				
				String mainlifeCoverBen70K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R70 000", MainLifeCoverBenefit70K, mainlifeCoverBen70K, test);
				
				String mainlifeCoverBen75K = innerJson.getJSONArray("lifesAssured").getJSONObject(mainLifeIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit MainLife premium amount on R75 000", MainLifeCoverBenefit75K, mainlifeCoverBen75K, test);
				
				// Funeral Benefit for partner
				setindexes(response, "Partner"); 

				String partnerPremAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R10 000", partnerPremiumAmount10K, partnerPremAmount10K, test);
				
				String partnerPremAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R15 000", partnerPremiumAmount15K, partnerPremAmount15K, test);
				
				String partnerPremAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R20 000", partnerPremiumAmount20K, partnerPremAmount20K, test);
				
				
				String partnerPremAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R35 000", partnerPremiumAmount35K, partnerPremAmount35K, test);
				
				String partnerPremAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R50 000", partnerPremiumAmount50K, partnerPremAmount50K, test);
		
				String partnerPremAmount55K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R55 000", partnerPremiumAmount55K, partnerPremAmount55K, test);
		
				String partnerPremAmount60K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R60 000", partnerPremiumAmount60K, partnerPremAmount60K, test);
		
				String partnerPremAmount65K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R65 000", partnerPremiumAmount65K, partnerPremAmount65K, test);
		
				String partnerPremAmount70K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R70 000", partnerPremiumAmount70K, partnerPremAmount70K, test);
		
				String partnerPremAmount75K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Funeral Benefit for Partner premium amount on R75 000", partnerPremiumAmount75K, partnerPremAmount75K, test);
	
				
				String partnerMemBenefit10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R10 000", MainMemorialBenefit10K, partnerMemBenefit10K, test);
				
				String partnerMemBenefit15K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R15 000", MainMemorialBenefit15K, partnerMemBenefit15K, test);
				
				String partnerMemBenefit20K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R20 000", MainMemorialBenefit20K, partnerMemBenefit20K, test);
				
				String partnerMemBenefit35K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R35 000", MainMemorialBenefit35K, partnerMemBenefit35K, test);
				
				String partnerMemBenefit50K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R50 000", MainMemorialBenefit50K, partnerMemBenefit50K, test);
				
				String partnerMemBenefit55K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R55 000", MainMemorialBenefit55K, partnerMemBenefit55K, test);
				
				String partnerMemBenefit60K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R60 000", MainMemorialBenefit60K, partnerMemBenefit60K, test);
				
				String partnerMemBenefit65K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R65 000", MainMemorialBenefit65K, partnerMemBenefit65K, test);
				
				String partnerMemBenefit70K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R70 000", MainMemorialBenefit70K, partnerMemBenefit70K, test);
				
				String partnerMemBenefit75K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial Benefit for partner premium amount on R75 000", MainMemorialBenefit75K, partnerMemBenefit75K, test);
				
				
				// Memorial benefit for Partner
				
				String PartnerMemBenefit10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MemBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Memorial benefit for Partner premium amount on R10 000", partnerMemorialBenefit10K, PartnerMemBenefit10K, test);
				
				//lifecover partner

				
				String PartnerCoverBen50K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit Partner premium amount on R50 000", partnerLifeCoverBenefit50K, PartnerCoverBen50K, test);
				
				String PartnerCoverBen55K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit Partner premium amount on R55 000", partnerLifeCoverBenefit55K, PartnerCoverBen55K, test);
				
				
				String PartnerCoverBen60K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit Partner premium amount on R60 000", partnerLifeCoverBenefit60K, PartnerCoverBen60K, test);
				
				String PartnerCoverBen65K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit Partner premium amount on R65 000", partnerLifeCoverBenefit65K, PartnerCoverBen65K, test);
				
				String PartnerCoverBen70K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit Partner premium amount on R70 000", partnerLifeCoverBenefit70K, PartnerCoverBen70K, test);
				
				String PartnerCoverBen75K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(lifeCoverBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Life Cover Benefit Partner premium amount on R75 000", partnerLifeCoverBenefit75K, PartnerCoverBen75K, test);
				
				/// monthly ass for partner
				
				String PartnerMonthlyAssist10K = innerJson.getJSONArray("lifesAssured").getJSONObject(PartnerIndex).getJSONArray("benefits").getJSONObject(MonAssIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("Monthly Assistance Benefit for Partner premium amount on R10 000", partnerMonthlyBenefit1K, PartnerMonthlyAssist10K, test);
				
				
				
				// Child
				setindexes(response, "Child"); 
				String ChildpremiumAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R10 000 ", ChildPremiumAmount10K, ChildpremiumAmount10K, test);
				
				String ChildpremiumAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R15 000", ChildPremiumAmount15K, ChildpremiumAmount15K, test);
				
				String ChildpremiumAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Childpremium amount on R20 000", ChildPremiumAmount20K, ChildpremiumAmount20K, test);
				
				
				String ChildpremiumAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R35 000", ChildPremiumAmount35K, ChildpremiumAmount35K, test);
				
				String ChildpremiumAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R50 000", ChildPremiumAmount50K, ChildpremiumAmount50K, test);
				

				String ChildpremiumAmount55K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R55 000", ChildPremiumAmount55K, ChildpremiumAmount55K, test);
				

				String ChildpremiumAmount60K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R60 000", ChildPremiumAmount60K, ChildpremiumAmount60K, test);
				

				String ChildpremiumAmount65K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R65 000", ChildPremiumAmount65K, ChildpremiumAmount65K, test);
			
				String ChildpremiumAmount70K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R70 000", ChildPremiumAmount70K, ChildpremiumAmount70K, test);
				
				String ChildpremiumAmount75K = innerJson.getJSONArray("lifesAssured").getJSONObject(ChildIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Child premium amount on R75 000", ChildPremiumAmount75K, ChildpremiumAmount75K, test);
	 
				
				
				// Parent
				
				setindexes(response, "Parent"); 
				
				String ParentPremAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R10 000 ", ParentPremiumAmount10K, ParentPremAmount10K, test);
				
				String ParentPremAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R15 000", ParentPremiumAmount15K, ParentPremAmount15K, test);
				
				String ParentPremAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R20 000", ParentPremiumAmount20K, ParentPremAmount20K, test);
				
				String ParentPremAmount35K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(3).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R35 000", ParentPremiumAmount35K, ParentPremAmount35K, test);
				
				
				String ParentPremAmount50K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(4).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R50 000", ParentPremiumAmount50K, ParentPremAmount50K, test);
			
				String ParentPremAmount55K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(5).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R55 000", ParentPremiumAmount55K, ParentPremAmount55K, test);
			

				String ParentPremAmount60K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(6).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R60 000", ParentPremiumAmount60K, ParentPremAmount60K, test);
			

				String ParentPremAmount65K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(7).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R65 000", ParentPremiumAmount65K, ParentPremAmount65K, test);
			
				

				String ParentPremAmount70K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(8).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R70 000", ParentPremiumAmount70K, ParentPremAmount70K, test);
			

				String ParentPremAmount75K = innerJson.getJSONArray("lifesAssured").getJSONObject(ParentIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(9).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Parent premium amount on R75 000", ParentPremiumAmount75K, ParentPremAmount75K, test);
			
				
// Extended child
			
				
				// Extended adult
				
				setindexes(response, "ExtendedFamilyAdult"); 
				
				String extendedAdultPremAmount10K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(0).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R10 000 ", ExtendedAdultPremium10K, extendedAdultPremAmount10K, test);
				
				String extendedAdultPremAmount15K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(1).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R15 000", ExtendedAdultPremium15K, extendedAdultPremAmount15K, test);
				
				String extendedAdultPremAmount20K = innerJson.getJSONArray("lifesAssured").getJSONObject(extendAdultIndex).getJSONArray("benefits").getJSONObject(FunBenIndex).getJSONArray("premiums").getJSONObject(2).get("premiumAmount").toString();
				ApiHelper.AssertEquals("FuneralBenefit Extended family Adult premium amount on R20 000", ExtendedAdultPremium20K, extendedAdultPremAmount20K, test);
				
				
				
			}
			test.info( "Find request body(Payload) below");
			test.info( MarkupHelper.createCodeBlock(reqBody,CodeLanguage.JSON));	
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			
	}
	
	
}
}
