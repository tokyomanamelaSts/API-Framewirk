package runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.exergyRestApi.Collection.TC01PolicyByReferenceNumber;
import com.exergyRestApi.Collection.TC02CreateCollectionPost;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class CollectionRunner {
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Hollard Collection API "+timeStamp+".html";
	String pageTile = "Hollard Collection API";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent;

	
	public CollectionRunner() throws IOException {
		
		 extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);
		 
		}
		
	
	@Test(priority = 1,enabled=true)
	public void TC01PolicyByReferenceNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC01PolicyByReferenceNumber.test0001(extent);
		ApiHelper.softAssertion.assertAll();
		
	}    
	
	@Test(priority = 2,enabled=true)
	public void validateCreateCollections() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC02CreateCollectionPost.validateCreateCollections(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@Test(priority = 3,enabled=true)
	public void TC03ConfirmCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Collection.TC03ConfirmCollection.tc0003(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@Test(priority = 4,enabled=true)
	public void TC04CancelCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Collection.TC04CancelCollection.tc0004(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@AfterTest
   	public void EndTests() {
   		extent.flush();

   	}
	
	
	
	
	
}
