package com.booking.model;

public class Booking extends Flight {
    private String codeBooking; //

    private int codeVoucher;

    private String notification;


    public void SendNotification(){
        System.out.println(notification);
    }
    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public int getCodeVoucher() {
        return codeVoucher;
    }

    public void setCodeVoucher(int codeVoucher) {
        this.codeVoucher = codeVoucher;
    }
}
