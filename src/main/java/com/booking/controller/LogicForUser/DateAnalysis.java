package com.booking.controller.LogicForUser;

public class DateAnalysis {
    public int[] dateAnalysis(String input) {
        int slash1, slash2;
        slash1 = slash2 = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '/' | input.charAt(i) == '-') {
                if (slash1 != 0) {
                    slash2 = i;
                    break;
                }
                else slash1 = i;
            }
        }

        int[] date = new int[3];
        date[0] = Integer.parseInt(input.substring(0,slash1-1)); // Date
        date[1] = Integer.parseInt(input.substring(slash1+1,slash2-1)); // Month
        date[2] = Integer.parseInt(input.substring(slash2+1)); // Year
        return date;
    }
}
