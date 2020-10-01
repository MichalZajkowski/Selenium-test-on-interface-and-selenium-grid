package framework.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.Properties;

public class Configuration {

    private static final String FRAMEWORK_PROPERTIES = "framework.properties";
    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);
    private Configuration instance = null;

    public Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String getProperty(String key) {
        final String property = System.getProperty(key);
        if (property == null) {
            throw new InvalidParameterException(MessageFormat.format("Missing value for key '{0}'!", key));
        }
        return property;
    }

    public void setProperty(String key, String value) {
        System.setProperty(key, value);
    }

    public String getPropertyFromFile(String key) {
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream(FRAMEWORK_PROPERTIES);
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Error while loading properties file!", e);
        }
        return properties.getProperty(key);
    }
}
