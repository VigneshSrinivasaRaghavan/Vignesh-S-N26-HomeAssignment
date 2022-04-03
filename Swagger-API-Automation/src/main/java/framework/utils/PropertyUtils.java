package framework.utils;

import framework.constants.FrameworkConstants;
import framework.enums.ConfigProperties;
import framework.exceptions.InvalidFilePathException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){
    }

    private static Properties property = new Properties();

    static {
        try(FileInputStream fs = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getValue(ConfigProperties key){
        String value = "";
        value = property.getProperty(key.name().toLowerCase());
        if(Objects.isNull(value)){
            throw new InvalidFilePathException("Property name "+key+" is not found. Please check the config.properties");
        }
        return value;
    }
}
