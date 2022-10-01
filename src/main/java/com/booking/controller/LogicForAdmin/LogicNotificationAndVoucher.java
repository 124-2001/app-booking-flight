package com.booking.controller.LogicForAdmin;

import com.booking.View.ViewForAdmin.NotificationVoucherFlight;
import com.booking.controller.LogicAccount.Account;
import com.booking.controller.LogicData.LogicFile;
import com.booking.controller.LogicData.LogicJson;
import com.booking.model.Flight;
import com.booking.model.User;
import com.booking.model.Voucher;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LogicNotificationAndVoucher {

    LogicJson logicJson = new LogicJson();
    LogicFile logicFile = new LogicFile();

    Scanner sc = new Scanner(System.in);
    Account account= new Account();

    //NOTIFICATION
    public void SendNotificationCancelFlight(String email) throws FileNotFoundException {
        //clone list user
        List<User> users= logicFile.ConvertFileToUser();
        //kiểm tra email tồn tại thì gửi
        if(account.CheckEmailIsExist(email)){
            System.out.println("Người dùng không tồn tại .");
            //trở về màn hình
            NotificationVoucherFlight notificationVoucherFlight = new NotificationVoucherFlight();
            notificationVoucherFlight.ViewNotificationVoucher();
        }
        else {
            for (User user : users) {
                if(user.getEmail().equalsIgnoreCase(email)){
                    System.out.println("Nhập thông báo cho người dùng : ");
                    String notification = sc.nextLine();
                    user.setNotification(notification);
                    logicFile.DeleteUserInFile(users);
                    System.out.println("Thêm thông báo thành công");
                }
            }
            NotificationVoucherFlight notificationVoucherFlight = new NotificationVoucherFlight();
            notificationVoucherFlight.ViewNotificationVoucher();
        }
    }
    //VOUCHER
    List<Voucher> vouchers = new ArrayList<>();

    public String RandomVoucher(){
        String str ="ABCDEFGHYJKQMNL123456789";
        String randomcode = "";
        Random random = new Random();
        for (int i =0;i<12;i++){
            int n =random.nextInt(str.length());
            randomcode+=str.charAt(n);
        }
        return randomcode;
    }

    public boolean CheckVoucherIsExist(String random){
        for (Voucher voucher : vouchers) {
            if(voucher.getVoucherCode().equalsIgnoreCase(random)){
                return true;
            }
        }
        return false;
    }

    public void AddVoucher() throws FileNotFoundException {
        //List<Voucher> vouchers= logicFile.ConvertFileToVoucher();
        Voucher voucher = new Voucher();
        Scanner sc = new Scanner(System.in);
        String randomCode = RandomVoucher();
        while (CheckVoucherIsExist(randomCode)){
            randomCode=RandomVoucher();
        }
        voucher.setVoucherCode(randomCode);
        System.out.print("Nhập giá trị mã voucher "+randomCode+"( % ) : ");
        int value = sc.nextInt();
        voucher.setValueVoucher(value);
        logicFile.WriteStringJsonToFile(logicJson.ConvertObjectToStringJson(voucher),"List_voucher.txt");
        vouchers.add(voucher);
        System.out.println("Tạo mã voucher thành công !");
        //trở về màn hình ...
        NotificationVoucherFlight notificationVoucherFlight = new NotificationVoucherFlight();
        notificationVoucherFlight.ViewNotificationVoucher();
    }
    public void VoucherPayment(Flight flight, Voucher voucher){
        if(CheckVoucherIsExist(voucher.getVoucherCode())){
            flight.setPrice(flight.getPrice()*((100-voucher.getValueVoucher())/100));
        }
    }
}
