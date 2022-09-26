package com.booking.model;

import java.util.Date;

public class Flight {

    private String flightCode;
    private String flightName;
    private String fromPlace;
    private String toPlace;
    private long price;
    private int  numberOfSeats;

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

/*    private int flightId;
    private String flightCode;
    private String fightName;
    private String fromPlace;
    private String toPlace;
    private Date startTimePlan;
    private Date endTimePlan;
    private Date totalSeat;*/

}
