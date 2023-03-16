package runner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.PetStore.TestCases.AddNewPetTestCases;
import com.PetStore.TestCases.CalcAddTestCases;
import com.aventstack.extentreports.ExtentReports;
import com.codoid.products.exception.FilloException;

import Utilities.ApiHelper;
import Utilities.ExtentManager;

public class Runner {

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	String reportname = "ExtentReports/Pet API "+timeStamp+".html";
	String pageTile = "Demo API";
	String TesterName = System.getProperty("user.name");

	ExtentReports extent;
	
	ExtentReports extentCalculator;

	public Runner() throws IOException {
		extent=new ExtentManager().extentTest(reportname, pageTile, TesterName);
		extentCalculator = new ExtentManager().extentTest("ExtentReports/SoapCalculator"+timeStamp+".html", "SoapCalculator", TesterName);
	}

	@Test(priority = 1,enabled=true)
	public void AddPet() throws URISyntaxException, IOException, SAXException, ParserConfigurationException, FilloException {

		AddNewPetTestCases.addPetTestcase(extent, "PetStore");
		
	}  
	@Test(priority = 2,enabled=true)

	public void SopaCalculator() throws URISyntaxException, IOException, SAXException, ParserConfigurationException, FilloException {
		
		
		CalcAddTestCases.SoapCalcTestCase(extentCalculator);
	
		
	}  
	@AfterTest
	public void EndTests() {

		ApiHelper.assertAll();
		extentCalculator.flush();
		extent.flush();

	}

}
