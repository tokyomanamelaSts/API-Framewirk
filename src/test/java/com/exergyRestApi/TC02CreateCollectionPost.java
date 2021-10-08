package com.exergyRestApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.collectionpayload.CollectionPayLoad;

import Utilities.ExtentManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC02CreateCollectionPost {
	
	public static void validateCreateCollections(ExtentReports extent) {
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

	try {
		
		System.out.println("Response Body :" + jsonBody);

		JsonPath jsonPathEvaluator = response.jsonPath();

		String policyNumber = jsonPathEvaluator.get("policyNumber");

		System.out.println("The policyNumber is " + policyNumber);

		Assert.assertTrue(policyNumber.equals("13887792"));

		String policyReferenceNumber = jsonPathEvaluator.get("policyReference");

		System.out.println("The policyReferenceNumber is " + policyReferenceNumber);

		Assert.assertTrue(policyReferenceNumber.equals("1171113887792"));

		String tenderType = jsonPathEvaluator.get("tenderType");

		System.out.println("The tenderType is " + tenderType);

		Assert.assertTrue(tenderType.equals("Cash"));

		test.pass("passed");
		//test.info(MarkupHelper.createCodeBlock(jsonBody,CodeLanguage.JSON));
		test.info(MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
	}catch(AssertionError e) {
		test.fail("failed");
		//test.info(MarkupHelper.createCodeBlock(jsonBody,CodeLanguage.JSON));
		test.info(MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
	}


	
	 
     }
}
