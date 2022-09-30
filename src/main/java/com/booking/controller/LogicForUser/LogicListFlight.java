package com.booking.controller.LogicForUser;

import com.booking.model.Flight;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;

public class LogicListFlight {
    ArrayList<Flight> flights = new ArrayList<>();
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
    public Flight confirmFlight(@NotNull ArrayList<Flight> filteredFlights, String flightCode) {
        for (Flight temp: filteredFlights)
            if (temp.getFlightCode().equals(flightCode.toUpperCase())) {
                return temp;
            }
        return null;
    }
}
