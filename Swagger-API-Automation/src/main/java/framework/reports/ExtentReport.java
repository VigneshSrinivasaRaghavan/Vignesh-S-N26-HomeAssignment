package framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import framework.constants.FrameworkConstants;
import framework.enums.CategoryTypes;

import java.awt.*;
import java.io.File;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent;

    public static void initReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = null;
        try {
            spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Test Report");
    }

    public static void flushReports() {
        extent.flush();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testname){
        ExtentTest test = extent.createTest(testname);
        ExtentManager.setExtentTest(test);
    }

    public static void addCategories(CategoryTypes[] categories){
        for(CategoryTypes category:categories){
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }
}
