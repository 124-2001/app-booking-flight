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

    public boolean CheckUserIsExist(String email){
        for (User user : users) {
            if(user.getEmail().contains(email)){
                return true;
            }
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

    public void DeleteUserByEmail(String email){
        if(!CheckUserIsExist(email)){
            System.out.println("Không tìm được user, user không tồn tại . ");
            //trở về màn hình ...

        }
        else {
            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(email)){
                    users.remove(user);
                    System.out.println("Xóa thành công user : "+email);
                    break;
                }
            }
            //trở về màn hình ...
        }
    }
}
