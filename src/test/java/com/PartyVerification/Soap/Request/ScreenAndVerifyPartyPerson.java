package com.PartyVerification.Soap.Request;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.ExtentManager;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;



public class ScreenAndVerifyPartyPerson {
	
	public static void validatStatusCode(ExtentReports extent) throws URISyntaxException, IOException, SAXException, ParserConfigurationException {

		ExtentTest test;
		test=extent.createTest("ScreenAndVerifyPartyPerson");
		String username = "mipusr";
		String password = "69hTryVKjMa4";
		
		System.out.println("Starting test ScreenAndVerifyPartyPerson.......\n========================================");
		
		FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"/SoapRequest/PartyVerificationPerson.xml"));
		RestAssured.baseURI = "https://uatsvc.hollard.co.za/PartyVerificationService";

		// System.out.print(IOUtils.toString(fileInputStream, "UTF-8"));

		Response response = given().auth().preemptive().basic(username, password)
				.header("Content-Type", "text/xml;charset=UTF-8")
				.header("SOAPAction", "http://hollard.co.za/PartyVerificationService/ScreenAndVerifyParty")
				.header("Authorization", "Basic bWlwdXNyOjY5aFRyeVZLak1hNA==").header("Accept-Encoding", "gzip,deflate")
				.header("Host", "uatsvc.hollard.co.za").and().body(IOUtils.toString(fileInputStream, "UTF-8")).when()
				.post("/PartyVerificationService.svc").then().extract().response();

		// validations
		
		
		test.info(MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.XML));
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
		String IdentityType = ApiHelper.getvaluefromxml(response.asString(), "q1:IdentityType");
		ApiHelper.AssertEquals("IdentityType", "NationalIdentityNumber",IdentityType, test);
		
		String fullname = ApiHelper.getvaluefromxml(response.asString(), "q1:FullName");
		ApiHelper.AssertEquals("fullname", "Maary DPIP Diederics",fullname, test);
		
		String AddressType = ApiHelper.getvaluefromxml(response.asString(), "q1:AddressType");
		ApiHelper.AssertEquals("AddressType", "None",AddressType, test);
		
		String AddressLine1 = ApiHelper.getvaluefromxml(response.asString(), "q1:AddressLine1");
		ApiHelper.AssertEquals("AddressLine1", "VLAEBERG ROAD",AddressLine1, test);
		
		String AddressLine2 = ApiHelper.getvaluefromxml(response.asString(), "q1:AddressLine2");
		ApiHelper.AssertEquals("AddressLine2", "LYNEDOCH",AddressLine2, test);
		
		String AddressLine3 = ApiHelper.getvaluefromxml(response.asString(), "q1:AddressLine3");
		ApiHelper.AssertEquals("AddressLine3", "STELLENBOSCH",AddressLine3, test);
		
		String IsMatch = ApiHelper.getvaluefromxml(response.asString(), "IsMatch");
		ApiHelper.AssertEquals("IsMatch", "False",IsMatch, test);
		
		
		String RiskRating = ApiHelper.getvaluefromxml(response.asString(), "RiskRating");
		ApiHelper.AssertEquals("RiskRating", "Low",RiskRating, test);
		
		String SourceReference = ApiHelper.getvaluefromxml(response.asString(), "SourceReference");
		ApiHelper.AssertEquals("SourceReference", "6310025637080",SourceReference, test);
		
		String Q2fullname = ApiHelper.getvaluefromxml(response.asString(), "q2:FullName");
		ApiHelper.AssertEquals("Q2fullname", "VUSI JOSEPH MNYANDU",Q2fullname, test);
		
}
}