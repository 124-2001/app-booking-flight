package com.booking.controller.LogicForUser;

import com.booking.controller.LogicData.LogicFile;
import com.booking.model.Flight;
import com.booking.model.Booking;
import com.booking.model.Voucher;
import static com.booking.View.ViewMain.SignIn.signedIn;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class LogicListFlight {

    LogicFile logicFile = new LogicFile();
    List<Flight> flights;
    {
        try {
            flights = logicFile.ConvertFileToFlight();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    } // Convert file to list
    List<Voucher> vouchers;
    {
        try {
            vouchers = logicFile.ConvertFileToVoucher();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    } // Convert file to list
    List<Booking> bookings;
    {
        try {
            bookings = logicFile.ConvertFileToBooking();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    } // Convert file to list

    public ArrayList<Flight> SearchFlight(String fromPlace, String toPlace, String dateString) {
        Calendar dateCal = DateAnalysis.dateToCal(dateString);
        ArrayList<Flight> matchedFlights = new ArrayList<>();
        for (Flight temp: flights) {
            boolean b = temp.getFromPlace().equalsIgnoreCase(fromPlace)
                    && temp.getToPlace().equalsIgnoreCase(toPlace)
                    && temp.getTime().get(Calendar.YEAR) == dateCal.get(Calendar.YEAR)
                    && temp.getTime().get(Calendar.MONTH) == dateCal.get(Calendar.MONTH)
                    && temp.getTime().get(Calendar.DATE) == dateCal.get(Calendar.DATE);
            if (b) matchedFlights.add(temp);
        }
        return matchedFlights;
    }
    public String generateBookingCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randomised = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            int n = random.nextInt(characters.length());
            randomised+=characters.charAt(n-1);
        }
        return randomised;
    }
    public void selectFlight(Flight selFlight, int noSeats, Voucher selVoucher) {
        long discountedPrice = pricePostVoucher(selFlight.getPrice(),selVoucher.getValueVoucher());
        String bookingCode = generateBookingCode();
        Booking booked = new Booking(selFlight.getFlightCode(),selFlight.getFlightName(),
                selFlight.getFromPlace(),selFlight.getToPlace(),selFlight.getTime(),discountedPrice,
                selFlight.getNumberOfSeats(),signedIn.getEmail(),selVoucher.getVoucherCode(),
                bookingCode);
        bookings.add(booked);
    }
    public Flight verifyFlight(ArrayList<Flight> filteredFlights, String flightCode) {
        for (Flight temp: filteredFlights)
            if (temp.getFlightCode().equals(flightCode.toUpperCase()))
                return temp;
        return null;
    }
    public Voucher verifyVoucher(String voucherCode) {
        for (Voucher temp: vouchers)
            if (temp.getVoucherCode().equals(voucherCode.toUpperCase())) {
                return temp;
            }
        return null;
    }
    public long pricePostVoucher(long price,int discount) {
        return price * (1-discount/100);
    }
    public boolean cancelFlight(String bookingCode) {
        for (Booking temp: bookings)
            if (temp.getCodeBooking().equals(bookingCode.toUpperCase())) {
                bookings.remove(temp);
                return true;
            }
        return false;
    }
}
