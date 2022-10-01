package com.booking.View.ViewForUser;

import com.booking.controller.LogicForUser.LogicUserInfo;

import java.util.Scanner;


import static com.booking.View.ViewMain.SignIn.signedIn;

public  class  DisplayInfo {
    public void displayInfo() {
        Scanner scan = new Scanner(System.in);
        String ans = "c";
        do {
            if (LogicUserInfo.verifyChoice1(ans)) {
                System.out.println("******* Quản lý thông tin cá nhân ******");
                System.out.println("Email: " + signedIn.getEmail());
                System.out.println("Mật khẩu: ********");
            }
            System.out.println("Bạn có muốn thay đổi thông tin? Nhập C nếu có, nhập K nếu không.");
            ans = scan.nextLine();
            switch (ans) {
                case "C","c","1" -> {
                    int ans2;
                    do {
                        System.out.println("Vui lòng chọn nội dung muốn thay đổi.");
                        System.out.println("1. Email");
                        System.out.println("2. Mật khẩu");
                        System.out.println("3. Thoát");
                        ans2 = scan.nextInt();
                        while (LogicUserInfo.verifyChoice2(ans2)) {
                            System.out.println("Vui lòng chỉ chọn số từ 1 đến 3");
                            ans2 = scan.nextInt();
                        }
                        if (ans2 == 3) break;
                        LogicUserInfo.processChoice(ans2);
                    } while (true);
                }
                case "K","k","0" -> {
                    System.out.println("Đang quay trở về màn hình chính");
                    return;
                }
                default -> System.out.println("Vui lòng chỉ nhập \"C\" (thay đổi thông tin)" +
                        "hoặc \"K\" (quay trở về màn hình chính.");
            }
        } while (true);
    }
}
