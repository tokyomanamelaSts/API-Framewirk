package com.PetStore.TestCases;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.PetStore.Repo.Repo;
import com.PetStore.payloads.AddNewDogPayloads;
import com.Soap.payloads.soapCalculatorPayload;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;



import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class CalcAddTestCases extends Repo{


	public static void SoapCalcTestCase  (ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {



		ExtentTest test = null;
		Response response;

		String Query = "Select * from Request where RunMe = 'Yes'";
		String baseUrl = "http://www.dneonline.com";
		String EndPoint = "/calculator.asmx";



		
			test=extent.createTest("TC_AddCalc001");
			test.info( MarkupHelper.createCodeBlock("Adding two number using soap Request"));
			test.info("URI Used: " + baseUrl);	
			test.info("Endpoint Used: " + EndPoint);	

			String reqBody= soapCalculatorPayload.CalcAdd(); 

			response =  ApiHelper.sendRestPostRequest(baseUrl, reqBody , EndPoint, "text/xml");
			statusCode = String.valueOf(response.statusCode());

			ApiHelper.AssertEquals("Status code" ,String.valueOf(200), String.valueOf(response.statusCode()) , test);

			if(statusCode.equals(String.valueOf(200))) {

			
				ApiHelper.AssertEquals("Status code" ,ApiHelper.getvaluefromxml(response.asString(), "AddResult"), String.valueOf(18) , test);

			}

			test.info( "Find request body(Payload) below");
			test.info( MarkupHelper.createCodeBlock(reqBody,CodeLanguage.XML));	
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.XML));

		}
	}

