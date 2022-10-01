package com.booking.model;

public class Booking extends Flight {
    private String userEmail;
    private String flightCode;
    private int voucherCode;
    private String codeBooking; //

    private int codeVoucher;

    private String notification;

    public Booking() {
    }

    public Booking(String userEmail, String flightCode, int voucherCode) {
        this.userEmail = userEmail;
        this.flightCode = flightCode;
        this.voucherCode = voucherCode;
    }

    public Booking(String userEmail, String flightCode, int voucherCode, String notification) {
        this.userEmail = userEmail;
        this.flightCode = flightCode;
        this.voucherCode = voucherCode;
        this.notification = notification;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public int getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(int voucherCode) {
        this.voucherCode = voucherCode;
    }
    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public void sendNotification() {
        System.out.println("");
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
