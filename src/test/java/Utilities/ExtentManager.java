package Utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	

	
	public ExtentReports extentTest(String reportname, String pageTile, String TesterName) throws IOException {
		ExtentReports extent=new ExtentReports();
	
		ExtentSparkReporter spark=new ExtentSparkReporter(reportname);
		
		
		
		final File CONF = new File("Configs/extent-config.xml");
	
		spark.loadXMLConfig(CONF);
		spark.config().setDocumentTitle(pageTile);	
		//spark.config().setReportName(TesterName);
		extent.attachReporter(spark);
		
		return extent;
		
		
	}
	
}
