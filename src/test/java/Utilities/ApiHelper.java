package Utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import javax.xml.parsers.*;

import static io.restassured.RestAssured.given;

import java.io.*;

public class ApiHelper { 
	
	
	
	
	
	public static String bakingSitUrl = "https://hollardpoc.azure-api.net/uat/bank";
    public static String bakingSubId = "melhollard";
    public static String bakingSubKey = "8b0c22b05b8c45c2b3d57edafbd78018";
	
	
	public static String applicationSitUrl = "https://apim-hl-life-test-za.azure-api.net/Application/sit";
	public static String applicationSubId = "Life-Integration-Team";
	public static String applicationSubKey = "d05d946b0e9b480ea9c2d751549bd5ef";
	
	
	public static String policySitUrl = "https://apim-hl-life-test-za.azure-api.net/Policy/sit";
	public static String policySubId = "Automation-Test-Team";
	public static String policySubKey = "fc5e1ef728f44652a03e16c9525f2d49";
	
	
	public static SoftAssert softAssertion;
	
	
	
	
	public String converFileToString(InputStream inputStream) throws IOException {
	      //Creating an InputStream object
	      //creating an InputStreamReader object
	      InputStreamReader isReader = new InputStreamReader(inputStream);
	      //Creating a BufferedReader object
	      BufferedReader reader = new BufferedReader(isReader);
	      StringBuffer sb = new StringBuffer();
	      String str;
	      while((str = reader.readLine())!= null){
	         sb.append(str);
	      }
	      return sb.toString();
	   }
	
public static Response  sendRestPostRequest(String baseUrl, String subKey, String subId, String body  , String endpoint) throws SAXException, IOException, ParserConfigurationException {
	
	RestAssured.baseURI =baseUrl ;
	
	Response response = 
	given()
		.header("x-subscription-id", subId)
	    .header("Ocp-Apim-Subscription-Key", subKey).contentType("application/json")
	    .body( body)
	.when()
	   .post(endpoint)	
	.then()
			
			.extract()
			.response();
	return response;	
	}
		
public static Response  sendRestGetRequest(String baseUrl, String subKey, String subId, String endpoint) throws SAXException, IOException, ParserConfigurationException {
	
	

	RestAssured.baseURI =baseUrl;

	Response response = 
			given()
					.header("x-subscription-id",subId)
					.header("Ocp-Apim-Subscription-Key",subKey)
					.accept(ContentType.JSON)
			.when().get(endpoint)
					
			.then()
					.extract()
					.response();
	return response;	
	}

public static Response  sendRestPutRequest(String baseUrl,  String subKey, String subId,String body, String  endpoint) throws SAXException, IOException, ParserConfigurationException {
	
	
		RestAssured.baseURI = baseUrl;
	
	Response response = 
			given()
				.header("x-subscription-id", subId)
			    .header("Ocp-Apim-Subscription-Key",subKey ).contentType("application/json")
			    .body(body)
			.when()
			   .put(endpoint)	
			.then()
				.extract()
				.response();
			return response;	
	}
public static Response  sendRestPatchRequest(String baseUrl, String subKey, String subId, String body, String endpoint) throws SAXException, IOException, ParserConfigurationException {
	
	
	RestAssured.baseURI = baseUrl;

Response response = 
		given()
			.header("x-subscription-id", subId)
		    .header("Ocp-Apim-Subscription-Key", subKey).contentType("application/json")
		    .body(body)
		.when()
		   .patch(endpoint)	
		.then()
			.extract()
			.response();
		return response;	
}
	
 public static String getvaluefromxml(String res, String tagName) throws SAXException, IOException, ParserConfigurationException {
	  
	  	String value = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(res)));
		document.getDocumentElement().normalize();
		
		Element rootElement = document.getDocumentElement();
	    NodeList nList = document.getElementsByTagName("s:Envelope");
	    Node node = nList.item(0);
	    
	     if (node.getNodeType() == Node.ELEMENT_NODE)
	     {
	        
	        Element eElement = (Element) node;
	        value = eElement.getElementsByTagName(tagName).item(0).getTextContent();
	     }
	return value; 
  }
 
 public static void AssertEquals(String tagname ,String expected, String Actual, ExtentTest test) throws SAXException, IOException, ParserConfigurationException {
	
	 softAssertion = new SoftAssert();
	 
	 if(expected.trim().toLowerCase().equals(Actual.trim().toLowerCase())) {
		 
		
		 
		 test.pass("validation for "+tagname+" has passed");
		 System.out.println("validation for "+tagname+" has passed");
		 softAssertion.assertTrue(true);
			
		 softAssertion.assertAll();
		 
	 }
	 
	 else 
	 {
		 test.fail("validation for "+tagname+" has failled. expected "+expected+"  but got "+Actual );
		 System.out.println("validation for "+tagname+" has failed. expected "+expected+"  but got "+Actual);
		 
		 softAssertion.assertTrue(false);
			
		 softAssertion.assertAll();
		
	 }
	 
 }
 
 

}
