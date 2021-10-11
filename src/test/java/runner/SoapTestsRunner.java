package runner;

import java.io.IOException;
import java.net.URISyntaxException;

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

import Utilities.ExtentManager;

public class SoapTestsRunner {
	
	
	String reportname = "SoapReport.html";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent=new ExtentManager().extentTest(reportname, reportname, TesterName);
	
	
	@Test(priority = 1,enabled=true)
	public void validatePersonHighRisk() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
	PersonHighRisk.validatePersonHighRisk(extent);
	}

	@Test(priority = 2,enabled=true)
	public void validatePersonPassPortNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		PersonPassportNumber.validatePersonPassPortNumber(extent);
		
	}

	@Test(priority = 6,enabled=true)
	public void validatePassPortValid() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonPassportNumberValid.validatePassPortValid(extent);
	}

	@Test(priority = 7,enabled=true)
	public void validatePersonTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonTest.validatePersonTest(extent);
	}

	@Test(priority = 8,enabled=true)
	public void validatePersonVeryHigh() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVeryHigh.validatePersonVeryHigh(extent);
	}

	@Test(priority = 9,enabled=true)
	public void validateOrganisation() throws URISyntaxException, IOException {
		ScreenAndVerifyPartyOrganisation.validateOrganisation(extent);
	}
	
	

	@Test(priority = 10,enabled=true)
	public void ScreenAndVerifyPartyPerson() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		ScreenAndVerifyPartyPerson.validatStatusCode(extent);
	}
	 
		@AfterTest
		public void EndTests() {
			extent.flush();

		}
	
	
}
