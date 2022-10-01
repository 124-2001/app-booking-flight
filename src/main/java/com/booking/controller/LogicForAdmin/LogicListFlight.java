package com.booking.controller.LogicForAdmin;

import com.booking.View.ViewForAdmin.AddDeleteFlight;
import com.booking.View.ViewForAdmin.MenuOptionAdmin;
import com.booking.View.ViewForAdmin.NotificationVoucherFlight;
import com.booking.controller.LogicAccount.Account;
import com.booking.controller.LogicData.LogicFile;
import com.booking.controller.LogicData.LogicJson;
import com.booking.model.Flight;
import com.booking.model.User;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class LogicListFlight {

    LogicFile logicFile = new LogicFile();
    LogicJson logicJson= new LogicJson();

    Scanner sc = new Scanner(System.in);

    public boolean CheckListFlightNull() throws FileNotFoundException {
        List<Flight> flights= logicFile.ConvertFileToFlight();
        if(flights.size()==0){
            return true;
        }
        return false;
    }

    public boolean CheckListFightCodeIsExist(String FlightCode) throws FileNotFoundException {
        List<Flight> flights= logicFile.ConvertFileToFlight();
        if(flights!=null){
            for (Flight flight : flights) {
                if(flight.getFlightCode().equalsIgnoreCase(FlightCode)){
                    return true;
                }
            }
            return false;
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

    public void AddFlight() throws FileNotFoundException {
       // List<Flight> flights= logicFile.ConvertFileToFlight();
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
        //flights.add(flight);
        logicFile.WriteStringJsonToFile(logicJson.ConvertObjectToStringJson(flight),"list_flight.txt");
        System.out.println("Chuyến bay được thêm thành công");
        // sau đó trở về màn hình
        MenuOptionAdmin menuOptionAdmin = new MenuOptionAdmin();
        menuOptionAdmin.MenuOptionAdmin();

    }

    public void CancelFlight() throws FileNotFoundException {
        List<Flight> flights= logicFile.ConvertFileToFlight();
        if(CheckListFlightNull()){
            System.out.println("Danh sách đang rỗng . ");
            //trở về màn hình ...
        }
        else {
            System.out.println("Nhập mã chuyến bay để huỷ : ");
            String code = sc.nextLine();
            int count =0;
            for (Flight flight : flights) {
                if(code.contains(flight.getFlightCode())){
                    flights.remove(flight);
                    logicFile.DeleteFlightInFile(flights);
                    System.out.println("Huỷ chuyến bay thành công !");
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.println("Không tìm thấy chuyến bay phù hợp . ");
            }
            ///trở về màn hình ...
            AddDeleteFlight addDeleteFlight = new AddDeleteFlight();
            addDeleteFlight.AddDeleteFlight();
        }
    }

    public void ShowListFlight() throws FileNotFoundException {
        List<Flight> flights= logicFile.ConvertFileToFlight();
        if(CheckListFlightNull()){
            System.out.println("Danh sách đang rỗng . ");
            //trở về màn hình ...
            AddDeleteFlight addDeleteFlight = new AddDeleteFlight();
            addDeleteFlight.AddDeleteFlight();
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
            MenuOptionAdmin menuOptionAdmin = new MenuOptionAdmin();
            menuOptionAdmin.MenuOptionAdmin();
        }
    }

    public void ChangeFlight() throws FileNotFoundException {
        List<Flight> flights= logicFile.ConvertFileToFlight();
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
                MenuOptionAdmin menuOptionAdmin = new MenuOptionAdmin();
                menuOptionAdmin.MenuOptionAdmin();
            }
            for (Flight flight : flights) {
                // duyệt đến chuyến bay có mã chuyến bay nhập bên trên
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
                }
            }
            logicFile.DeleteFlightInFile(flights);
            System.out.println("Done");
            MenuOptionAdmin menuOptionAdmin = new MenuOptionAdmin();
            menuOptionAdmin.MenuOptionAdmin();
        }
    }

}
