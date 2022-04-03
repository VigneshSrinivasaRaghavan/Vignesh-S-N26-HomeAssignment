package framework.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentManager {

    private ExtentManager(){
    }

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest(){
        return extentTest.get();
    }

    static void setExtentTest(ExtentTest testReference){
        if(Objects.nonNull(testReference)) {
            extentTest.set(testReference);
        }
    }

    static void unload(){
        extentTest.remove();
    }
}
