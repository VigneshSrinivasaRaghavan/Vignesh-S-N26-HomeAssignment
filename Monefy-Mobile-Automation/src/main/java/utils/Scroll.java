package utils;

import driver.DriverManager;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class Scroll {

    public static void scrollUsingTouchAction(String direction) {
        Dimension dimension = DriverManager.getDriver().manage().window().getSize();
        int x = dimension.getWidth() / 2;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case "up":
                startY = (int) (dimension.getHeight() * 0.8);
                endY = (int) (dimension.getHeight() * 0.2);
                break;

            case "down":
                startY = (int) (dimension.getHeight() * 0.2);
                endY = (int) (dimension.getHeight() * 0.8);
                break;
        }

        TouchAction t = new TouchAction(DriverManager.getDriver());
        t.press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(x, endY)).release().perform();
    }

    public static MobileElement scrollToElement() {
        return (MobileElement) ((FindsByAndroidUIAutomator) DriverManager.getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description(\"test-Price\"));");
    }
}
