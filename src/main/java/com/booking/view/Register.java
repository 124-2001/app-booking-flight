package com.booking.View;

import java.util.Scanner;
import com.booking.controller.regex.*;

public class Register {
    public  void register() {
        Scanner scan = new Scanner (System.in);
        System.out.println("Đăng ký");
        System.out.println("Loại tài khoản: 0 - Tài khoản người dùng; 1 - Tài khoản admin");
        System.out.print("Chọn loại tài khoản: ");
        int tempPerm = scan.nextInt();
        while (tempPerm != 1 && tempPerm != 0) {
            System.out.println("Vui lòng chỉ chọn giá trị 0 hoặc 1");
            System.out.println("Loại tài khoản: 0 - Tài khoản người dùng; 1 - Tài khoản admin");
            System.out.print("Chọn loại tài khoản: ");
            tempPerm = scan.nextInt();
        }

        System.out.print("Địa chỉ email: ");
        String tempEmail = scan.nextLine();
        while (EmailRegex.emailRegex(tempEmail)) {
            System.out.println("Địa chỉ email chưa đúng định dạng. Vui lòng thử lại.");
            System.out.print("Địa chỉ email: ");
            tempEmail = scan.nextLine();
        }

        System.out.print("Mật khẩu: ");
        String tempPassword = scan.nextLine();
        while (PasswordRegex.passwordRegex(tempPassword)) {
            System.out.println("Mật khẩu chưa đủ độ bảo mật. Vui lòng thử lại.");
            System.out.println("Để tạo mật khẩu có độ bảo mật cao: ");
            System.out.println("- Mật khẩu phải chứa ít nhất 8 kí tự");
            System.out.println("- Mật khẩu phải sử dụng ít nhất một chữ cái viết thường, " +
                    "một chữ cái viết hoa, một chữ số và một ký tự đặc biệt " +
                    "(không phải chữ hoặc số)");
            System.out.print("Mật khẩu: ");
            tempPassword = scan.nextLine();
        }
    }
}
