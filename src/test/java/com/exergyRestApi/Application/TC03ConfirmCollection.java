package com.exergyRestApi.Application;
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

public class TC03ConfirmCollection {
	
	public static void tc0003(ExtentReports extent) {
		
		ExtentTest test;
		test=extent.createTest("ConfirmCollection");
		
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

		JsonPath jsonPathEvaluator = response.jsonPath();
		String collectionReference = jsonPathEvaluator.get("collectionReference");
	
		RestAssured.baseURI = "https://apim-hl-life-test-za.azure-api.net";
		RestAssured.basePath = "/Collection";

		Response response2 =
		given()
		     .header("x-subscription-id", "Life-Integration-Team")
		     .header("Ocp-Apim-Subscription-Key", "d05d946b0e9b480ea9c2d751549bd5ef").contentType("application/json")
		.when()
		     .patch("/uat/"+collectionReference+"/Confirmation")
		.then().log().all()
		     .assertThat()
		     .statusCode(200)
		     .contentType(ContentType.JSON)
		     .extract()
		     .response();
		String jsonBody = response2.getBody().asString();
		

		try {
			Assert.assertEquals(response2.statusCode(), 200);
		

			test.pass("passed");
			//test.info(MarkupHelper.createCodeBlock(jsonBody,CodeLanguage.JSON));
			test.info(MarkupHelper.createCodeBlock(response2.asString(),CodeLanguage.JSON));
			
		}catch(AssertionError e) {
			test.fail("failed");
			//test.info(MarkupHelper.createCodeBlock(jsonBody,CodeLanguage.JSON));
			test.info(MarkupHelper.createCodeBlock(response2.asString(),CodeLanguage.JSON));
			
		}


		
		
	     
	}

}
