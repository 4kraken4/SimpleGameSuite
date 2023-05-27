package util;

import org.apache.commons.validator.GenericValidator;

public class Validator {

    public Validator() {
        translationHandler = TranslationHandler.getInstance();
    }

    private static TranslationHandler translationHandler;
    private static final int MIN_LEN_USERNAME = 8;
    private static final int MAX_LEN_USERNAME = 20;

    public String validateUserName(String username) {
        String translationSchema = TranslationHandler.SCHEMMA_ERROR_TRANSLATION;
        if (GenericValidator.isBlankOrNull(username)) {
            return translationHandler.getTranslation(translationSchema, "ERRMSG_EMPTYUSERNAME");
        }
        if (!GenericValidator.minLength(username, MIN_LEN_USERNAME)) {
            return String.format(
                    translationHandler.
                            getTranslation(translationSchema, "ERRMSG_SHORTUSERNAME"), MIN_LEN_USERNAME);
        }
        if (!GenericValidator.maxLength(username, MAX_LEN_USERNAME)) {
            return String.format(
                    translationHandler.
                            getTranslation(translationSchema, "ERRMSG_LENGTHYUSERNAME"), MAX_LEN_USERNAME);
        }
        if (username.trim().contains(" ")) {
            return translationHandler.getTranslation(translationSchema, "ERRMSG_SPACEDUSERNAME");
        }
        if (!username.matches("[\\s\\w\\d]+?")) {
            return translationHandler.getTranslation(translationSchema, "ERRMSG_SPECHARUSERNAME");
        }
        return "";
    }
}
