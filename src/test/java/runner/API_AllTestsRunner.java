package runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

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
import com.exergyRestApi.Collection.TC01PolicyByReferenceNumber;
import com.exergyRestApi.Collection.TC02CreateCollectionPost;
import com.exergySoapRequest.PersonHighRisk;
import com.exergySoapRequest.PersonPassportNumber;
import com.exergySoapRequest.PersonPassportNumberValid;
import com.exergySoapRequest.PersonTest;
import com.exergySoapRequest.PersonVeryHigh;
import com.exergySoapRequest.ScreenAndVerifyPartyOrganisation;
import com.exergySoapRequest.ScreenAndVerifyPartyPerson;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class API_AllTestsRunner {


	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Hollard Application API "+timeStamp+".html";
	String pageTile = "Hollard Application API";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);

	@Test(priority = 1,enabled=true)
	public void CreateApplication() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateAplication.CreateApplication(extent);
		
		ApiHelper.softAssertion.assertAll();
	}
	@Test(priority =2,enabled=true)
	public void CreateApplicationBenefits() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationBenefits.createApplicationBenefits(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	 @Test(priority =3,enabled=true)
	    public void CreateApplicationPolicyHolder() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
	 		
	    	com.exergyRestApi.Application.CreateApplicationPolicyHolder.createApplicationPolicyHolder(extent);
	    	ApiHelper.softAssertion.assertAll();
		     
		}
	
	 @Test(priority = 4,enabled=true)
	    public void CreateApplicationPremiumCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
	 		
			com.exergyRestApi.Application.CreateApplicationPremiumCollection.createApplicationPremiumCollection(extent);
			ApiHelper.softAssertion.assertAll();
		     
		}
	 
	@Test(priority = 4,enabled=true)
	public void CreateApplicationBeneficiaries() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationBeneficiaries.createApplicationBeneficiaries(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
	@Test(priority = 5,enabled=true)
	public void CreateApplicationStatus() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationStatus.createApplicationStatus(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
	@Test(priority = 6,enabled=true)
    public void CreateApplicationAcceptance() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.Application.CreateApplicationAcceptance.createApplicationAcceptance(extent);
    	ApiHelper.softAssertion.assertAll();
	}
	
	
	
	@Test(priority = 7,enabled=true)
	public void GetApplication() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		GetApplication.getApplication(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
	@Test(priority = 8,enabled=true)
    public void QualificationProduct1960() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	QualificationProduct1960.qualificationProduct1960(extent);
	ApiHelper.softAssertion.assertAll();
		
	}
	
	
	@Test(priority = 9,enabled=true)
	public void QualificationProduct60200000() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		com.exergyRestApi.Application.QualificationProduct60200000.qualificationProduct60200000(extent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 10,enabled=true)
    public void QualificationProduct60100000() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
    	com.exergyRestApi.Application.QualificationProduct60100000.qualificationProduct60100000(extent);
    	ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 11,enabled=true)
	public void QualificationProduct60200001NegetiveTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Application.QualificationProduct60200001NegetiveTest.qualificationProduct60200001NegetiveTest(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
		
	
    @Test(priority = 12,enabled=true)
    public void QualificationProduct60100001NegetiveTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
    	com.exergyRestApi.Application.QualificationProduct60100001NegetiveTest.qualificationProduct60100001NegetiveTest(extent);
    	ApiHelper.softAssertion.assertAll();
    }
    
    @Test(priority = 13,enabled=true)
    public void Rates() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
		com.exergyRestApi.Application.Rates.rates(extent);
		ApiHelper.softAssertion.assertAll();
	}
    
    
    // Collection APIs
    
    String ColTimeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String Colreportname = "Hollard Collection API "+ColTimeStamp+".html";
	String ColpageTile = "Hollard Collection API";

	ExtentReports Colextent=new ExtentManager().extentTest(Colreportname, ColpageTile, TesterName);

	@Test(priority = 1,enabled=true)
	public void TC01PolicyByReferenceNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC01PolicyByReferenceNumber.test0001(extent);
		ApiHelper.softAssertion.assertAll();
		
	}    
	
	@Test(priority = 2,enabled=true)
	public void validateCreateCollections() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC02CreateCollectionPost.validateCreateCollections(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@Test(priority = 3,enabled=true)
	public void TC03ConfirmCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Collection.TC03ConfirmCollection.tc0003(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@Test(priority = 4,enabled=true)
	public void TC04CancelCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Collection.TC04CancelCollection.tc0004(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
    
   
    
	
	//Party Verification Soap
    
	
	
	String PartytimeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String Partyreportname = "Hollard PartyVerification API(SOAP) "+timeStamp+".html";
	String PartypageTile = "Hollard PartyVerification API"; 
	String PartyTesterName = System.getProperty("user.name");
	ExtentReports Partyextent=new ExtentManager().extentTest(Partyreportname, Partyreportname, PartyTesterName);
	
	
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
      
    //PolicyAPIs
	
	
	String PoltimeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String Polreportname = "Hollard Policy "+timeStamp+".html";
	String PolpageTile = "Hollard Policy API";
	String PolTesterName = System.getProperty("user.name");
	ExtentReports Polextent=new ExtentManager().extentTest(Polreportname, Polreportname, PolTesterName);
	

    @Test(priority =1,enabled=true)
    public void PolicybyPolicyReference() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.PolicybyPolicyReference.policybyPolicyReference(extent);
		ApiHelper.softAssertion.assertAll();
	     
	}
    
    @Test(priority =2,enabled=true)
    public void PolicyListbyPolicyNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.PolicyListbyPolicyNumber.policyListbyPolicyNumber(extent);
    	ApiHelper.softAssertion.assertAll();
	     
	}  
    
    
    @Test(priority =3,enabled=true)
    public void PolicybyIdentityNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.PolicybyIdentityNumber.policybyIdentityNumber(extent);
    	ApiHelper.softAssertion.assertAll();
	     
	}      
	
    
    @Test(priority =4,enabled=true)
    public void DocumentsbyPolicyReference() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.DocumentsbyPolicyReference.documentsbyPolicyReference(extent);
    	ApiHelper.softAssertion.assertAll();
	     
	}     
    
    
    @Test(priority =5,enabled=true)
    public void UpdateBankAccountAndDebitDay() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.UpdateBankAccountAndDebitDay.updateBankAccountAndDebitDay(extent);
    	ApiHelper.softAssertion.assertAll();
	     
	}     
    
    
    @Test(priority =6,enabled=true)
    public void TESTPolicyHolderUpdate() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.TESTPolicyHolderUpdate.tESTPolicyHolderUpdate(extent);
    	ApiHelper.softAssertion.assertAll();
	}       
    
    
    
    @Test(priority =7,enabled=true)
    public void UpdatePolicyHolder() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.UpdatePolicyHolder.updatePolicyHolder(extent); 
    	ApiHelper.softAssertion.assertAll();
	}  
    
    @Test(priority =8,enabled=true)
    public void ChangeBeneficiaries() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.ChangeBeneficiaries.changeBeneficiaries(extent);
    	ApiHelper.softAssertion.assertAll();
	     
	}   
    
    
    @Test(priority =9,enabled=true)
    public void UploadDocument() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.UploadDocument.uploadDocument(extent);
		ApiHelper.softAssertion.assertAll();
	     
	}
	
	
	
	@AfterTest
	public void EndTests() {
		
		
		extent.flush();
		Colextent.flush();
		Partyextent.flush();
		Polextent.flush();
		
		//

	}
	
	
	
}
