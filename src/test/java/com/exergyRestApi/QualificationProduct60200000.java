package com.exergyRestApi;

import com.applicationPayloads.CreateApplicationPayloads;
import com.applicationPayloads.QualificationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Utilities.ApiHelper;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class QualificationProduct60200000 extends QualificationPayloads {

public static void  qualificationProduct60200000(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
	
	
	
	ExtentTest test;
	test=extent.createTest("PolicyByReferenceNumber");
	Response response;
	response =  ApiHelper.sendRestPostRequest(QualificationProduct60200000Payload, "/Qualification");
	response.prettyPrint();
	
}


	
}
