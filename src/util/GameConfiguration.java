package util;

import common.exception.PropertyNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameConfiguration {

    private static final String CONFIG_FILE_PATH = "game-suite.properties";

    public static String getProperty(String property) throws PropertyNotFoundException, IOException {
        Properties properties = new Properties();
        String configFile = CONFIG_FILE_PATH;
        String propertyValue = "";
        try ( FileInputStream fis = new FileInputStream(configFile)) {
            properties.load(fis);
            // Check if key exists
            if (!properties.containsKey(property)) {
                throw new PropertyNotFoundException();
            }
            propertyValue = properties.getProperty(property);
        } catch (IOException e) {
            Logger.getLogger(GameConfiguration.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        return propertyValue;
    }

}
