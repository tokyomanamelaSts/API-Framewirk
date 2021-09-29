package com.exergySoapRequest;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ExtentManager;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;



public class ScreenAndVerifyPartyPerson {
	
	public static void validatStatusCode(ExtentReports extent) throws URISyntaxException, IOException {

		ExtentTest test;
		test=extent.createTest("ScreenAndVerifyPartyPerson");
		String username = "mipusr";
		String password = "69hTryVKjMa4";

		FileInputStream fileInputStream = new FileInputStream(new File(".\\SoapRequest\\PartyVerificationPerson.xml"));

		RestAssured.baseURI = "https://uatsvc.hollard.co.za/PartyVerificationService";

		// System.out.print(IOUtils.toString(fileInputStream, "UTF-8"));

		Response response = given().auth().preemptive().basic(username, password)
				.header("Content-Type", "text/xml;charset=UTF-8")
				.header("SOAPAction", "http://hollard.co.za/PartyVerificationService/ScreenAndVerifyParty")
				.header("Authorization", "Basic bWlwdXNyOjY5aFRyeVZLak1hNA==").header("Accept-Encoding", "gzip,deflate")
				.header("Host", "uatsvc.hollard.co.za").and().body(IOUtils.toString(fileInputStream, "UTF-8")).when()
				.post("/PartyVerificationService.svc").then().statusCode(200).and().log().all().extract().response();

		int statusCode = response.getStatusCode();
		XmlPath jsXpath = new XmlPath(response.asString());
		String partyType = jsXpath.getString("q1:PartyType");
		System.out.println("q1:PartyType is: " + partyType);
try {
			
			Assert.assertEquals(statusCode, 200);

			test.pass("passed");
			//test.info(MarkupHelper.createCodeBlock(body,CodeLanguage.XML));
			test.info(MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.XML));
			

		}catch(AssertionError e) {
			test.fail("failed");
			//test.info(MarkupHelper.createCodeBlock(body,CodeLanguage.XML));
			test.info(MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.XML));
			

		}


}
}