package util;

import common.exception.PropertyNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GameConfiguration {

    private GameConfiguration() {
        if (CONFIG_FILE_PATH_ABSOLUTE.isEmpty()) {
            try {
                findConfigFile();
            } catch (FileNotFoundException ex) {
                logger.logError(GameConfiguration.class.getName(), ex);
            }
        }
    }

    public static GameConfiguration getInstance() {
        if (instance == null) {
            synchronized (GameConfiguration.class) {
                if (instance == null) {
                    instance = new GameConfiguration();
                }
            }
        }
        return instance;
    }

    private void findConfigFile() throws FileNotFoundException {
        String baseDir = System.getProperty("user.dir");
        File file = new File(baseDir, CONFIG_FILE_PATH_RELATIVE);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        CONFIG_FILE_PATH_ABSOLUTE = file.getAbsolutePath();
    }

    public String getProperty(String property) {
        String propertyValue = "";
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH_ABSOLUTE)) {
            Properties properties = new Properties();
            properties.load(fis);
            if (!properties.containsKey(property)) {
                throw new PropertyNotFoundException();
            }
            propertyValue = properties.getProperty(property);
        } catch (IOException | PropertyNotFoundException ex) {
             logger.logError(GameConfiguration.class.getName(), ex);
        }
        return propertyValue;
    }

    private static String CONFIG_FILE_PATH_ABSOLUTE = "";
    private static final String CONFIG_FILE_PATH_RELATIVE = "config/application.properties";
    private static volatile GameConfiguration instance;
    private GameSuiteLogger logger;

}
