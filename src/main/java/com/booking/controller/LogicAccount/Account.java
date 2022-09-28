package com.booking.controller.LogicAccount;

import com.booking.controller.LogicData.LogicFile;
import com.booking.controller.LogicData.LogicJson;
import com.booking.model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Account {
     List<User> userList = new ArrayList<>();
     String url="list_user.txt";
    public boolean CheckUserPassword(String email, String passWord){
        for (User user : userList) {
            if(user.getEmail().equalsIgnoreCase(email)&& user.getPassWord().equalsIgnoreCase(passWord)){
               return true;
            }
        }
        return false;
    }
    public boolean CheckEmailIsExist(String email){
        for (User user : userList) {
            if(user.getEmail().equalsIgnoreCase(email)){
                return false;
            }
        }
        return true;
    }
    public void AddAccount(String email, String passWord, int perm){
        User user = new User();
        user.setEmail(email);
        user.setPassWord(passWord);
        user.setPosition_id(perm);
        LogicFile logicFile = new LogicFile();
        LogicJson logicJson = new LogicJson();
        logicFile.WriteStringJsonToFile(logicJson.ConvertObjectToStringJson(user),url);
    }
}
