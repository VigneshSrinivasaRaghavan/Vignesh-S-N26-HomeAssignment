package utils;

import driver.DriverManager;
import io.appium.java_client.InteractsWithApps;

public class AppInteractions {
    public static void launchApp() {
        ((InteractsWithApps) DriverManager.getDriver()).launchApp();
    }

    public static void closeApp() {
        ((InteractsWithApps) DriverManager.getDriver()).closeApp();
    }
}
