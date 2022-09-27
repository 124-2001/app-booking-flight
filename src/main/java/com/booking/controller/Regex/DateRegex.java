package com.booking.controller.Regex;

import java.util.regex.Pattern;

public class DateRegex {
    public static boolean dateRegex(String inputDate) {
        String regexDate = "(^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{2,4}$) |" +
                "(^[0-9]{1,2}\\-[0-9]{1,2}\\-[0-9]{2,4}$)";
        boolean valid = Pattern.matches(regexDate,inputDate);
        return !valid;
    }
}
