package com.booking.controller.LogicForAdmin;

import com.booking.View.ViewForAdmin.MenuOptionAdmin;
import com.booking.View.ViewForAdmin.NotificationVoucherFlight;
import com.booking.model.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class LogicListFlight {
    List<Flight> flights = new ArrayList<>();

    String url = "list_file.txt";
    Scanner sc = new Scanner(System.in);

    public boolean CheckListFlightNull(){
        if(flights.size()==0){
            return true;
        }
        return false;
    }

    public boolean CheckListFightCodeIsExist(String FlightCode){
        for (Flight flight : flights) {
            if(flight.getFlightCode().equalsIgnoreCase(FlightCode)){
                return true;
            }
        }
        return false;
    }
    public String RandomFlightCode(){
        String str ="ABCDEFGHYJKQMNL123456789";
        String ramdomFlightCode = "";
        Random random = new Random();
        for (int i =0;i<5;i++){
            int n =random.nextInt(str.length());
            ramdomFlightCode+=str.charAt(n);
        }
        return ramdomFlightCode;
    }

    public void AddFlight(){
        Flight flight = new Flight();
        System.out.println("*****THÊM CHUYẾN BAY*****");
        // Random mã flight code
        String codeFlight = RandomFlightCode();
        while (CheckListFightCodeIsExist(codeFlight)){
            codeFlight = RandomFlightCode();
        }
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
        NotificationVoucherFlight notificationVoucherFlight = new NotificationVoucherFlight();
        notificationVoucherFlight.ViewNotificationVoucher();

    }

    public void CancelFlight(){
        if(CheckListFlightNull()){
            System.out.println("Danh sách đang rỗng . ");
            //trở về màn hình ...
        }
        else {
            System.out.println("Nhập mã chuyến bay để huỷ : ");
            String code = sc.nextLine();
            int count =0;
            for (Flight flight : flights) {
                if(!code.contains(flight.getFlightCode())){
                    flights.remove(flight);
                    System.out.println("Huỷ chuyến bay thành công !");
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.println("Không tìm thấy chuyến bay phù hợp . ");
            }
            ///trở về màn hình ...
        }
    }

    public void ShowListFlight(){
        if(CheckListFlightNull()){
            System.out.println("Danh sách đang rỗng . ");
            //trở về màn hình ...
        }
        else {
            System.out.println("*******LIST CÁC CHUYẾN BAY*******");
            for (Flight flight : flights) {
                System.out.println("*****************************************");
                System.out.println("Mã chuyến bay : "+ flight.getFlightCode());
                System.out.println("Tên chuyến bay : "+flight.getFlightName());
                System.out.println("Điểm xuất phát : "+flight.getFromPlace()+" Điểm kết thúc : "+flight.getToPlace());
                System.out.println("Giá vé : "+flight.getPrice());
                System.out.println("Số chỗ ngồi tối đa : "+flight.getNumberOfSeats());
                System.out.println("*****************************************");
            }
        }
    }
    public void ChangeFlight(){
        if(CheckListFlightNull()){
            System.out.println("Danh sách đang rỗng . ");
            //trở về màn hình ...
            MenuOptionAdmin menuOptionAdmin = new MenuOptionAdmin();
            menuOptionAdmin.MenuOptionAdmin();
        }
        else {
            System.out.print("Nhập mã chuyến bay muốn sửa : ");
            String flightCode = sc.nextLine();
            if(!CheckListFightCodeIsExist(flightCode)){
                System.out.println("Mã chuyến bay không tồn tại .");
                NotificationVoucherFlight notificationVoucherFlight= new NotificationVoucherFlight();
                notificationVoucherFlight.ViewNotificationVoucher();
            }
            for (Flight flight : flights) {
                if(flight.getFlightCode().equalsIgnoreCase(flightCode)){
                    System.out.println("Nhập tên chuyến bay : ");
                    String flightName = sc.nextLine();
                    flight.setFlightName(flightName);
                    System.out.println("Nhập điểm xuất phát :");
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
                    System.out.println("Sửa thông tin thành công . ");
                    NotificationVoucherFlight notificationVoucherFlight = new NotificationVoucherFlight();
                    notificationVoucherFlight.ViewNotificationVoucher();
                }
            }
        }
    }

}
