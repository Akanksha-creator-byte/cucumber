package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    tags = "@sanity",
    plugin = {
    		"pretty", 
    		"html:reports/HtmlReport.html",
    		"json:reports/cucumber.json",
    		"rerun:target/failed_scenarios.txt",
    		"summary",
    },
    //dryRun =true,
    		dryRun = false,
    monochrome = true,
    stepNotifications = true
    
)
public class SanityTestRunner {

}
