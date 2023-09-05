package com.Automation.CucumberAuto.Stepdefination;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;

	public class Configuration {
	    private static final String CONFIG_FILE = "config.properties";
	    private static Properties properties = new Properties();

	    static {
	        try {
	            FileInputStream inputStream = new FileInputStream(CONFIG_FILE);
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
	


