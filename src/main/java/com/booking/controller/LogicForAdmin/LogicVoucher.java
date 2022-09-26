package com.booking.controller.LogicForAdmin;

import com.booking.model.Voucher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LogicVoucher {
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

    public void AddVoucher(){
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
        vouchers.add(voucher);
        System.out.println("Tạo mã voucher thành công !");
        //trở về màn hình ...
    }
}
