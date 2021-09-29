package runner;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.exergyRestApi.TC01PolicyByReferenceNumber;
import com.exergyRestApi.TC02CreateCollectionPost;
import com.exergyRestApi.TC03ConfirmCollection;
import com.exergyRestApi.TC04CancelCollection;
import com.exergySoapRequest.PersonHighRisk;
import com.exergySoapRequest.PersonPassportNumber;
import com.exergySoapRequest.PersonPassportNumberValid;
import com.exergySoapRequest.PersonTest;
import com.exergySoapRequest.PersonVeryHigh;
import com.exergySoapRequest.ScreenAndVerifyPartyOrganisation;
import com.exergySoapRequest.ScreenAndVerifyPartyPerson;

import Utilities.ExtentManager;

public class ApiTests {

	ExtentReports extent=new ExtentManager().extentTest();

	@Test(priority = 0,enabled=false)
	public void f0() throws URISyntaxException {
		TC01PolicyByReferenceNumber.test0001(extent);
	}
	@Test(priority = 1,enabled=false)
	public void f1() throws URISyntaxException {
		TC02CreateCollectionPost.validateCreateCollections(extent);
	}
	@Test(priority = 2,enabled=false)
	public void f2() throws URISyntaxException {
		TC03ConfirmCollection.tc0003(extent);
	}
	@Test(priority = 3,enabled=false)
	public void f3() throws URISyntaxException {
		TC04CancelCollection.tc0004(extent);
	}
	@Test(priority = 4,enabled=true)
	public void f4() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonHighRisk.validatePersonHighRisk(extent);
	}

	@Test(priority = 5,enabled=true)
	public void f5() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		PersonPassportNumber.validatePersonPassPortNumber(extent);
		
	}

	@Test(priority = 6,enabled=true)
	public void f6() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonPassportNumberValid.validatePassPortValid(extent);
	}

	@Test(priority = 7,enabled=true)
	public void f7() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonTest.validatePersonTest(extent);
	}

	@Test(priority = 8,enabled=true)
	public void f8() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVeryHigh.validatePersonVeryHigh(extent);
	}

	@Test(priority = 9,enabled=false)
	public void f9() throws URISyntaxException, IOException {
		ScreenAndVerifyPartyOrganisation.validateOrganisation(extent);
	}

	@Test(priority = 10,enabled=true)
	public void f10() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		ScreenAndVerifyPartyPerson.validatStatusCode(extent);
	}

	@AfterTest
	public void EndTests() {
		extent.flush();

	}

}
