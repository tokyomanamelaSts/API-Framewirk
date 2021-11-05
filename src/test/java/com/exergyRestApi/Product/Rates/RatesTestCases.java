package com.exergyRestApi.Product.Rates;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

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


public class RatesTestCases extends ProductsRateRepo{

	
	public static void  Tc1ToTC3(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		

        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");
		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		ExtentTest test;
		Response response;
		
		String Query = "Select * from Requests where RunMe = 'Yes'";
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("/Users/tokyomanamela/git/APIAutomation/TestData/rates.xlsx",Query );
		
		while(recordset.next()){
			
			loadRequestData(recordset);
			String reqBody= ratesPayloads.getProductsRates( lifeAssuredType1,Age1,lifeAssuredType2,Age2,lifeAssuredType3,Age3,lifeAssuredType4,Age4);	
		    test=extent.createTest(TestCaseNumber);
		    loadTCExpectedResponse(TestCaseNumber) ;
		    response =  ApiHelper.sendRestPostRequest(productSitUrl, productSubKey, productSubId, reqBody,"/Products/"+ProductCode+"/Rates?campaignCode="+ ProductCode);
		    test.info( MarkupHelper.createCodeBlock(description));
		    ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
			}
		
		
		
		
		
		
		
	}
	
	
}
