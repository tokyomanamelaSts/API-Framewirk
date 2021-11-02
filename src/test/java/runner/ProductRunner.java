package runner;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;

import Utilities.ExtentManager;

public class ProductRunner {

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Hollard Policy "+timeStamp+".html";
	String pageTile = "Hollard Policy API";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent;
	
	
	public ProductRunner() throws IOException {
		
		extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);
		
	}
	
	
	@Test (priority = 1,enabled = true)
	public void TC_001_60100000() throws IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Product.TC_001_60100000.Tc_001_60100000(extent);
		
	}
	
	@Test(priority = 2, enabled = true)
	public void TC_002_60200000() throws IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Product.TC_002_60200000.Tc_002_60200000(extent);
	}
	
	@Test(priority = 3, enabled = true)
	public void TC_003_1975() throws IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Product.TC_003_1975.TC_003_1975(extent);
		
	}
	
	@Test
	public void TC_004_1960E() throws IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Product.TC_004_1960E.Tc_004_1960E(extent);
		
	}
	
	@AfterTest
   	public void EndTests() {
   		extent.flush();

   	}
}
