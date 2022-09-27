package com.booking.view.ViewForAdmin;

import com.booking.controller.LogicForAdmin.LogicListFlight;

import java.util.Scanner;

public class MenuOptionAdmin {
    public void MenuOptionAdmin(){
        System.out.println("********MENU ADMIN********");
        System.out.println("1) Thêm , hủy chuyến bay ");
        System.out.println("2) Sửa thông tin chuyến bay ");
        System.out.println("3) Quản lý người dùng ");
        System.out.println("4) Hiển thị list chuyến bay đã có");
        System.out.println("5) Thông báo và voucher người dùng");
        System.out.println("6) Đăng xuất");
        System.out.println("**************************");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập lựa chọn: ");
        int n = sc.nextInt();
        switch (n){
            case 1:
                AddDeleteFlight addDeleteFlight = new AddDeleteFlight();
                addDeleteFlight.AddDeleteFlight();
                break;
            case 2:
                LogicListFlight logicListFlight= new LogicListFlight();
                logicListFlight.ChangeFlight();
                break;
        }

    }
}
