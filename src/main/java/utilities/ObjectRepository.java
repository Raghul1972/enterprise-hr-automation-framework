package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepository {

    private static Properties properties = new Properties();

    public static void load(String fileName) {

        try {

            FileInputStream file = new FileInputStream(
                    "src/test/resources/objectRepository/" + fileName + ".properties");

            properties.load(file);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static String getLocator(String key) {

        return properties.getProperty(key);

    }

}