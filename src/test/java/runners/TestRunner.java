package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {
    		"pretty", 
    		"html:reports/HtmlReport.html",
    		"json:reports/cucumber.json",
    		"rerun:target/failed_scenarios.txt",
    		"summary"

    },
    monochrome = true,
    stepNotifications = true
    
)
public class TestRunner {
	
}
