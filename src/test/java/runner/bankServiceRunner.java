package runner;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class bankServiceRunner {

	String reportname = "Hollard Bank Service.html";
	String pageTile = "Hollard Bank Service";
	String TesterName = System.getProperty("user.name");
	
	ExtentReports extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);

    @Test(priority =1,enabled=true)
    public void CreateAuthenticatedCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.CreateAuthenticatedCollection.createAuthenticatedCollection(extent);
	     
	} 
    
    @Test(priority =2,enabled=true)
    public void QueryAuthenticatedCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryAuthenticatedCollection.queryAuthenticatedCollection(extent);
	     
	}   
    
    
    @Test(priority =3,enabled=true)
    public void QueryBank() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryBank.queryBank(extent);
	     
	} 
    
    
    @Test(priority =4,enabled=true)
    public void QueryBankByName() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryBankByName.queryBankByName(extent);
	     
	} 
    

    @Test(priority =5,enabled=true)
    public void QueryBranchByBankCode() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryBranchByBankCode.queryBranchByBankCode(extent);
	     
	} 
    
    @Test(priority =6,enabled=true)
    public void QueryBranchByName() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryBranchByName.queryBranchByName(extent);
	     
	}
     
    
    
    @Test(priority =7,enabled=true)
    public void RetrieveAuthenticatedCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.RetrieveAuthenticatedCollection.retrieveAuthenticatedCollection(extent); 
	} 
    
    @Test(priority =8,enabled=true)
    public void RetrieveBank() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.RetrieveBank.retrieveBank(extent);
	} 
    
    @Test(priority =9,enabled=true)
    public void RetrieveBranch() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.RetrieveBranch.retrieveBranch(extent);
	}      
    
    
    @Test(priority =10,enabled=true)
    public void RetrieveVerification() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.RetrieveVerification.retrieveVerification(extent);
	} 
    
    
    @Test(priority =11,enabled=true)
    public void UpdateAuthenticatedCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.UpdateAuthenticatedCollection.updateAuthenticatedCollection(extent);
    	
	}   
    
    
    @Test(priority =12,enabled=true)
    public void ValidateBankAccount() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.ValidateBankAccount.validateBankAccount(extent);
    	
	}    
    
    @Test(priority =13,enabled=true)
    public void ValidateCreditCard() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.ValidateCreditCard.validateCreditCard(extent);
    	
	}  
    
    
    @Test(priority =14,enabled=true)
    public void VerifyBankAccount() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	
    	com.exergyRestApi.BankService.VerifyBankAccount.verifyBankAccount(extent);
    	
	}  
    
    @Test(priority =15,enabled=true)
    public void CancelAuthenticatedCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.BankService.CancelAuthenticatedCollection.cancelAuthenticatedCollection(extent);
	     
	} 
    
	@AfterTest
	public void EndTests() {
		ApiHelper.softAssertion.assertAll();
		extent.flush();

	}
}
