package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	

	
	public ExtentReports extentTest() {
		ExtentReports extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
		spark.config().setTheme(Theme.STANDARD);	
		spark.config().setDocumentTitle("Api");	
		spark.config().setReportName("Automation");
		extent.attachReporter(spark);
		
		return extent;
		
		
	}
	
	public ExtentReports BankService() {
		ExtentReports extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("Bank Service Report.html");
		spark.config().setTheme(Theme.STANDARD);	
		spark.config().setDocumentTitle("BankService Report");	
		spark.config().setReportName(System.getProperty("user.name"));
		extent.attachReporter(spark);
		
		return extent;
		
		
	}

}
