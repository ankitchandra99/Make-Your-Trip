package com.example.Makeyourtrip.Controllers;

import com.example.Makeyourtrip.RequestDto.BookingRequest;
import com.example.Makeyourtrip.RequestDto.GetAvailableSeatsDto;
import com.example.Makeyourtrip.ResponseDtos.AvailableSeatResponseDto;
import com.example.Makeyourtrip.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingControllers {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookFlight")
    public ResponseEntity bookFlight(@RequestBody BookingRequest bookingRequest){

        return bookingService.makeABooking(bookingRequest);
    }

    @GetMapping("/getAvailableSeats")
    public ResponseEntity getAvailableSeats(@RequestBody GetAvailableSeatsDto getAvailableSeatsDto){

        List<AvailableSeatResponseDto> result = bookingService.getAvailableSeatsResponse(getAvailableSeatsDto);
        return new ResponseEntity(result, HttpStatus.OK);

    }





}
