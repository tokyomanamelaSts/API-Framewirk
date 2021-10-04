package com.exergyRestApi;

import com.applicationPayloads.CreateApplicationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Utilities.ApiHelper;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class CreateApplicationBenefits extends CreateApplicationPayloads {

public static void  createApplicationBenefits(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	ExtentTest test;
	test=extent.createTest("PolicyByReferenceNumber");
	Response response;
	response =  ApiHelper.sendRestPutRequest("/Application/1598/Benefits/", CreateApplicationBenefitsPayLoad);
	response.prettyPrint();
	
}
	
}
