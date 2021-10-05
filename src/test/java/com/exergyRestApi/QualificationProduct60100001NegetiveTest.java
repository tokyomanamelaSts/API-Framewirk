package com.exergyRestApi;


import com.applicationPayloads.QualificationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Utilities.ApiHelper;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class QualificationProduct60100001NegetiveTest extends QualificationPayloads {

public static void  qualificationProduct60100001NegetiveTest(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("PolicyByReferenceNumber");
	Response response;
	response =  ApiHelper.sendRestPostRequest(QualificationProduct60100000NegPayload, "/Qualification");
	response.prettyPrint();
	
}


	
}
