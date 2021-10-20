package runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.exergySoapRequest.PersonHighRisk;
import com.exergySoapRequest.PersonPassportNumber;
import com.exergySoapRequest.PersonPassportNumberValid;
import com.exergySoapRequest.PersonTest;
import com.exergySoapRequest.PersonVeryHigh;
import com.exergySoapRequest.ScreenAndVerifyPartyOrganisation;
import com.exergySoapRequest.ScreenAndVerifyPartyPerson;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class partyVerificationSoapRunner {
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Hollard PartyVerification API(SOAP) "+timeStamp+".html";
	String pageTile = "Hollard PartyVerification API"; 
	String TesterName = System.getProperty("user.name");
	ExtentReports extent=new ExtentManager().extentTest(reportname, reportname, TesterName);
	
	
	@Test(priority = 1,enabled=true)
	public void validatePersonHighRisk() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
	PersonHighRisk.validatePersonHighRisk(extent);
	ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 2,enabled=true)
	public void validatePersonPassPortNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		PersonPassportNumber.validatePersonPassPortNumber(extent);
		ApiHelper.softAssertion.assertAll();
		
	}

	@Test(priority = 6,enabled=true)
	public void validatePassPortValid() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonPassportNumberValid.validatePassPortValid(extent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 7,enabled=true)
	public void validatePersonTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonTest.validatePersonTest(extent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 8,enabled=true)
	public void validatePersonVeryHigh() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVeryHigh.validatePersonVeryHigh(extent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 9,enabled=true)
	public void validateOrganisation() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		ScreenAndVerifyPartyOrganisation.validateOrganisation(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	

	@Test(priority = 10,enabled=true)
	public void ScreenAndVerifyPartyPerson() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		ScreenAndVerifyPartyPerson.validatStatusCode(extent);
		ApiHelper.softAssertion.assertAll();
	}
	 
		@AfterTest
		public void EndTests() {
			extent.flush();

		}
	
	
}
