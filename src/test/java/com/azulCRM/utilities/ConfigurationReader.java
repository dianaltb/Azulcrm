package com.azulCRM.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties PROPERTIES = new Properties();

    static{
        try {
            FileInputStream file = new FileInputStream("src/test/resources/configuration.properties");
            PROPERTIES.load(file);
            file.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }
}
