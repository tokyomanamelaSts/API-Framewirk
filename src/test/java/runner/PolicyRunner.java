package runner;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.exergyRestApi.TC01PolicyByReferenceNumber;
import com.exergyRestApi.TC02CreateCollectionPost;
import com.exergyRestApi.TC03ConfirmCollection;
import com.exergyRestApi.TC04CancelCollection;

import Utilities.ExtentManager;

public class PolicyRunner {
	
	String reportname = "Policy API.html";
	String pageTile = "HPolicy API";
	String TesterName = System.getProperty("user.name");
	ExtentReports extent=new ExtentManager().extentTest(reportname, reportname, TesterName);
	
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
	@Test(priority = 3,enabled=true)
	public void f3() throws URISyntaxException {
		TC04CancelCollection.tc0004(extent);
	}

    @Test(priority =24,enabled=true)
    public void PolicybyPolicyReference() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.PolicybyPolicyReference.policybyPolicyReference(extent);
	     
	}
    
    @Test(priority =25,enabled=false)
    public void PolicyListbyPolicyNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.PolicyListbyPolicyNumber.policyListbyPolicyNumber(extent);
	     
	}  
    
    
    @Test(priority =26,enabled=false)
    public void PolicybyIdentityNumber() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.PolicybyIdentityNumber.policybyIdentityNumber(extent);
	     
	}      
	
    
    @Test(priority =27,enabled=false)
    public void DocumentsbyPolicyReference() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.DocumentsbyPolicyReference.documentsbyPolicyReference(extent);
	     
	}     
    
    
    @Test(priority =28,enabled=false)
    public void UpdateBankAccountAndDebitDay() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.UpdateBankAccountAndDebitDay.updateBankAccountAndDebitDay(extent);
	     
	}     
    
    
    @Test(priority =29,enabled=false)
    public void TESTPolicyHolderUpdate() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.TESTPolicyHolderUpdate.tESTPolicyHolderUpdate(extent);
	     
	}       
    
    
 
    
    
    @Test(priority =31,enabled=false)
    public void NIFPolicyHolderUpdate() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.NIFPolicyHolderUpdate.nIFPolicyHolderUpdate(extent);   
	}     
    
    
    
    @Test(priority =31,enabled=false)
    public void UpdatePolicyHolder() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.UpdatePolicyHolder.updatePolicyHolder(extent); 
	}  
    
    
    @Test(priority =30,enabled=false)
    public void ChangeBeneficiaries() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.policy.ChangeBeneficiaries.changeBeneficiaries(extent);
	     
	}   
    
    
    @Test(priority =30,enabled=false)
    public void UploadDocument() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.policy.UploadDocument.uploadDocument(extent);
	     
	} 
	
	
}
