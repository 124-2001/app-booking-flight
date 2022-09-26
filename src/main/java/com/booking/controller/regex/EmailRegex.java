package com.booking.controller.regex;

import java.util.regex.Pattern;

public class EmailRegex {
    public static boolean emailRegex(String inputEmail) {
        String regexEmail = "^\\w+(\\+\\w+)?@\\w+\\.com$";
        boolean valid = Pattern.matches(regexEmail,inputEmail);
        return !valid;
    }
}