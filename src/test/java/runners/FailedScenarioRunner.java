package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "@target/failed_scenarios.txt",
    glue = "stepdefinitions",
    plugin = {
        "pretty",
        "html:target/rerun-reports.html"
    },
	dryRun = false,
    monochrome = true,
    stepNotifications = true
)

public class FailedScenarioRunner {

}
