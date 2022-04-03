package framework.listeners;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import framework.annotations.FrameworkAnnotation;
import org.apache.commons.codec.binary.StringUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import framework.reports.ExtentLogger;
import framework.reports.ExtentReport;

import java.util.Arrays;

public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    public void onTestSuccess(ITestResult result) {
        String logText = "<b>" + result.getMethod().getMethodName() + " is passed.</b>";
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        ExtentLogger.pass(markup_message);

    }

    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed");
        ExtentLogger.fail(result.getThrowable().toString());

        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        String message = "<details><summary><b><font color=red> Exception occurred, click to see details: "
                + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
                + "</details> \n";

        ExtentLogger.fail(message);

        String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>";
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.RED);
        ExtentLogger.fail(markup_message);
    }

    public void onTestSkipped(ITestResult result) {
        String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>";
        Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
        ExtentLogger.skip(markup_message);
    }

}
