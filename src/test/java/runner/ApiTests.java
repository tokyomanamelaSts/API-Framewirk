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

	@Test(priority = 9,enabled=true)
	public void f9() throws URISyntaxException, IOException {
		ScreenAndVerifyPartyOrganisation.validateOrganisation(extent);
	}
	
	

	@Test(priority = 10,enabled=true)
	public void f10() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		ScreenAndVerifyPartyPerson.validatStatusCode(extent);
	}
	
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
    
    @Test(priority =24,enabled=true)
    public void PolicybyPolicyReference() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.PolicybyPolicyReference.policybyPolicyReference(extent);
	     
	}
    
    @Test(priority =25,enabled=true)
    public void PolicyListbyPolicyNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.PolicyListbyPolicyNumber.policyListbyPolicyNumber(extent);
	     
	}  
    
    
    @Test(priority =26,enabled=true)
    public void PolicybyIdentityNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.PolicybyIdentityNumber.policybyIdentityNumber(extent);
	     
	}      
	
    
    @Test(priority =27,enabled=true)
    public void DocumentsbyPolicyReference() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.DocumentsbyPolicyReference.documentsbyPolicyReference(extent);
	     
	}     
    
    
    @Test(priority =28,enabled=true)
    public void UpdateBankAccountAndDebitDay() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.UpdateBankAccountAndDebitDay.updateBankAccountAndDebitDay(extent);
	     
	}     
    
    
    @Test(priority =29,enabled=true)
    public void TESTPolicyHolderUpdate() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.TESTPolicyHolderUpdate.tESTPolicyHolderUpdate(extent);
	     
	}       
    
    
 
    
    
    @Test(priority =31,enabled=true)
    public void NIFPolicyHolderUpdate() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.NIFPolicyHolderUpdate.nIFPolicyHolderUpdate(extent);   
	}     
    
    
    
    @Test(priority =31,enabled=true)
    public void UpdatePolicyHolder() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.UpdatePolicyHolder.updatePolicyHolder(extent); 
	}  
    
    
    @Test(priority =30,enabled=true)
    public void ChangeBeneficiaries() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.ChangeBeneficiaries.changeBeneficiaries(extent);
	     
	}   
    
    
    @Test(priority =30,enabled=true)
    public void UploadDocument() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.UploadDocument.uploadDocument(extent);
	     
	} 
    
    
	@AfterTest
	public void EndTests() {
		extent.flush();

	}

}
