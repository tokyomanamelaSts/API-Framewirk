package Utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentTest;
import com.exergySoapRequest.PersonHighRisk;

import javax.xml.parsers.*;
import java.io.*;

public class ApiHelper {
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
	
	
	 
	 if(expected.trim().toLowerCase().equals(Actual.trim().toLowerCase())) {
		 
		 test.pass("validation for "+tagname+" has passed");
		 System.out.println("validation for "+tagname+" has passed");
		 Assert.assertTrue(true);
		 
		 
	 }
	 
	 else 
	 {
		 test.fail("validation for "+tagname+" has failled. expected "+expected+"  but got "+Actual );
		 System.out.println("validation for "+tagname+" has failed. expected "+expected+"  but got "+Actual);
		 //fail script
		 Assert.assertTrue(false);
		 
	 }
	 
 }
 
 

}
