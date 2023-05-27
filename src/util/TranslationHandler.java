package util;

public class TranslationHandler {

    private TranslationHandler() {
        TRANSLATION_FILE_PATH_ABSOLUTE = GameConfiguration
                .getInstance()
                .getProperty("TRANSLATIONPATH");
    }

    public static TranslationHandler getInstance() {
        if (instance == null) {
            synchronized (TranslationHandler.class) {
                if (instance == null) {
                    instance = new TranslationHandler();
                }
            }
        }
        return instance;
    }

    public String getTranslation(String schema, String labelIdentifier) {
        return Utilities.getValueFromJsonFile(
                TRANSLATION_FILE_PATH_ABSOLUTE + "/" + schema + ".json", labelIdentifier);
    }

    private static String TRANSLATION_FILE_PATH_ABSOLUTE;
    private static volatile TranslationHandler instance;
    public static final String SCHEMMA_ERROR_TRANSLATION = "error-label-translation";
}
