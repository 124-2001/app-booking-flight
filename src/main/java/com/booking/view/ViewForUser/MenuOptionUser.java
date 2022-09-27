package com.booking.View.ViewForUser;

import java.util.Scanner;

public class MenuOptionUser {
    public void menuOptionUser() {
        System.out.println("************** Menu chính **************");
        System.out.println("1) Đặt vé");
        System.out.println("2) Thông báo");
        System.out.println("3) Chuyến bay");
        System.out.println("4) Thông tin tài khoản");
        System.out.println("****************************************");
        System.out.print("Nhập lựa chọn: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        switch (n) {
            case 1 -> {
                com.booking.View.ViewForUser.BookingWizard book = new com.booking.View.ViewForUser.BookingWizard();
                book.bookingWizard();
            }
            case 2 -> {
                com.booking.View.ViewForUser.Notifications notifs = new com.booking.View.ViewForUser.Notifications();
                notifs.notifications();
            }
            case 3 -> {
                com.booking.View.ViewForUser.DisplayFlights flights = new com.booking.View.ViewForUser.DisplayFlights();
                flights.displayFlights();
            }
            case 4 -> {
                com.booking.View.ViewForUser.DisplayInfo info = new com.booking.View.ViewForUser.DisplayInfo();
                info.displayInfo();
            }
        }
    }
}
