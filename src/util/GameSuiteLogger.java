package util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

public class GameSuiteLogger {

    private GameSuiteLogger() {
        configuration = GameConfiguration.getInstance();
        logger = Logger.getLogger(GameSuiteLogger.class.getName());
        configureLogger();
    }

    public static GameSuiteLogger getInstance() {
        if (instance == null) {
            synchronized (GameSuiteLogger.class) {
                if (instance == null) {
                    instance = new GameSuiteLogger();
                }
            }
        }
        return instance;
    }

    private void configureLogger() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = now.format(formatter);
        int RETAINABLE_FILECOUNT = Integer.parseInt(configuration.getProperty("RETAINABLE_LOGFILECOUNT"));
        int MAX_FILESIZE = Integer.parseInt(configuration.getProperty("MAX_LOGFILE_SIZE"));
        String BASEDIR = System.getProperty("user.dir");
        String LOGDIR = configuration.getProperty("LOGFOLDERNAME");
        String LOGFILE = configuration.getProperty("LOGFILENAME");
        LOGFILEPATH = BASEDIR.concat("/") + LOGDIR.concat("/") + LOGFILE + "_" + formattedDateTime + ".log";
        try {
            FileHandler fileHandler = new FileHandler(LOGFILEPATH, MAX_FILESIZE, RETAINABLE_FILECOUNT, false);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Error configuring logger: " + e.getMessage());
        }
    }

    public void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public void logError(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }

    private static Logger logger;
    private static String LOGFILEPATH;
    private static volatile GameSuiteLogger instance;
    private final GameConfiguration configuration;
}
