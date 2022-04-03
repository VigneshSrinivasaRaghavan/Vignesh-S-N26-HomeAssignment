package framework.constants;

import framework.enums.ConfigProperties;
import framework.utils.PropertyUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class FrameworkConstants {


    private FrameworkConstants() {

    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentReportFinalPath = "";

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String getExtentReportFilePath() {
        if (extentReportFinalPath.isEmpty()) {
            extentReportFinalPath = createReportPath();
        }
        return extentReportFinalPath;
    }

    private static String createReportPath(){
        if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
            return EXTENTREPORTFOLDERPATH + "index.html";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyy_HH:mm:ss");
            Date date = new Date();
            return EXTENTREPORTFOLDERPATH + formatter.format(date) + "_" + "index.html";
        }
    }
}
