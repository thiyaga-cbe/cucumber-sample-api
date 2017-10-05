package runnerClass;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


import org.junit.Test;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource", glue="plc_api_test", plugin = "html:target/cucumberReport") 

public class TestRunner {

}
