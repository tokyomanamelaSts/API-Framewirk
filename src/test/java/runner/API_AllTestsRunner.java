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
import com.exergyRestApi.PartyVerification.TC_001;
import com.exergyRestApi.PartyVerification.TC_002;
import com.exergyRestApi.PartyVerification.TC_003;
import com.exergyRestApi.PartyVerification.TC_004;
import com.exergyRestApi.PartyVerification.TC_005;
import com.exergyRestApi.PartyVerification.TC_006;
import com.exergyRestApi.PartyVerification.TC_007;
import com.exergyRestApi.PartyVerification.TC_008;
import com.exergyRestApi.PartyVerification.TC_009;
import com.exergyRestApi.PartyVerification.TC_010;
import com.exergyRestApi.PartyVerification.TC_011;
import com.exergyRestApi.PartyVerification.TC_012;
import com.exergyRestApi.PartyVerification.TC_013;
import com.exergyRestApi.PartyVerification.TC_014;
import com.exergyRestApi.PartyVerification.TC_015;
import com.exergyRestApi.PartyVerification.TC_016;
import com.exergyRestApi.PartyVerification.TC_017;
import com.exergyRestApi.PartyVerification.TC_018;
import com.exergyRestApi.PartyVerification.TC_019;
import com.exergyRestApi.PartyVerification.TC_020;
import com.exergyRestApi.PartyVerification.TC_021;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class API_AllTestsRunner {


	String ApptimeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String Appreportname = "Hollard Application API "+ApptimeStamp+".html";
	String ApppageTile = "Hollard Application API";
	String AppTesterName = System.getProperty("user.name");
	ExtentReports Appextent;

	public API_AllTestsRunner() throws IOException {
		
		 Appextent=new ExtentManager().extentTest(Appreportname, ApppageTile, AppTesterName);
	}
	
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
	
	
    
    //Party verification REST
    
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Hollard Party Verification API(REST)"+timeStamp+".html";
	String pageTile = "Hollard Party Verification API(REST)";
	String TesterName = System.getProperty("user.name");
	
	ExtentReports extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);
	
	
	
		
   

	@Test(priority = 35,enabled=true)
	public void TC_001_PersonIdentification_Basic() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		TC_001.TC_001_PersonIdentification_Basic(extent);
		ApiHelper.softAssertion.assertAll();
		
	}   
	@Test(priority = 36,enabled=true)
	public void TC_002_PersonIdentification_Basic_Invalid_ID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_002.PersonIdentification_Basic_Invalid_ID(extent);
		ApiHelper.softAssertion.assertAll();
		
	}  
	
	@Test(priority = 37,enabled=true)
	public void TC_003_PersonIdentification_Enhanced() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_003.PersonIdentification_Enhanced(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 38,enabled=true)
	public void TC_004_PersonIdentification_Enhanced_Invalid_ID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_004.PersonIdentification_Enhanced_Invalid_ID(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 39,enabled=true)
	public void TC_005_PersonIdentificationComprehensiveWithMortalityInformation() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_005.PersonIdentificationComprehensiveWithMortalityInformation(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 40,enabled=true)
	public void TC_006_PersonIdentificationComprehensiveWithMortalityInformation_Invalid_ID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_006.PersonIdentificationComprehensiveWithMortalityInformation_Invalid_ID(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 41,enabled=true)
	public void TC_007_PersonVerification_Risk_Rating_Low_IdentityNumber() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		TC_007.TC_007_PersonVerification_RiskRating_Low_ID(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 42,enabled=true)
	public void TC_008_PersonVerification_Risk_Rating_Low_IdentityNumber_Invalid_ID() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		TC_008.TC_008_PersonVerification_RiskRating_Low_ID_Invalid_ID(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	@Test(priority = 43,enabled=true)
	public void TC_009_PersonVerification_Risk_Rating_High_IdentityNumber() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		TC_009.TC_009_PersonVerification_RiskRating_High_ID(extent);
		ApiHelper.softAssertion.assertAll();
	}
	
	
	@Test(priority = 44,enabled=true)

	public void TC_010_PersonVerificationRiskRatinghigh_Identitynumber_invalid_ID() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_010.PersonVerification_RiskRating_HighIdentityNumber_Invalid_ID(extent);

		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 45,enabled=true)

	public void TC_011_PersonVerification_RiskRating_Low_Passport() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_011.PersonVerification_RiskRating_Low_Passport(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 46,enabled=true)

	public void TC_012_PersonVerification_RiskRating_Low_Passport_Invalid_Passport() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_012.PersonVerification_RiskRating_Low_Passport_Invalid_Passport(extent);

		ApiHelper.softAssertion.assertAll();
		
	} 

	@Test(priority = 47,enabled=true)
    public void TC_013_PersonVerification_RiskRating_High_Passport() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_013.PersonVerification_RiskRating_High_Passport(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	
	@Test(priority = 48,enabled=true)
    public void TC_014_PersonVerification_RiskRating_High_Passport_Invalid_passport() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_014.PersonVerification_RiskRating_High_Passport(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	

	
	@Test(priority = 49,enabled=true)
	public void TC_015_PersonIdentification_Basic_Invalid_ID_Invalid_Format() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_015.PersonIdentification_Basic_Invalid_ID_Format(extent);
		ApiHelper.softAssertion.assertAll();
		
	}  
	
	
	@Test(priority = 50,enabled=true)
	public void TC_016_PersonIdentification_Enhanced_Invalid_ID_Invalid_Format() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_016.PersonIdentification_Enhanced_Invalid_ID_Format(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 51,enabled=true)
	public void TC_017_PersonIdentificationComprehensiveWithMortalityInformation_Invalid_ID_Invalid_Format() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_017.PersonIdentificationComprehensiveWithMortalityInformation_Invalid_ID_Format(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
  
  @Test(priority = 52,enabled=true)
    public void TC_018_PersonVerification_RiskRating_Low_ID_Invalid_Format() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_018.TC_018_PersonVerification_RiskRating_Low_Invalid_ID_Format(extent);
		ApiHelper.softAssertion.assertAll();
		
	} 
	
	@Test(priority = 53,enabled=true)
    public void TC_019_PersonVerification_RiskRating_HighIdentityNumber_Invalid_Format() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_019.TC_019_PersonVerificationRiskRatinghigh_invalid_ID_Format(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	@Test(priority = 54,enabled=true)
    public void TC_020_PersonVerification_RiskRating_Low_Passport_Invalid_Format() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_020.TC_020_PersonVerification_RiskRating_Low_Invalid_Passport_Format(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
	
	@Test(priority = 55,enabled=true)
    public void TC_021_PersonVerification_RiskRating_High_Passport_Invalid_Format() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
		
		TC_021.TC_021_PersonVerification_RiskRating_High_Invalid_passport_Format(extent);
		ApiHelper.softAssertion.assertAll();
		
	}
	
    
	
	@AfterTest
	public void EndTests() {
		
		
		Appextent.flush();
		Colextent.flush();
		Partyextent.flush();
		Polextent.flush();
		extent.flush();
		

	}
	
	
	
}
