package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    public static String getConnectionString(String propertyFileName) {
        Properties prop = new Properties();
        String connectionString = null;

        try (FileInputStream input = new FileInputStream(propertyFileName)) {
         
            prop.load(input);

         
            connectionString = prop.getProperty("url");

        } catch (IOException ex) {
            System.out.println("Error reading property file: " + ex.getMessage());
        }

        return connectionString;
    }
}

