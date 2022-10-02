package com.booking.View.ViewForUser;

import com.booking.controller.LogicData.LogicFile;
import com.booking.model.Booking;
import static com.booking.View.ViewMain.SignIn.signedIn;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DisplayFlights {
    public void displayFlights() {
        System.out.println("********** Quản lý chuyến bay **********");
        LogicFile tempLF = new LogicFile();
        List<Booking> bookings;
        int count = 0;
        try {
            bookings = tempLF.ConvertFileToBooking();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi đọc file. Đang quay trở về màn hình chính...");
            return;
        }
        for (Booking temp: bookings) {
            if (temp.getUserEmail().equalsIgnoreCase(signedIn.getEmail())) {
                if (++count == 1) ; // Header
                System.out.printf("");
            }
        }
        if (count == 0) {
            System.out.println("Bạn chưa đặt chuyến bay nào.");
        }
        else {
            System.out.println("Tìm kiếm hoàn tất.");
            System.out.println("Bạn có muốn hủy chuyến bay đã đặt? (Có nhập 1, Không nhập 0)");
        }
    }
}
