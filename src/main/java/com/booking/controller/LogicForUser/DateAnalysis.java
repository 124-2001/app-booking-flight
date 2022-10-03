package com.booking.controller.LogicForUser;

import java.util.Calendar;
public class DateAnalysis {
    public static int[] dateToInt(String input) {
        int slash1, slash2;
        slash1 = slash2 = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/' || input.charAt(i) == '-') {
                if (slash1 != 0) {
                    slash2 = i;
                    break;
                }
                else slash1 = i;
            }
        }

        int[] date = new int[3];
        date[0] = Integer.parseInt(input.substring(0,slash1)); // Date
        date[1] = Integer.parseInt(input.substring(slash1+1,slash2)); // Month
        date[2] = Integer.parseInt(input.substring(slash2+1)); // Year
        return date;
    }
    public static Calendar dateToCal(String input) {
        int[] dateInt = dateToInt(input);
        Calendar dateCal = Calendar.getInstance();
        dateCal.set(dateInt[2],dateInt[1]-1,dateInt[0]);
        return dateCal;
    }
}
