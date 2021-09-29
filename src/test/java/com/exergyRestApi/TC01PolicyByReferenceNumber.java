package com.exergyRestApi;

import static io.restassured.RestAssured.given;
import java.net.URI;
import java.net.URISyntaxException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ExtentManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TC01PolicyByReferenceNumber {
	
	

    
	public static void test0001(ExtentReports extent) throws URISyntaxException {
		ExtentTest test;
    	test=extent.createTest("PolicyByReferenceNumber");
		RestAssured.baseURI = "https://apim-hl-life-test-za.azure-api.net";

		/*
		 * Given Accept the response in JSON format When I Perform the Get Request for
		 * GetPolicyByReferenceNumber Then Status Code 200 OK should be Expected
		 * And Response Header ContentType:application/json should be Expected,
		 *
		 */


		Response response = 
		given()
				.header("x-subscription-id","Life-Integration-Team")
				.header("Ocp-Apim-Subscription-Key","d05d946b0e9b480ea9c2d751549bd5ef")
				.accept(ContentType.JSON)
		.when().get(new URI("/Collection/uat/Policy/1171113887792"))
				
		.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract()
				.response();
try {
		String jsonBody = response.getBody().asString();

		System.out.println("Response Body :" + jsonBody);

		JsonPath jsonPathEvaluator = response.jsonPath();

		String policyNumber = jsonPathEvaluator.get("policyNumber");

		System.out.println("The policyNumber is " + policyNumber);

		Assert.assertTrue(policyNumber.equals("13887792"));

		String policyReferenceNumber = jsonPathEvaluator.get("policyReference");

		System.out.println("The policyReferenceNumber is " + policyReferenceNumber);

		Assert.assertTrue(policyReferenceNumber.equals("1171113887792"));

		String idNumber = jsonPathEvaluator.get("identityNumber");

		System.out.println("The identityNumber is " + idNumber);

		Assert.assertTrue(idNumber.equals("8412121272081"));
		
		test.pass("passed");
		test.info(MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
}catch(AssertionError e){
	test.fail("failed");
	test.info(MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
}
		
	}
}
