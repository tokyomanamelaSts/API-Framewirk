package com.exergyRestApi.Application;


import com.applicationPayloads.RatesPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.xml.sax.SAXException;

public class Rates extends RatesPayloads {

public static void  rates(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
    String applicationSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "applicationSitUrl");
	
	String applicationSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");

	String applicationSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
	
	
	
	ExtentTest test;
	test=extent.createTest("Rates");
	Response response;
	response =  ApiHelper.sendRestPostRequest(applicationSitUrl,applicationSubKey,applicationSubId,RatesPayload, "/Rates");
	ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
	
	
	
	//Validations
		/*
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		System.out.println("++++++++++++++++++++++++"+ApiHelper.getJsonField(innerJson, "benefitPremiums"));
		
		String DocRef = innerJson.getJSONObject("documentReference").toString();
		ApiHelper.AssertEquals("documentReference" ,"A745D2F2-A85B-43EF-A195-AC3A009190EA", DocRef, test);
		
		String name = innerJson.get("documentName").toString();
		ApiHelper.AssertEquals("documentName" ,"Policy Alteration Letter_4092.html", name, test);
		
		String description = innerJson.getJSONObject("documentDescription").toString();
		ApiHelper.AssertEquals("documentDescription" ,"124.38", description, test);
		
		String arrears = innerJson.get("documentData").toString();
		ApiHelper.AssertEquals("documentData" ,"PGh0bWw+PGJvZHk+PHNjcmlwdCB0eXBlPSJ0ZXh0L2phdmFzY3JpcHQiPgp3aW5kb3cubG9jYXRpb24uaHJlZiA9ICJodHRwczovL2hvbGxhcmRzYXN0b3JhZ2UuYmxvYi5jb3JlLndpbmRvd3MubmV0L2RvY2Z1c2lvbi1kb2NzL0E3NDVEMkYyLUE4NUItNDNFRi1BMTk1LUFDM0EwMDkxOTBFQV80MDkyLnBkZj9zdj0yMDE4LTAzLTI4JnNyPWImc2lnPVJWVnRyT2l3QTFjMTJ1djNwWGR6JTJCMHdNb2Vqak5hdVNmSFVIN3Y2a0tyTSUzRCZzZT05OTk5LTEyLTMxVDIzJTNBNTklM0E1OVomc3A9ciIKPC9zY3JpcHQ+PC9ib2R5PjwvaHRtbD4=",arrears, test);
		*/
	
	test.info( "Find payload(Request) below");
    test.info( MarkupHelper.createCodeBlock(RatesPayload,CodeLanguage.JSON));
    test.info( "Find response below");
    test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));

	
	
}


	
}
