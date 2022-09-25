package com.booking.controller.LogicForAdmin;

import com.booking.model.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogicShowList {
    List<Flight> flights = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean CheckListFlightNull(){
        if(flights.size()==0){
            return true;
        }
        return false;
    }

    public void AddFlight(){
        Flight flight = new Flight();
        System.out.println("*****THÊM CHUYẾN BAY*****");
        System.out.println("Nhập mã chuyến bay : ");
        String codeFlight = sc.nextLine();
        flight.setFlightCode(codeFlight);
        System.out.println("Nhập tên chuyến bay : ");
        String nameFlight = sc.nextLine();
        flight.setFlightName(nameFlight);
        System.out.println("Nhập điểm xuất phát : ");
        String fromPlace = sc.nextLine();
        flight.setFromPlace(fromPlace);
        System.out.println("Nhập điểm hạ cánh : ");
        String endPlace = sc.nextLine();
        flight.setToPlace(endPlace);
        System.out.println("Nhập giá tiền : ");
        long price = sc.nextLong();
        flight.setPrice(price);
        System.out.println("Nhập số ghế ngồi tối đa : ");
        int seats = sc.nextInt();
        flight.setNumberOfSeats(seats);
        System.out.println("*************************");
        flights.add(flight);
        System.out.println("Chuyến bay được thêm thành công");
        // sau đó trở về màn hình
    }

    public void CancelFlight(){
        if(CheckListFlightNull()){
            System.out.println("Danh sách đang rỗng . ");
            //trở về màn hình ...
        }
        else {
            System.out.println("Nhập mã chuyến bay để huỷ : ");
            String code = sc.nextLine();
        }
    }

}
