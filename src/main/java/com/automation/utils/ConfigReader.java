package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.error("Configuration file 'config.properties' not found in classpath.");
                throw new IllegalStateException("config.properties missing from classpath");
            }
            properties.load(input);
            logger.info("Configuration properties loaded successfully.");
        } catch (IOException e) {
            logger.error("Failed to load 'config.properties' file.", e);
            throw new RuntimeException("Could not load configuration file", e);
        }
}

    public static String getUrl() {
        String url = properties.getProperty("url");
        if (url == null || url.trim().isEmpty()) {
            logger.warn("Property 'url' is missing or empty in config.properties.");
        } else {
            logger.debug("Retrieved URL property: {}", url);
        }
        return url;
    }
}