package com.exergyRestApi.Collection;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.payloads.collection.CollectionPayLoad;

import Utilities.ApiHelper;
import Utilities.ExtentManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC02CreateCollectionPost {
	
	public static void validateCreateCollections(ExtentReports extent) throws SAXException, IOException, ParserConfigurationException {
		ExtentTest test;
		test=extent.createTest("CreateCollection");

	RestAssured.baseURI = "https://apim-hl-life-test-za.azure-api.net";
	RestAssured.basePath = "/Collection";

	Response response =
	given()
	     .header("x-subscription-id", "Life-Integration-Team")
	     .header("Ocp-Apim-Subscription-Key", "d05d946b0e9b480ea9c2d751549bd5ef").contentType("application/json")
	     .body(CollectionPayLoad.addCollectionPayLoad())
	.when()
	     .post("/uat/CreateCollection")
	.then().log().all()
	     .assertThat()
	     .statusCode(200)
	     .contentType(ContentType.JSON)
	     .extract()
	     .response();
	/*
	* ***************************************************
	*
	* Validate the Response Body
	*
	* PolicyByReferenceNumber,policyNumber,tenderType
	*
	* ***************************************************
	*/

	String jsonBody = response.getBody().asString();
	JsonPath jsonPathEvaluator = response.jsonPath();

	String policyNumber = jsonPathEvaluator.get("policyNumber");
	ApiHelper.AssertEquals("policyNumber" ,"13887792", policyNumber, test);
	
	String policyReferenceNumber = jsonPathEvaluator.get("policyReference");
	ApiHelper.AssertEquals("policyNumber" ,"1171113887792", policyReferenceNumber, test);
		
	String tenderType = jsonPathEvaluator.get("tenderType");
	ApiHelper.AssertEquals("tenderType" ,"Cash", tenderType, test);
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(CollectionPayLoad.addCollectionPayLoad(),CodeLanguage.JSON));
   
	
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
	 
     }
}
