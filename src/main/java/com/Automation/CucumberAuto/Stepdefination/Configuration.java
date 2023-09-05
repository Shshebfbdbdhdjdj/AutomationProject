package com.Automation.CucumberAuto.Stepdefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties = new Properties();

    static {
    	try {
    	    File configFile = new File("src/main/resources/features/config.properties");
    	    FileInputStream inputStream = new FileInputStream(configFile);
    	    properties.load(inputStream);
    	    inputStream.close();
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
