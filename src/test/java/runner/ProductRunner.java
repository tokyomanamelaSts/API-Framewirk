package runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.exergyRestApi.PartyVerification.TC_001;
import com.exergyRestApi.Product.*;
import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class ProductRunner {
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Product API"+timeStamp+".html";
	String pageTile = "Product API";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent;
	
	
	public ProductRunner() throws IOException {
		
		 extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);
		 
		}

	@Test(priority = 5,enabled=true)
	public void TC_005_1960L() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		TC_005_1960L.Tc_005_1960L(extent);
		ApiHelper.softAssertion.assertAll();
		
	}   
	

	@Test(priority = 6,enabled=true)
	public void TC_006_1977() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		TC_006_1977.Tc_006_1977(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 7,enabled=true)
	public void TC_007_1924() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		TC_007_1924.Tc_007_1924(extent); 
		ApiHelper.softAssertion.assertAll();
		
	} 
	

	@AfterTest
	public void EndTests() {
		
		
		extent.flush();

	}

}
