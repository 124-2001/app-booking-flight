package com.booking.View.ViewForAdmin;

import com.booking.controller.LogicForAdmin.LogicNotificationAndVoucher;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class NotificationVoucherFlight {
    public void ViewNotificationVoucher() throws FileNotFoundException {
        LogicNotificationAndVoucher logicNotificationAndVoucher = new LogicNotificationAndVoucher();
        System.out.println("*******************************");
        System.out.println("1) Gửi thông báo cho người dùng");
        System.out.println("2) Tạo mã Voucher Khuyến Mại");
        System.out.println("3) Thoát");
        System.out.println("*******************************");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập lựa chọn: ");
        int n = sc.nextInt();
        while (n<0||n>3){
            System.out.print("Nhập lại : ");
            n= sc.nextInt();
        }
        switch (n){
            case 1:
                logicNotificationAndVoucher.SendNotificationCancelFlight();
                break;
            case 2:
                logicNotificationAndVoucher.AddVoucher();
                break;
            case 3:
                MenuOptionAdmin menuOptionAdmin = new MenuOptionAdmin();
                menuOptionAdmin.MenuOptionAdmin();
                break;
        }
    }
}
