package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/features"}, 
		glue= {"step"},
		monochrome=true,
		tags= {"@soap"},
				plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class SoapApiRunner extends AbstractTestNGCucumberTests{

}
