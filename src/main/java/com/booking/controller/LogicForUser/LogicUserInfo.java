package com.booking.controller.LogicForUser;

import com.booking.View.ViewForUser.EditInfo;

public class LogicUserInfo {
    public static boolean verifyChoice1(String input) {
        boolean b = input.equalsIgnoreCase("c") || input.equalsIgnoreCase("k")
                || input.equalsIgnoreCase("1") || input.equalsIgnoreCase("0");
        return b;
        // Not one of the above characters => Return b = false => Won't trigger info display again.
    }
    public static boolean verifyChoice2(int input) {
        boolean b = input >= 1 && input <=3;
        return !b;
        // Not a number from 1 to 3 => b = false => Return true => Activate while loop
    }
    public static void processChoice(int input) {
        EditInfo temp = new EditInfo();
        switch (input) {
            case 1 -> temp.editEmail();
            case 2 -> temp.editPassword();
        }
    }
}
