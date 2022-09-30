package com.booking.View.ViewForUser;

import com.booking.controller.LogicForUser.*;
import com.booking.controller.Regex.DateRegex;
import com.booking.model.Flight;
import java.util.ArrayList;
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

        LogicListFlight tempLLF = new LogicListFlight();
        ArrayList<Flight> filteredFlights = tempLLF.SearchFlight(tempFromPlace,tempToPlace,tempDateQuery);
		// Scan list chuyến bay
        if (filteredFlights.isEmpty()) {
            System.out.println("Không tìm thấy chuyến bay theo bộ lọc. Đang quay trở về màn hình chính...");
            return;
        }

        for (Flight temp: filteredFlights) System.out.println(temp);
        System.out.println("Vui lòng nhập mã chuyến bay mong muốn." +
                "Nhập 0 để quay trở về màn hình chính.");
        String tempFlightCode = scan.nextLine();
        if (tempFlightCode.equals("0")) return;
        Flight booked = tempLLF.confirmFlight(filteredFlights,tempFlightCode);

        // Add variable 'booked' to user's booked flight list

        System.out.println("Chuyến bay " + booked.getFlightCode() + "đặt thành công");
        System.out.println(booked);
    }
}
