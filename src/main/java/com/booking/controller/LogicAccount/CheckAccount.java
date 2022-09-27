package com.booking.controller.LogicAccount;

import com.booking.model.User;

import java.util.ArrayList;
import java.util.List;

public class CheckAccount {
    static List<User> userList = new ArrayList<>();
    public static boolean CheckUserPassword(String email, String passWord){
        for (User user : userList) {
            if(user.getEmail().equalsIgnoreCase(email)&& user.getPassWord().equalsIgnoreCase(passWord)){
               return true;
            }
        }
        return false;
    }
}
