package com.exemple.utils;

public class TextUtils {
    public String sanitize(String stringToSanitize){
        return stringToSanitize.replaceAll("\\s+"," ");
    }
}
