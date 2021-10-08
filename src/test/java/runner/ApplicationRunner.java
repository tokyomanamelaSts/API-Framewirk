package runner;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.exergyRestApi.CreateAplication;
import com.exergyRestApi.CreateApplicationBeneficiaries;
import com.exergyRestApi.CreateApplicationBenefits;
import com.exergyRestApi.CreateApplicationStatus;
import com.exergyRestApi.GetApplication;
import com.exergyRestApi.QualificationProduct1960;
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

public class ApplicationRunner {
	
	String reportname = "Hollard Application API.html";
	String pageTile = "Application Report";
	String TesterName = System.getProperty("user.name");
	
			
	
	ExtentReports extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);

	
	@Test(priority = 11,enabled=true)
	public void CreateApplication() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateAplication.CreateApplication(extent);
	}
	@Test(priority =12,enabled=true)
	public void createApplicationBenefits() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationBenefits.createApplicationBenefits(extent);
	}
	
	@Test(priority =13,enabled=true)
	public void createApplicationBeneficiaries() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationBeneficiaries.createApplicationBeneficiaries(extent);
	}
	@Test(priority =14,enabled=true)
	public void createApplicationStatus() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationStatus.createApplicationStatus(extent);
	}
	
	@Test(priority =15,enabled=true)
	public void getApplication() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		GetApplication.getApplication(extent);
	}
	@Test(priority =16,enabled=true)
	public void QualificationProduct60200000() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		com.exergyRestApi.QualificationProduct60200000.qualificationProduct60200000(extent);
	}

	@Test(priority =17,enabled=true)
	public void QualificationProduct60200001NegetiveTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.QualificationProduct60200001NegetiveTest.qualificationProduct60200001NegetiveTest(extent);
		
	}
	
	@Test(priority =18,enabled=true)
    public void QualificationProduct1960() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	QualificationProduct1960.qualificationProduct1960(extent);
		
	}
		
    @Test(priority =19,enabled=true)
    public void QualificationProduct60100000() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
    	com.exergyRestApi.QualificationProduct60100000.qualificationProduct60100000(extent);
	} 
    
	
    @Test(priority =20,enabled=true)
    public void QualificationProduct60100001NegetiveTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
    	com.exergyRestApi.QualificationProduct60100001NegetiveTest.qualificationProduct60100001NegetiveTest(extent);
	}
    
    @Test(priority =21,enabled=true)
    public void Rates() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
		com.exergyRestApi.Rates.rates(extent);
	}
    
    @Test(priority =22,enabled=true)
    public void CreateApplicationPolicyHolder() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.CreateApplicationPolicyHolder.createApplicationPolicyHolder(extent);
	     
	}
    
    @Test(priority =23,enabled=true)
    public void CreateApplicationPremiumCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.CreateApplicationPremiumCollection.createApplicationPremiumCollection(extent);
	     
	}
    @Test(priority =23,enabled=true)
    public void CreateApplicationAcceptance() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.CreateApplicationAcceptance.createApplicationAcceptance(extent);
	     
	}  
    
	@AfterTest
	public void EndTests() {
		extent.flush();

	}

}
