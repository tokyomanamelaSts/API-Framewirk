package com.exergyRestApi.TestCases.Collection;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TC01PolicyByReferenceNumber {

    
	public static void test0001(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		ExtentTest test;
    	test= extent.createTest("PolicyByReferenceNumber");
		RestAssured.baseURI = "https://apim-hl-life-test-za.azure-api.net";

		/*
		 * Given Accept the response in JSON format When I Perform the Get Request for
		 * GetPolicyByReferenceNumber Then Status Code 200 OK should be Expected
		 * And Response Header ContentType:application/json should be Expected
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

		String jsonBody = response.getBody().asString();
		System.out.println("Response Body :" + jsonBody);
		JsonPath jsonPathEvaluator = response.jsonPath();

		String policyNumber = jsonPathEvaluator.get("policyNumber");
		ApiHelper.AssertEquals("policyNumber" ,"13887792", policyNumber, test);
		
		String policyReferenceNumber = jsonPathEvaluator.get("policyReference");
		ApiHelper.AssertEquals("policyReference" ,"1171113887792", policyReferenceNumber, test);

		String idNumber = jsonPathEvaluator.get("identityNumber");
		ApiHelper.AssertEquals("identityNumber" ,"8412121272081", idNumber, test);
		
		
	    test.info( "Find response below");
	    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		
	}
}
