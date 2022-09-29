package com.booking.View.ViewForUser;

import com.booking.controller.LogicForUser.*;
import com.booking.controller.Regex.DateRegex;
import java.util.Scanner;

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
        String tempDateQuery = scan.nextLine();
        while (DateRegex.dateRegex(tempDateQuery) || DateRegex.realDate(tempDateQuery)) {
            System.out.println("Vui lòng nhập ngày bay hợp lệ theo định dạng dd/mm/yyyy");
            System.out.print("Ngày bay (dd/mm/yyyy): ");
            tempDateQuery = scan.nextLine();
        }
        DateAnalysis tempVar = new DateAnalysis();
        int[] tempDate = tempVar.dateToInt(tempDateQuery);

        LogicListFlight tempQuery = new LogicListFlight();
        tempQuery.SearchFlight(tempFromPlace,tempToPlace,tempDate[0],tempDate[1],tempDate[2]);
		// Scan list chuyến bay

        System.out.println("Vui lòng nhập mã chuyến bay mong muốn." +
                "Nhập 0 để quay trở về màn hình chính.");
        String tempFlightID = scan.nextLine();
        if (tempFlightID.equals("0")) return;
        else {} // Tìm chuyến bay
    }
}
