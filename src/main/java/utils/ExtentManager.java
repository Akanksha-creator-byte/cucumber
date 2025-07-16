package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("./reports/ExtentReport.html");

            // ✅ This is where you add report customization:
            spark.config().setReportName("SauceDemo Automation Report");
            spark.config().setDocumentTitle("SauceDemo Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Akanksha");
            extent.setSystemInfo("Application", "SauceDemo");
        }
        return extent;
    }
}
