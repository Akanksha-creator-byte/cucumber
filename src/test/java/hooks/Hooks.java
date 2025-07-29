package hooks;

import base.BaseClass;
import io.cucumber.java.*;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.ScreenshotUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.IOException;

public class Hooks extends BaseClass {

    private static ExtentReports extent;

    @BeforeAll
    public static void startReport() {
        extent = ExtentManager.getInstance();
    }

	/*
	 * @Before public void setup(Scenario scenario) throws IOException {
	 * launchBrowser(); ExtentTest test = extent.createTest(scenario.getName());
	 * ExtentTestManager.setTest(test); }
	 */

    @Before
    public void setup(Scenario scenario) {
        System.out.println("📌 Scenario started: " + scenario.getName());
        try {
            launchBrowser();  // This is most likely failing silently
            goToLoginPage();
            System.out.println("✅ Browser launched successfully");
            ExtentTest test = ExtentManager.getInstance().createTest(scenario.getName());
            ExtentTestManager.setTest(test);
        } catch (Exception e) {
            System.err.println("❌ Browser setup failed: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Browser not launched, aborting scenario: " + scenario.getName(), e);
        }
    }

    @After
    public void tearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, scenario.getName());
            ExtentTestManager.getTest().fail("Scenario Failed Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            ExtentTestManager.getTest().pass("Scenario Passed");
        }
        tearDown();
    }

    @AfterAll
    public static void endReport() {
        extent.flush();
    }
}
