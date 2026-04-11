package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

   private static final Properties prop = new Properties();

   static  {
        String projectPath = System.getProperty("user.dir");
        String configFilePath = projectPath + "/src/test/resources/config.properties" ;
   try (FileInputStream inputStream = new FileInputStream(configFilePath))
       {
            prop.load(inputStream);
        } catch (IOException e)
       {
            e.printStackTrace();
            throw new RuntimeException("Configuration File Not Found at : " + configFilePath, e);
        }
    }

    public static String getProperty( String key ) {
        String value = prop.getProperty(key);

        if (value == null)
        {
            throw new MissingPropertyException("Key '" + key + "' not found in configuration file");
        }
        return value;
    }
}
