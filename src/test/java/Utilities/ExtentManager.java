package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	

	
	public ExtentReports extentTest(String reportname, String pageTile, String TesterName) {
		ExtentReports extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(reportname);
		spark.config().setTheme(Theme.STANDARD);	
		spark.config().setDocumentTitle(pageTile);	
		spark.config().setReportName(TesterName);
		extent.attachReporter(spark);
		
		return extent;
		
		
	}
	
}
