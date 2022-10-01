package com.booking.View.ViewForUser;

import com.booking.controller.LogicAccount.Account;
import com.booking.controller.LogicForUser.LogicUserInfo;
import com.booking.controller.Regex.EmailRegex;
import static com.booking.View.ViewMain.SignIn.signedIn;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class EditInfo {
    Account account = new Account();
    public void editEmail() throws FileNotFoundException {
        Scanner scan = new Scanner (System.in);
        String tempEmail = null; int confirm = 1;
        boolean temp1, temp2, temp3;
        do {
            temp1 = temp2 = temp3 = false;
            do {
                System.out.print("Nhập email mới: ");
                try {
                    tempEmail = scan.nextLine();
                } catch (InputMismatchException e) {
                    temp3 = true;
                }
                if (temp3 || EmailRegex.emailRegex(tempEmail)) {
                    System.out.println("Địa chỉ email chưa đúng định dạng. Vui lòng thử lại.");
                    temp2 = true;
                }
            } while (temp2);
            if (!account.CheckEmailIsExist(tempEmail)) {
                System.out.println("Địa chỉ email đã tồn tại. Vui lòng sử dụng email khác.");
                temp1 = true;
            }
        } while (temp1);


        System.out.println("Địa chỉ email của bạn sẽ được đổi thành \"" + tempEmail + "\".");
        System.out.print("Bạn có chắc muốn đổi email không? (Có bấm 1, Không bấm 0)");
        do {
            temp1 = false;
            try {
                confirm = scan.nextInt();
                if (confirm != 1 && confirm != 0) {
                    temp1 = true;
                    System.out.println("Vui lòng chỉ nhập giá trị 1 hoặc 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng chỉ nhập giá trị 1 hoặc 0.");
            }
        } while (temp1);

        System.out.println("Đang đổi Email. 0% hoàn thành...");
        LogicUserInfo.editEmailDelAdd(signedIn.getEmail(),tempEmail);
    }
    public void editPassword() {

    }
}
