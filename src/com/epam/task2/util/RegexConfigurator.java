package com.epam.task2.util;

import java.util.ResourceBundle;

public class RegexConfigurator {
    private static RegexConfigurator regex;
    private ResourceBundle resourceBundle;

    private RegexConfigurator(String filepath) {
        this.resourceBundle = ResourceBundle.getBundle(filepath);
    }

    public static RegexConfigurator invoke(String filepath) {
        if (regex == null) {
            regex = new RegexConfigurator(filepath);
        }
        return regex;
    }

    public String getString(String key) {
        String value = resourceBundle.getString(key);
        return value;
    }

}
