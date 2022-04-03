package base;

import com.aventstack.extentreports.Status;
import constants.FrameworkConstants;
import driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentReport;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void waitForVisibility(MobileElement element){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitTime());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(MobileElement element,String elementName){
        waitForVisibility(element);
        element.click();
        ExtentReport.getTest().log(Status.INFO,elementName+" is clicked");
    }

    public void sendKeys(MobileElement element, String text,String elementName){
        waitForVisibility(element);
        element.sendKeys(text);
        ExtentReport.getTest().log(Status.INFO,elementName+" is entered with "+text);
    }

    public void navigateBack(){
        DriverManager.getDriver().navigate().back();
    }

    public String getText(MobileElement element){
        waitForVisibility(element);
        return element.getText();
    }

    public String getAttribute(MobileElement element, String attribute){
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }
}
