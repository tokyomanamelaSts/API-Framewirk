package runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.exergyRestApi.Party.*;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class PartyApiRunner {
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Hollard Life Party API "+timeStamp+".html";
	String pageTile = "Hollard Life Party API";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);

	@Test(priority = 1,enabled=true)
	public void PersonIdentificationBasic() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonIdentificationBasic.personIdentificationBasic(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 2,enabled=true)
	public void PersonIdentificationEnhanced() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonIdentificationEnhanced.personIdentificationEnhanced(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 3,enabled=true)
	public void PersonIdentificationWCMI() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonIdentificationWCMI.personIdentificationWCMI(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 4,enabled=true)
	public void PersonIdentificationWCMI2() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonIdentificationWCMI2.personIdentificationWCMI2(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 5,enabled=true)
	public void PersonVerificationRRLowID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVerificationRRLowID.personVerificationRRLowID(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 6,enabled=true)
	public void PersonVerificationRRLowID2() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVerificationRRLowID2.personVerificationRRLowID2(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 7,enabled=true)
	public void PersonVerificationRRHighID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVerificationRRHighID.personVerificationRRHighID(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 8,enabled=true)
	public void PersonVerificationRRLowPassport() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVerificationRRLowPassport.personVerificationRRLowPassport(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 9,enabled=true)
	public void PersonVerificationRRHighPassport() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVerificationRRHighPassport.personVerificationRRHighPassport(extent); 
		
		ApiHelper.softAssertion.assertAll();
	}
	
	@AfterTest
	public void EndTests() {
		
		
		extent.flush();

	}
	
}
