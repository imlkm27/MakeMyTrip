package makeMyTrip_option;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//@RunWith(Cucumber.class)
@Test
@CucumberOptions(
		//features = "src/test/java/makeMyTrip_feature/Final.feature",
		features = "src/test/java/makeMyTrip_feature/Buses.feature",
		glue = "makeMyTrip_stepDefinition"
		//dryRun = true
		//monochrome = true
		//format =pretty
		//tags = "@Test1"
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
}
