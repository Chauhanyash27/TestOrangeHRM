package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;

import static Utility.Base.page;

public class ExtentReportListener implements ITestListener {

    public ExtentReports extentReports;
    public ExtentSparkReporter sparkReporter;
    public ExtentTest extentTest;

    public void onStart(ITestContext context) {
        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("./Reports/TestReport.html");
        sparkReporter.config().setDocumentTitle("Testing Report");
        sparkReporter.config().setReportName("NopCommerce Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(sparkReporter);
    }

    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, "Test Case PASSED");
    }

    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, "Test Case FAILED");
        String screenshotCode = captureScreenshot();
        extentTest.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotCode).build());
    }

    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.SKIP, "Test Case Skipped");
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public String captureScreenshot() {
        String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));
        return path;
    }
}