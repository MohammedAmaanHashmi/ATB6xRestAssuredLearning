package com.thetestingacademy.ex_27062024.gson.serialization;

public class BookingResponse {
    private Integer bookingId;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    private Booking booking;

}
