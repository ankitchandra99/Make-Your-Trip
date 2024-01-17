package com.example.Makeyourtrip.controllers;

import com.example.Makeyourtrip.Controllers.BookingControllers;
import com.example.Makeyourtrip.RequestDto.BookingRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
@ComponentScan(basePackages = "com.example.Makeyourtrip.Controllers")
public class BookingControllerTest {

    @Autowired
    BookingControllers bookingControllers;

    @Test

    public void testBookFlight() {
        BookingRequest bookingRequest = new BookingRequest();
        ResponseEntity responseEntity = bookingControllers.bookFlight(bookingRequest);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

    }

}
