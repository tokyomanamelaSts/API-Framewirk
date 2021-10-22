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
import com.exergyRestApi.PartyVerification.*;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class PartyVerificationRestRunner {
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Hollard Party Verification API(REST)"+timeStamp+".html";
	String pageTile = "Hollard Party Verification API(REST)";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);

	@Test(priority = 1,enabled=true)
	public void TC_001_PersonIdentification_Basic() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		TC_001.TC_001_PersonIdentification_Basic(extent);
		ApiHelper.softAssertion.assertAll();
		
	}   
	@Test(priority = 2,enabled=true)
	public void TC_002_PersonIdentification_Basic_Invalid_ID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_002.PersonIdentification_Basic_Invalid_ID(extent);
		ApiHelper.softAssertion.assertAll();
		
	}  
	
	@Test(priority = 3,enabled=true)
	public void TC_003_PersonIdentification_Enhanced() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_003.PersonIdentification_Enhanced(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 4,enabled=true)
	public void TC_004_PersonIdentification_Enhanced_Invalid_ID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_004.PersonIdentification_Enhanced_Invalid_ID(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 5,enabled=true)
	public void TC_005_PersonIdentificationComprehensiveWithMortalityInformation() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_005.PersonIdentificationComprehensiveWithMortalityInformation(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 6,enabled=true)
	public void TC_006_PersonIdentificationComprehensiveWithMortalityInformation_Invalid_ID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_006.PersonIdentificationComprehensiveWithMortalityInformation_Invalid_ID(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 7,enabled=true)
	public void TC_010_PersonVerificationRiskRatinghigh_Identitynumber_invalid_ID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_010.PersonVerification_RiskRating_HighIdentityNumber_Invalid_ID(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 8,enabled=true)
	public void TC_011_PersonVerification_RiskRating_Low_Passport() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_011.PersonVerification_RiskRating_Low_Passport(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 9,enabled=true)
	public void TC_012_PersonVerification_RiskRating_Low_Passport_Invalid_Passport() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_012.PersonVerification_RiskRating_Low_Passport_Invalid_Passport(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	
	@AfterTest
	public void EndTests() {
		
		
		extent.flush();

	}

	
	
}
