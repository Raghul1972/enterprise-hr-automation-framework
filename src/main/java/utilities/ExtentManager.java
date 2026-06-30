package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("./reports/AutomationReport.html");

            reporter.config().setReportName(
                    "Enterprise HR Automation Report");

            reporter.config().setDocumentTitle(
                    "Automation Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(reporter);

        }

        return extent;
    }

}