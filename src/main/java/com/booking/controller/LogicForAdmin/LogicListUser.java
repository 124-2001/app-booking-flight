package com.booking.controller.LogicForAdmin;

import com.booking.controller.LogicData.LogicFile;
import com.booking.model.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LogicListUser {

    LogicFile logicFile = new LogicFile();

    public boolean CheckListUserNull() throws FileNotFoundException {
        List<User> users= logicFile.ConvertFileToUser();
        if(users.size()==0){
            return true;
        }
        return false;
    }

    public boolean CheckUserIsExist(String email) throws FileNotFoundException {
        List<User> users= logicFile.ConvertFileToUser();
        for (User user : users) {
            if(user.getEmail().contains(email)){
                return true;
            }
        }
        return false;
    }

    public void ShowListUser() throws FileNotFoundException {
        List<User> users= logicFile.ConvertFileToUser();
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

    public void DeleteUserByEmail(String email) throws FileNotFoundException {
        List<User> users= logicFile.ConvertFileToUser();
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
