package runner;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;

import Utilities.ExtentManager;

public class bankServiceRunner {

	ExtentReports extent=new ExtentManager().BankService();

    @Test(priority =34,enabled=true)
    public void CreateAuthenticatedCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.CreateAuthenticatedCollection.createAuthenticatedCollection(extent);
	     
	} 
    
    @Test(priority =35,enabled=true)
    public void QueryAuthenticatedCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryAuthenticatedCollection.queryAuthenticatedCollection(extent);
	     
	}   
    
    
    @Test(priority =36,enabled=true)
    public void QueryBank() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryBank.queryBank(extent);
	     
	} 
    
    
    @Test(priority =37,enabled=true)
    public void QueryBankByName() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryBankByName.queryBankByName(extent);
	     
	} 
    

    @Test(priority =37,enabled=true)
    public void QueryBranchByBankCode() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryBranchByBankCode.queryBranchByBankCode(extent);
	     
	} 
    
    @Test(priority =37,enabled=true)
    public void QueryBranchByName() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
    	com.exergyRestApi.BankService.QueryBranchByName.queryBranchByName(extent);
	     
	}
    
    @Test(priority =35,enabled=true)
    public void CancelAuthenticatedCollection() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
 		
		com.exergyRestApi.BankService.CancelAuthenticatedCollection.cancelAuthenticatedCollection(extent);
	     
	} 
    
    
	@AfterTest
	public void EndTests() {
		extent.flush();

	}
}
