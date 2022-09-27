package com.booking.view.ViewForUser;

import com.booking.controller.Regex.DateRegex;

import java.util.Scanner;
import java.util.Calendar;

public class BookingWizard {
    public void bookingWizard() {
        Scanner scan = new Scanner (System.in);
        System.out.println("**************** Đặt vé ****************");
        System.out.println("Tra cứu chuyến bay");
        System.out.print("Điểm đi: ");
        String tempFromPlace = scan.nextLine();
        System.out.print("Điểm đến: ");
        String tempToPlace = scan.nextLine();
        System.out.print("Ngày bay (dd/mm/yyyy): ");
        String tempDate = scan.nextLine();
        while (DateRegex.dateRegex(tempDate)) {
            System.out.println("Vui lòng nhập ngày bay theo định dạng dd/mm/yyyy");
            System.out.print("Ngày bay (dd/mm/yyyy): ");
            tempDate = scan.nextLine();
        }
        // Scan list chuyến bay

        System.out.println("Vui lòng nhập mã chuyến bay mong muốn." +
                "Nhập 0 để quay trở về màn hình chính.");
        String tempFlightID = scan.nextLine();
        if (tempFlightID.equals("0")) return;
        else {} // Tìm chuyến bay
    }
}
