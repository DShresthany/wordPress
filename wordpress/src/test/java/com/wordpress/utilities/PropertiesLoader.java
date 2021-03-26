package com.wordpress.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {

  private static final String PROPERTIES_FILE_PATH = "src/test/resources/test_config.properties";
  private static PropertiesLoader SINGLE_INSTANCE = null;
  private final Properties properties = new Properties();

  private PropertiesLoader() {
  }

  public static PropertiesLoader getInstance() {
    if (SINGLE_INSTANCE == null) {
      synchronized (PropertiesLoader.class) {
        if (SINGLE_INSTANCE == null) {
          InputStream file = null;
          try {
            file = new FileInputStream(PROPERTIES_FILE_PATH);
            SINGLE_INSTANCE = new PropertiesLoader();
            SINGLE_INSTANCE.properties.load(file);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return SINGLE_INSTANCE;
  }

  public String getPropertyValue(String propertyKey) {
    if (propertyKey != null && !propertyKey.isEmpty()) {
      return properties.getProperty(propertyKey);
    }
    return null;
  }

  public Map<String, String> getProperties() {
    Map<String, String> propertyMap = new HashMap<String, String>();
    for (String propertyKey : properties.stringPropertyNames()) {
      propertyMap.put(propertyKey, properties.getProperty(propertyKey));
    }
    return propertyMap;
  }

}