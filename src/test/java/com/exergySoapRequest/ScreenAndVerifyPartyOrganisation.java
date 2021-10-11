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


public class ScreenAndVerifyPartyOrganisation {

	public static void validateOrganisation(ExtentReports extent) throws URISyntaxException, IOException {

		ExtentTest test;
		test=extent.createTest("validateOrganisation");
		String username = "mipusr";
		String password = "69hTryVKjMa4";

	
		FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"/SoapRequest/PartyVerificationOrganisation.xml"));

		RestAssured.baseURI = "https://uatsvc.hollard.co.za/PartyVerificationService";
		
		// System.out.print(IOUtils.toString(fileInputStream, "UTF-8"));

		Response response =
		given()
			        .auth().preemptive().basic(username, password)
			        .cookie("TS01a7fb6e=01eb9fd3170a1c617c16d2810469fc51be347f94c7c48c41032a30faa60445670bbce72e2f9ead2d2c1c5528ea4c79f8362009786b0da59d9067a0dc7d40127d519bf3f9d7; f5avraaaaaaaaaaaaaaaa_session_=JPBBBPACPAJCEMEHNCMLBKBKFGOENAGMGICMOOEBEBBAAMBIPCONEIJCEAGKJOOHAKODPBGOEKPEAODAFOLAEJAKGHNKCCKJNPNMNCNBDOBDLCCHHGMMPGOEGEOPDMGJ")
				.header("Content-Type", "text/xml;charset=UTF-8")
				.header("SOAPAction", "http://hollard.co.za/PartyVerificationService/ScreenAndVerifyParty")
				.header("Authorization", "Basic bWlwdXNyOjY5aFRyeVZLak1hNA==").header("Accept-Encoding", "gzip,deflate")
				.header("Host", "uatsvc.hollard.co.za").and().body(IOUtils.toString(fileInputStream, "UTF-8"))
		.when()
				.post("/PartyVerificationService.svc")
		.then()         .and().log().all().extract().response();

		

		response.prettyPrint();

}

}
