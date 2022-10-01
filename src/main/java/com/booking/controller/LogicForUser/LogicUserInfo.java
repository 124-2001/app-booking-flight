package com.booking.controller.LogicForUser;

import com.booking.View.ViewForAdmin.ManagementUser;
import com.booking.View.ViewForUser.EditInfo;
import com.booking.controller.LogicData.LogicFile;
import com.booking.controller.LogicData.LogicJson;
import com.booking.model.User;

import java.io.FileNotFoundException;
import java.util.List;

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
            case 1 -> {
                try {
                    temp.editEmail();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            case 2 -> temp.editPassword();
        }
    }
    public static void editEmailDelAdd(String oldE,String newE) throws FileNotFoundException {
        LogicFile logicFile = new LogicFile();
        LogicJson logicJson = new LogicJson();
        List<User> users= logicFile.ConvertFileToUser();
        String password = null;
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(oldE) && user.getPosition_id()==1){
                password = user.getPassWord();
                users.remove(user);
                logicFile.DeleteUserInFile(users);
                System.out.println("Đang đổi Email. 50% hoàn thành...");
                // Just to confirm this process is performed correctly
                break;
            }
        }
        // Xóa người dùng cũ

        User user = new User();
        user.setEmail(newE);
        user.setPassWord(password);
        user.setPosition_id(1);
        logicFile.WriteStringJsonToFile(logicJson.ConvertObjectToStringJson(user),"list_user.txt");
        System.out.println("Đã đổi Email. 100% hoàn thành.");
        // Thêm người dùng mới với email mới, password và perm không đổi
    }
}
