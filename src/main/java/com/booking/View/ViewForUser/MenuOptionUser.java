package com.booking.View.ViewForUser;

import com.booking.View.MenuMain;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuOptionUser {
    public void menuOptionUser() {
        System.out.println("**************MENU USER**************");
        System.out.println("1) Đặt vé");
        System.out.println("2) Thông báo");
        System.out.println("3) Chuyến bay");
        System.out.println("4) Thông tin tài khoản");
        System.out.println("5) Đăng xuất");
        System.out.println("****************************************");
        System.out.print("Nhập lựa chọn: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        switch (n) {
            case 1 -> {
                BookingWizard book = new BookingWizard();
                book.bookingWizard();
            }
            case 2 -> {
                Notifications notifs = new Notifications();
                notifs.notifications();
            }
            case 3 -> {
                DisplayFlights flights = new DisplayFlights();
                flights.displayFlights();
            }
            case 4 -> {
                DisplayInfo info = new DisplayInfo();
                info.displayInfo();
            }
            case 5 -> {
                MenuMain menu = new MenuMain();
                try {
                    menu.DisplayMain();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
