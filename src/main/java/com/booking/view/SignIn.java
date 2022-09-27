package com.booking.View;
import com.booking.View.ViewForAdmin.MenuOptionAdmin;
import com.booking.controller.LogicAccount.CheckAccount;
import com.booking.controller.regex.*;
import java.util.Scanner;

public class SignIn {
    public void signIn() {
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
        while (!CheckAccount.CheckUserPassword(tempEmail,tempPassword)){
            System.out.println("Nhập sai vui lòng nhập lại ");
            System.out.print("Địa chỉ email: ");
            tempEmail = scan.nextLine();
            while (EmailRegex.emailRegex(tempEmail)) {
                System.out.println("Địa chỉ email chưa đúng định dạng. Vui lòng thử lại.");
                System.out.print("Địa chỉ email: ");
                tempEmail = scan.nextLine();
            }
            System.out.print("Mật khẩu: ");
            tempPassword = scan.nextLine();
        }
        MenuOptionAdmin menuOptionAdmin = new MenuOptionAdmin();
        menuOptionAdmin.MenuOptionAdmin();
    }
}
