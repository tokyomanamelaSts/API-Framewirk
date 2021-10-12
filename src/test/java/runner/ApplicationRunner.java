package runner;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.exergyRestApi.Application.CreateAplication;
import com.exergyRestApi.Application.CreateApplicationBeneficiaries;
import com.exergyRestApi.Application.CreateApplicationBenefits;
import com.exergyRestApi.Application.CreateApplicationStatus;
import com.exergyRestApi.Application.GetApplication;
import com.exergyRestApi.Application.QualificationProduct1960;
import com.exergyRestApi.Application.TC01PolicyByReferenceNumber;
import com.exergyRestApi.Application.TC02CreateCollectionPost;
import com.exergyRestApi.Application.TC03ConfirmCollection;
import com.exergyRestApi.Application.TC04CancelCollection;
import com.exergySoapRequest.PersonHighRisk;
import com.exergySoapRequest.PersonPassportNumber;
import com.exergySoapRequest.PersonPassportNumberValid;
import com.exergySoapRequest.PersonTest;
import com.exergySoapRequest.PersonVeryHigh;
import com.exergySoapRequest.ScreenAndVerifyPartyOrganisation;
import com.exergySoapRequest.ScreenAndVerifyPartyPerson;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class ApplicationRunner {
	
	String reportname = "Hollard Application API.html";
	String pageTile = "Application Report";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);

	@Test(priority = 11,enabled=true)
	public void CreateApplication() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateAplication.CreateApplication(extent);
		
		ApiHelper.softAssertion.assertAll();
	}
	@Test(priority =12,enabled=true)
	public void createApplicationBenefits() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationBenefits.createApplicationBenefits(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority =13,enabled=true)
	public void createApplicationBeneficiaries() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationBeneficiaries.createApplicationBeneficiaries(extent);
		ApiHelper.softAssertion.assertAll();
	}
	@Test(priority =14,enabled=true)
	public void createApplicationStatus() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationStatus.createApplicationStatus(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority =15,enabled=true)
	public void getApplication() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		GetApplication.getApplication(extent);
		ApiHelper.softAssertion.assertAll();
	}
	@Test(priority =16,enabled=true)
	public void QualificationProduct60200000() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		com.exergyRestApi.Application.QualificationProduct60200000.qualificationProduct60200000(extent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority =17,enabled=true)
	public void QualificationProduct60200001NegetiveTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Application.QualificationProduct60200001NegetiveTest.qualificationProduct60200001NegetiveTest(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority =18,enabled=true)
    public void QualificationProduct1960() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	QualificationProduct1960.qualificationProduct1960(extent);
	ApiHelper.softAssertion.assertAll();
		
	}
		
    @Test(priority =19,enabled=true)
    public void QualificationProduct60100000() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
    	com.exergyRestApi.Application.QualificationProduct60100000.qualificationProduct60100000(extent);
    	ApiHelper.softAssertion.assertAll();
	} 
    
	
    @Test(priority =20,enabled=true)
    public void QualificationProduct60100001NegetiveTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
    	com.exergyRestApi.Application.QualificationProduct60100001NegetiveTest.qualificationProduct60100001NegetiveTest(extent);
    	ApiHelper.softAssertion.assertAll();
    }
    
    @Test(priority =21,enabled=true)
    public void Rates() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
		com.exergyRestApi.Application.Rates.rates(extent);
		ApiHelper.softAssertion.assertAll();
	}
    
    @Test(priority =22,enabled=true)
    public void CreateApplicationPolicyHolder() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.Application.CreateApplicationPolicyHolder.createApplicationPolicyHolder(extent);
    	ApiHelper.softAssertion.assertAll();
	     
	}
    
    @Test(priority =23,enabled=true)
    public void CreateApplicationPremiumCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.Application.CreateApplicationPremiumCollection.createApplicationPremiumCollection(extent);
		ApiHelper.softAssertion.assertAll();
	     
	}
    @Test(priority =23,enabled=true)
    public void CreateApplicationAcceptance() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.Application.CreateApplicationAcceptance.createApplicationAcceptance(extent);
    	ApiHelper.softAssertion.assertAll();
	}  
    
	@AfterTest
	public void EndTests() {
		
		
		extent.flush();

	}

}
