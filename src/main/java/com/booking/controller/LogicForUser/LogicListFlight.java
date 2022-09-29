package com.booking.controller.LogicForUser;

import com.booking.model.Flight;

import java.util.ArrayList;
import java.util.Calendar;

public class LogicListFlight {
    ArrayList<Flight> flights = new ArrayList<>();
    public void SearchFlight(String fromPlace, String toPlace, int date, int month, int year) {
        for (Flight temp: flights) {
            boolean b = temp.getFromPlace().equalsIgnoreCase(fromPlace)
                    && temp.getToPlace().equalsIgnoreCase(toPlace);

        }
    } // unfinished
}
