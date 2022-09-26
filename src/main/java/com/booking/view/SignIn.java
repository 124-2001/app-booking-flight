package com.booking.View;
import com.booking.controller.regex.*;
import java.util.Scanner;

public class SignIn {
    public static void signIn() {
        Scanner scan = new Scanner (System.in);
        System.out.println("Đăng nhập");
        System.out.print("Địa chỉ email: ");
        String tempEmail = scan.nextLine();
        while (EmailRegex.emailRegex(tempEmail)) {
            System.out.println("Địa chỉ email chưa đúng định dạng. Vui lòng thử lại.");
            System.out.print("Địa chỉ email: ");
            tempEmail = scan.nextLine();
        }
        System.out.print("Mật khẩu: ");
        String tempPassword = scan.nextLine();
    }
}
