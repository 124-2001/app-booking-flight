package com.booking.View;

import java.util.Scanner;

public class MenuMain {
    public static void DisplayMain(){
        Scanner sc = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("1) Đăng nhập");
        System.out.println("2) Đăng ký");
        System.out.println("3) Thoát chương trình");
        System.out.println("******************************");
        System.out.println("NHẬP LỰA CHỌN : ");
        int n = sc.nextInt();
        switch (n){
            case 1:
                SignIn sign = new SignIn();
                sign.signIn();
                break;
            case 2:
                Register register = new Register();
                register.register();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}
