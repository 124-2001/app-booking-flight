package com.booking.controller.LogicAccount;

import com.booking.model.User;

import java.util.ArrayList;
import java.util.List;

public class Account {
    static List<User> userList = new ArrayList<>();
    public static boolean CheckUserPassword(String email, String passWord){
        for (User user : userList) {
            if(user.getEmail().equalsIgnoreCase(email)&& user.getPassWord().equalsIgnoreCase(passWord)){
               return true;
            }
        }
        return false;
    }

    public static boolean CheckEmailIsExist(String email){
        for (User user : userList) {
            if(user.getEmail().equalsIgnoreCase(email)){
                return false;
            }
        }
        return true;
    }

    public static void AddAccount(String email, String passWord, int perm){
        User user = new User();
        user.setEmail(email);
        user.setPassWord(passWord);
        user.setPosition_id(perm);
        userList.add(user);
    }
}
