package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // get loaded object of properties file

    static Properties getLoadedPropertiesObject() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("Properties/config.properties");
        prop.load(fis);

        return prop;
    }

    public static String getUrl() throws IOException {

       return getLoadedPropertiesObject().getProperty("baseUrl");
    }



}
