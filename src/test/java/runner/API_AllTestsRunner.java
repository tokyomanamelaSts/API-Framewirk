package runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.PartyVerification.Soap.Request.PersonHighRisk;
import com.PartyVerification.Soap.Request.PersonPassportNumber;
import com.PartyVerification.Soap.Request.PersonPassportNumberValid;
import com.PartyVerification.Soap.Request.PersonTest;
import com.PartyVerification.Soap.Request.PersonVeryHigh;
import com.PartyVerification.Soap.Request.ScreenAndVerifyPartyOrganisation;
import com.PartyVerification.Soap.Request.ScreenAndVerifyPartyPerson;
import com.aventstack.extentreports.ExtentReports;
import com.exergyRestApi.Application.CreateAplication;
import com.exergyRestApi.Application.CreateApplicationBeneficiaries;
import com.exergyRestApi.Application.CreateApplicationBenefits;
import com.exergyRestApi.Application.CreateApplicationStatus;
import com.exergyRestApi.Application.GetApplication;
import com.exergyRestApi.Application.QualificationProduct1960;
import com.exergyRestApi.Collection.TC01PolicyByReferenceNumber;
import com.exergyRestApi.Collection.TC02CreateCollectionPost;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class API_AllTestsRunner {


	String ApptimeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String Appreportname = "Hollard Application API "+ApptimeStamp+".html";
	String ApppageTile = "Hollard Application API";
	String AppTesterName = System.getProperty("user.name");
	ExtentReports Appextent=new ExtentManager().extentTest(Appreportname, ApppageTile, AppTesterName);

	@Test(priority = 1,enabled=true)
	public void CreateApplication() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateAplication.CreateApplication(Appextent);
		
		ApiHelper.softAssertion.assertAll();
	}
	@Test(priority =2,enabled=true)
	public void CreateApplicationBenefits() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationBenefits.createApplicationBenefits(Appextent);
		ApiHelper.softAssertion.assertAll();
	}
	
	 @Test(priority =3,enabled=true)
	    public void CreateApplicationPolicyHolder() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
	 		
	    	com.exergyRestApi.Application.CreateApplicationPolicyHolder.createApplicationPolicyHolder(Appextent);
	    	ApiHelper.softAssertion.assertAll();
		     
		}
	
	 @Test(priority = 4,enabled=true)
	    public void CreateApplicationPremiumCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
	 		
			com.exergyRestApi.Application.CreateApplicationPremiumCollection.createApplicationPremiumCollection(Appextent);
			ApiHelper.softAssertion.assertAll();
		     
		}
	 
	@Test(priority = 5,enabled=true)
	public void CreateApplicationBeneficiaries() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationBeneficiaries.createApplicationBeneficiaries(Appextent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
	@Test(priority = 6,enabled=true)
	public void CreateApplicationStatus() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		CreateApplicationStatus.createApplicationStatus(Appextent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
	@Test(priority = 7,enabled=true)
    public void CreateApplicationAcceptance() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.Application.CreateApplicationAcceptance.createApplicationAcceptance(Appextent);
    	ApiHelper.softAssertion.assertAll();
	}
	
	
	
	@Test(priority = 8,enabled=true)
	public void GetApplication() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		GetApplication.getApplication(Appextent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
	@Test(priority = 9,enabled=true)
    public void QualificationProduct1960() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	QualificationProduct1960.qualificationProduct1960(Appextent);
	ApiHelper.softAssertion.assertAll();
		
	}
	
	
	@Test(priority = 10,enabled=true)
	public void QualificationProduct60200000() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		com.exergyRestApi.Application.QualificationProduct60200000.qualificationProduct60200000(Appextent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 11,enabled=true)
    public void QualificationProduct60100000() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
    	com.exergyRestApi.Application.QualificationProduct60100000.qualificationProduct60100000(Appextent);
    	ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 12,enabled=true)
	public void QualificationProduct60200001NegetiveTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Application.QualificationProduct60200001NegetiveTest.qualificationProduct60200001NegetiveTest(Appextent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
		
	
    @Test(priority = 13,enabled=true)
    public void QualificationProduct60100001NegetiveTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
    	com.exergyRestApi.Application.QualificationProduct60100001NegetiveTest.qualificationProduct60100001NegetiveTest(Appextent);
    	ApiHelper.softAssertion.assertAll();
    }
    
    @Test(priority = 14,enabled=true)
    public void Rates() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
	     
		com.exergyRestApi.Application.Rates.rates(Appextent);
		ApiHelper.softAssertion.assertAll();
	}
    
    
    // Collection APIs
    
    String ColTimeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String Colreportname = "Hollard Collection API "+ColTimeStamp+".html";
	String ColpageTile = "Hollard Collection API";
	String ColTesterName = System.getProperty("user.name");
	ExtentReports Colextent=new ExtentManager().extentTest(Colreportname, ColpageTile, ColTesterName);

	@Test(priority = 15,enabled=true)
	public void TC01PolicyByReferenceNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC01PolicyByReferenceNumber.test0001(Colextent);
		ApiHelper.softAssertion.assertAll();
		
	}    
	
	@Test(priority = 16,enabled=true)
	public void validateCreateCollections() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC02CreateCollectionPost.validateCreateCollections(Colextent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@Test(priority = 17,enabled=true)
	public void TC03ConfirmCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Collection.TC03ConfirmCollection.tc0003(Colextent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@Test(priority = 18,enabled=true)
	public void TC04CancelCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		com.exergyRestApi.Collection.TC04CancelCollection.tc0004(Colextent);
		ApiHelper.softAssertion.assertAll();
		
	}
    
   
    
	
	//Party Verification (Soap)
    
	
	
	String PartytimeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String Partyreportname = "Hollard PartyVerification API(SOAP) "+PartytimeStamp+".html";
	String PartypageTile = "Hollard PartyVerification API"; 
	String PartyTesterName = System.getProperty("user.name");
	ExtentReports Partyextent=new ExtentManager().extentTest(Partyreportname, Partyreportname, PartyTesterName);
	
	
	@Test(priority = 10,enabled=true)
	public void validatePersonHighRisk() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
	PersonHighRisk.validatePersonHighRisk(Partyextent);
	ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 20,enabled=true)
	public void validatePersonPassPortNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		PersonPassportNumber.validatePersonPassPortNumber(Partyextent);
		ApiHelper.softAssertion.assertAll();
		
	}

	@Test(priority = 21,enabled=true)
	public void validatePassPortValid() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonPassportNumberValid.validatePassPortValid(Partyextent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 22,enabled=true)
	public void validatePersonTest() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonTest.validatePersonTest(Partyextent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 23,enabled=true)
	public void validatePersonVeryHigh() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		PersonVeryHigh.validatePersonVeryHigh(Partyextent);
		ApiHelper.softAssertion.assertAll();
	}

	@Test(priority = 24,enabled=true)
	public void validateOrganisation() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		ScreenAndVerifyPartyOrganisation.validateOrganisation(Partyextent);
		ApiHelper.softAssertion.assertAll();
	}
	
	

	@Test(priority = 25,enabled=true)
	public void ScreenAndVerifyPartyPerson() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		ScreenAndVerifyPartyPerson.validatStatusCode(Partyextent);
		ApiHelper.softAssertion.assertAll();
	}
      
    //PolicyAPIs
	
	
	String PoltimeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String Polreportname = "Hollard Policy "+PoltimeStamp+".html";
	String PolpageTile = "Hollard Policy API";
	String PolTesterName = System.getProperty("user.name");
	ExtentReports Polextent=new ExtentManager().extentTest(Polreportname, Polreportname, PolTesterName);
	

    @Test(priority =26,enabled=true)
    public void PolicybyPolicyReference() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.PolicybyPolicyReference.policybyPolicyReference(Polextent);
		ApiHelper.softAssertion.assertAll();
	     
	}
    
    @Test(priority =27,enabled=true)
    public void PolicyListbyPolicyNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.PolicyListbyPolicyNumber.policyListbyPolicyNumber(Polextent);
    	ApiHelper.softAssertion.assertAll();
	     
	}  
    
    
    @Test(priority =28,enabled=true)
    public void PolicybyIdentityNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.PolicybyIdentityNumber.policybyIdentityNumber(Polextent);
    	ApiHelper.softAssertion.assertAll();
	     
	}      
	
    
    @Test(priority =29,enabled=true)
    public void DocumentsbyPolicyReference() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.DocumentsbyPolicyReference.documentsbyPolicyReference(Polextent);
    	ApiHelper.softAssertion.assertAll();
	     
	}     
    
    
    @Test(priority =30,enabled=true)
    public void UpdateBankAccountAndDebitDay() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.UpdateBankAccountAndDebitDay.updateBankAccountAndDebitDay(Polextent);
    	ApiHelper.softAssertion.assertAll();
	     
	}     
    
    
    @Test(priority =31,enabled=true)
    public void TESTPolicyHolderUpdate() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.TESTPolicyHolderUpdate.tESTPolicyHolderUpdate(Polextent);
    	ApiHelper.softAssertion.assertAll();
	}       
    
    
    
    @Test(priority =32,enabled=true)
    public void UpdatePolicyHolder() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.UpdatePolicyHolder.updatePolicyHolder(Polextent); 
    	ApiHelper.softAssertion.assertAll();
	}  
    
    @Test(priority =33,enabled=true)
    public void ChangeBeneficiaries() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.ChangeBeneficiaries.changeBeneficiaries(Polextent);
    	ApiHelper.softAssertion.assertAll();
	     
	}   
    
    
    @Test(priority =34,enabled=true)
    public void UploadDocument() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.UploadDocument.uploadDocument(Polextent);
		ApiHelper.softAssertion.assertAll();
	     
	}
	
	
	
	@AfterTest
	public void EndTests() {
		
		
		Appextent.flush();
		Colextent.flush();
		Partyextent.flush();
		Polextent.flush();
		
		

	}
	
	
	
}
