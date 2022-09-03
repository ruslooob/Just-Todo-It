package com.ruslooob;

import java.util.Locale;
import java.util.ResourceBundle;

public class LangLoader {

    private static final ResourceBundle langLoader = ResourceBundle.getBundle("lang.ru_RU", new Locale("ru", "RU"));

    public static String $(String key) {
        return langLoader.getString(key);
    }

}
