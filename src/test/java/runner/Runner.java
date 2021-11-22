package runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.PetStore.Repo.AddNewPetTestCases;
import com.aventstack.extentreports.ExtentReports;
import com.codoid.products.exception.FilloException;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class Runner {
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "Demo API "+timeStamp+".html";
	String pageTile = "Demo API";
	String TesterName = System.getProperty("user.name");
	
	ExtentReports extent;
	
public Runner() throws IOException {
	 extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);
	}
	
	@Test(priority = 1,enabled=true)
	public void AddPet() throws URISyntaxException, IOException, SAXException, ParserConfigurationException, FilloException {
		
		AddNewPetTestCases.ProductRules(extent, "PetStore");
		ApiHelper.assertAll();
}
	
    
    
      
    
	@AfterTest
	public void EndTests() {
		
		
		extent.flush();

	}

}
