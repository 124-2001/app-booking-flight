package com.booking.View.ViewForUser;

import com.booking.controller.LogicData.LogicFile;
import com.booking.controller.LogicForUser.LogicListFlight;
import com.booking.model.Booking;
import static com.booking.View.ViewMain.SignIn.signedIn;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DisplayFlights {
    LogicFile tempLF = new LogicFile();
    LogicListFlight tempLLF = new LogicListFlight();
    public void displayFlights() {
        System.out.println("********** Quản lý chuyến bay **********");
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
//                if (++count == 1) ; // Header
                count++;
                System.out.println(temp);
            }
        }
        if (count == 0) {
            System.out.println("Bạn chưa đặt chuyến bay nào.");
            System.out.println("Bạn có muốn đặt vé máy bay? (Có nhập 1, Không nhập 0)");
        }
        else {
            System.out.println("Tìm kiếm hoàn tất.");
            System.out.println("Bạn có muốn hủy chuyến bay đã đặt? (Có nhập 1, Không nhập 0)");
        }
        Scanner scan = new Scanner(System.in);
        int ans;
        do {
            try {
                ans = scan.nextInt();
                if (ans != 1 && ans != 0) {
                    System.out.println("Vui lòng chỉ nhập giá trị 1 hoặc 0.");
                    continue;
                }
                else break;
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng chỉ nhập giá trị 1 hoặc 0.");
                continue;
            }
        } while (true);
        switch (ans) {
            case 1 -> {
                if (count == 0) {
                    BookingWizard book = new BookingWizard();
                    book.bookingWizard();
                }
                else editFlights();
            }
            case 0 -> {
                MenuOptionUser menu = new MenuOptionUser();
                menu.menuOptionUser();
            }
        }
    }
    public void editFlights() {
        System.out.println("************ Hủy chuyến bay ************");
        Scanner scan = new Scanner(System.in);
        String tempBookingCode = null;
        do {
            System.out.print("Nhập mã đặt vé của chuyến bay cần hủy" +
                    "(Nhập 0 để quay về màn hình chính): ");
            try {
                tempBookingCode = scan.nextLine();
                if (tempBookingCode == "0") break;
                else if (tempLLF.cancelFlight(tempBookingCode))
                    System.out.println("Hủy chuyến bay thành công.");
                else System.out.println("Không tìm thấy mã đặt vé. Vui lòng thử lại.");
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập chính xác mã đặt vé của chuyến bay đã đặt.");
            }
        } while (true);
    }
}
