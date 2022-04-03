package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class AppiumServer {

    public static AppiumDriverLocalService appiumServer;

    public static void startServer() {
        appiumServer = getAppiumServer();
        appiumServer.start();
    }

    public static void stopServer() {
        appiumServer.stop();
    }

    private static AppiumDriverLocalService getAppiumServer() {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withLogFile(new File("ServerLogs/appiumLogs.log")));
        Field streamField = null;
        Field streamsField = null;
        try {
            streamField = AppiumDriverLocalService.class.getDeclaredField("stream");
            streamField.setAccessible(true);
            streamsField = Class.forName("io.appium.java_client.service.local.ListOutputStream")
                    .getDeclaredField("streams");
            streamsField.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            ((ArrayList<OutputStream>) streamsField.get(streamField.get(service))).clear(); // remove System.out logging
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return service;
    }
}
