package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties initProperties() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        prop.load(fis);
        return prop;
    }
}
