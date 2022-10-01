package com.booking.View.ViewForAdmin;

import com.booking.View.ViewMain.MenuMain;
import com.booking.controller.LogicForAdmin.LogicListFlight;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuOptionAdmin {
    public void MenuOptionAdmin() throws FileNotFoundException {
        AddDeleteFlight addDeleteFlight = new AddDeleteFlight();
        LogicListFlight logicListFlight= new LogicListFlight();
        ManagementUser managementUser = new ManagementUser();
        NotificationVoucherFlight notificationVoucherFlight= new NotificationVoucherFlight();
        MenuMain menuMain = new MenuMain();
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
        while (n<0||n>6){
            System.out.print("Nhập lại : ");
            n = sc.nextInt();
        }
        switch (n){
            case 1:
                addDeleteFlight.AddDeleteFlight();
                break;
            case 2:
                logicListFlight.ChangeFlight();
                break;
            case 3:
                managementUser.ViewManagement();
                break;
            case 4:
                logicListFlight.ShowListFlight();
                break;
            case 5:
                notificationVoucherFlight.ViewNotificationVoucher();
                break;
            case 6:
                menuMain.DisplayMain();
                break;
        }

    }
}
