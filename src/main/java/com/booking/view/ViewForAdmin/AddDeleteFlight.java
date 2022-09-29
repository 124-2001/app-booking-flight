package com.booking.View.ViewForAdmin;

import com.booking.controller.LogicForAdmin.LogicListFlight;

import java.util.Scanner;

public class AddDeleteFlight {
    public void AddDeleteFlight(){
        System.out.println("***** THÊM HỦY CHUYẾN BAY *****");
        System.out.println("1) Thêm chuyến bay");
        System.out.println("2) Hủy chuyến bay");
        System.out.println("3) Thoát");
        System.out.println("*******************************");
        Scanner sc = new Scanner(System.in);
        LogicListFlight logicListFlight= new LogicListFlight();
        MenuOptionAdmin menuOptionAdmin = new MenuOptionAdmin();
        System.out.print("Nhập lựa chọn : ");
        int n = sc.nextInt();
        switch (n){
            case 1:
                logicListFlight.AddFlight();
                break;
            case 2:
                logicListFlight.CancelFlight();
                break;
            case 3:
                menuOptionAdmin.MenuOptionAdmin();
                break;
        }
    }
}
