package com.booking.controller.LogicForAdmin;

import com.booking.model.User;

import java.util.ArrayList;
import java.util.List;

public class LogicListUser {
    List<User> users= new ArrayList<>();

    public boolean CheckListUserNull(){
        if(users.size()==0){
            return true;
        }
        return false;
    }

    public void ShowListUser(){
        if(CheckListUserNull()){
            System.out.println("Danh sách người dùng đang rỗng . ");
            //trở về màn hình ...
        }
        else {
            int count =1;
            for (User user : users) {
                System.out.println("--------------------------");
                System.out.println("STT : "+count);
                System.out.println("Email : "+user.getEmail());
                System.out.println("--------------------------");
                count++;
            }
        }
    }
}
