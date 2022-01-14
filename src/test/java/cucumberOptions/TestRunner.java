package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(  
	    features = "src/test/resources/features",
	    glue="step_definitions")
public class TestRunner extends AbstractTestNGCucumberTests  {


}
