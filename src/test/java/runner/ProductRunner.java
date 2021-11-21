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
import com.exergyRest.ApiTestCases.ProductRates.Product_1960C_TestCases;
import com.exergyRest.ApiTestCases.ProductRates.Product_1960E_TestCases;
import com.exergyRest.ApiTestCases.ProductRates.Product_1960L_TestCases;
import com.exergyRest.ApiTestCases.ProductRates.Product_60100000_TestCases;
import com.exergyRest.ApiTestCases.ProductRates.Product_60200000_TestCases;
import com.exergyRestApi.TestCases.PartyVerification.TC_001;
import com.exergyRestApi.TestCases.productRules.*;

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
	
	@Test(priority = 1,enabled=false)
    public void TC_ProductRules() throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
	ProductRuleTestCases.ProductRules(extent);
		ApiHelper.softAssertion.assertAll();
		 
		
	}
	
	@Test(priority = 2,enabled=true)
	public void Product_60200000_Rates() throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		Product_60200000_TestCases.Product_60200000(extent, "60200000");
		ApiHelper.softAssertion.assertAll();
		 
	} 
	
	@Test(priority = 4,enabled=true)
	public void Product_1960E_Rates() throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		Product_1960E_TestCases.Product_1960E(extent, "1960E");
		ApiHelper.softAssertion.assertAll();
	} 
	
	@Test(priority = 5,enabled=true)
	public void Product_60100000_Rates() throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		Product_60100000_TestCases.Product_60100000(extent, "60100000");
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 6,enabled=true)
	public void Product_1960C_Rates() throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
	
		Product_1960C_TestCases.Product_1960C(extent, "1960C");
		ApiHelper.softAssertion.assertAll();
	} 
	
	
	@Test(priority = 7,enabled=true)
	public void Product_1960L_Rates() throws URISyntaxException, SAXException, IOException, ParserConfigurationException, FilloException {
		
		Product_1960L_TestCases.Product_1960L(extent, "1960L");
		ApiHelper.softAssertion.assertAll();
	} 

	
	@AfterTest
	public void EndTests() {
		
		extent.flush();

	}
	

}
