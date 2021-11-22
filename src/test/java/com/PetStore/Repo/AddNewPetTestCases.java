package com.PetStore.Repo;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.PetStore.TestCases.Repo;
import com.PetStore.payloads.AddNewDogPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;



import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class AddNewPetTestCases extends Repo{


	public static void ProductRules  (ExtentReports extent, String fileName) throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {



		ExtentTest test = null;
		Response response;

		String Query = "Select * from Request where RunMe = 'Yes'";
		Recordset ReqRecordset =DataProvider.getDataFromExcelbyQuery("TestData/"+fileName+".xlsx",Query );
		String baseUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "baseUrl");

		while(ReqRecordset.next()){

			loadRequestData(ReqRecordset);
			loadTCExpectedResponse( TestCaseNumber, fileName);

			test=extent.createTest(TestCaseNumber);
			test.info( MarkupHelper.createCodeBlock(Description));
			test.info("URI Used: " + baseUrl);	
			test.info("Endpoint Used: " + endpoint);	

			String reqBody=  AddNewDogPayloads.addNewPet(PetId, categoryId, CategoryName, name, photoUrls, tagId, TagName, status);

			response =  ApiHelper.sendRestPostRequest(baseUrl, reqBody , endpoint);

			ApiHelper.AssertEquals("Status code" ,statusCode, String.valueOf(response.statusCode()) , test);

			if(statusCode.equals(String.valueOf(response.statusCode()))) {

				JSONObject jsson = new JSONObject(response.asString());

				ApiHelper.AssertEquals("Pet ID" ,ResPetId, ApiHelper.getJsonField(jsson, "id") , test);

				jsson = new JSONObject(ApiHelper.getJsonField(jsson, "category"));
				ApiHelper.AssertEquals("category ID" ,RescategoryId, ApiHelper.getJsonField(jsson, "id") , test);


			}

			test.info( "Find request body(Payload) below");
			test.info( MarkupHelper.createCodeBlock(reqBody,CodeLanguage.JSON));	
			test.info( "Find response below");
			test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

		}
	}
}

