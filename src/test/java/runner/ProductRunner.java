package runner;

import java.io.IOException;

import java.net.URISyntaxException;

import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.codoid.products.exception.FilloException;
import com.exergyRestApi.PartyVerification.TC_001;
import com.exergyRestApi.Product.Rates.RatesTestCases;
import com.exergyRestApi.Product.productRules.*;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class ProductRunner {


	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Hollard Product "+timeStamp+".html";
	String pageTile = "Hollard Product API";

	String TesterName = System.getProperty("user.name");
	ExtentReports extent;
	
	public ProductRunner() throws IOException {

		 extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);
		 
		}
	
	@Test(priority = 1,enabled=true)
	public void TC_Rates1To3() throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		RatesTestCases.Tc1ToTC3(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 2,enabled=true)
public void TC_ProductRules1To9() throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
	ProductRuleTestCases.Tc1ToTC9(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@AfterTest
	public void EndTests() {
		
		extent.flush();

	}
	

}
