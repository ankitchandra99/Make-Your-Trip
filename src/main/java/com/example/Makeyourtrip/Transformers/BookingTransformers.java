package com.example.Makeyourtrip.Transformers;

import com.example.Makeyourtrip.Models.Booking;
import com.example.Makeyourtrip.RequestDto.BookingRequest;

public class BookingTransformers {

    public static Booking convertRequestToEntity(BookingRequest bookingRequest){

        Booking bookingObj = Booking.builder().journeyDate(bookingRequest.getJourneyDate())
                .seatNos(bookingRequest.getSeatNos())
                .transportId(bookingRequest.getTransportId())
                .build();

        return bookingObj;
    }
}
