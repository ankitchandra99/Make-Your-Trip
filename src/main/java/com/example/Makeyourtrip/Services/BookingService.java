package com.example.Makeyourtrip.Services;

import com.example.Makeyourtrip.Models.*;
import com.example.Makeyourtrip.Repositories.BookingRepository;
import com.example.Makeyourtrip.Repositories.TransportRepository;
import com.example.Makeyourtrip.Repositories.UserRepository;
import com.example.Makeyourtrip.RequestDto.BookingRequest;
import com.example.Makeyourtrip.RequestDto.GetAvailableSeatsDto;
import com.example.Makeyourtrip.ResponseDtos.AvailableSeatResponseDto;
import com.example.Makeyourtrip.Transformers.BookingTransformers;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private UserRepository userRepository;

    public List<AvailableSeatResponseDto> getAvailableSeatsResponse(GetAvailableSeatsDto entryDto){

        List<Booking> doneBookings = bookingRepository.findByJourneyDateAndTransportId(entryDto.getJourneyDate(),entryDto.getTransportId());
        Set<String> bookedSeats = new TreeSet<>();
        for(Booking booking:doneBookings){
            String str = booking.getSeatNos(); //1E,2E,3B,4B
            String[] bookedSeatsInThatBooking = str.split(",");

            for(String seatNo : bookedSeatsInThatBooking){
                bookedSeats.add(seatNo);
            }
        }

        Transport transport = transportRepository.findById(entryDto.getTransportId()).get();
        List<Seat> seatList = transport.getSeatList();
        //Total seats - Booked Seats :
        List<AvailableSeatResponseDto> finalAvailableSeats = new ArrayList<>();
        for(Seat seat : seatList){

            if(bookedSeats.contains(seat.getSeatNo())){
               continue;
            }
            else{
                //We will be building that response object
                AvailableSeatResponseDto availableSeat  = AvailableSeatResponseDto.builder()
                                            .seatPrice(seat.getPrice())
                        .seatType(seat.getSeatType())
                        .seatNo(seat.getSeatNo())
                        .build();

                finalAvailableSeats.add(availableSeat);
            }
        }
        return finalAvailableSeats;
    }


    public ResponseEntity makeABooking(BookingRequest bookingRequest){
        Optional<User> optionalUser = userRepository.findById(bookingRequest.getUserId());
        if(optionalUser.isEmpty()){
            return new ResponseEntity(" User Not Available",HttpStatus.BAD_REQUEST);
        }

        Transport transportobj = transportRepository.findById(bookingRequest.getTransportId()).get();

        Booking booking = BookingTransformers.convertRequestToEntity(bookingRequest);

        TicketEntity ticketEntity = createTicketEntity(transportobj,bookingRequest);

        ///Setting up the Foreign keys
        booking.setTransport(transportobj);
        booking.setUser( optionalUser.get());
        booking.setTicketEntity(ticketEntity);


        ///now we will set the bidirectional mappings
        ///setting the booking object in transport
        ticketEntity.setBooking(booking);

        ///adding booking object in booking list in trasport
        transportobj.getBookings().add(booking);

        ///now we will add booking object in userobject
        optionalUser.get().getBookingList().add(booking);

        ///we will have to save it also ..but how..?

        bookingRepository.save(booking);

        return new ResponseEntity("booking has been done Successfully", HttpStatus.OK);

    }


    private TicketEntity createTicketEntity(Transport transport,BookingRequest bookingRequest){

        Integer totalPricePaid = findTotalPricePaid(transport,bookingRequest.getSeatNos());
        String routeDetails = getRouteDetails(transport);

        TicketEntity ticketEntity = TicketEntity.builder().allSeatNos(bookingRequest.getSeatNos())
                .journeyDate(bookingRequest.getJourneyDate())
                .startTime(transport.getStartTime())
                .routeDetails(routeDetails)
                .totalCostPaid(totalPricePaid)
                .build();

        return ticketEntity;
    }

    private String getRouteDetails(Transport transport){

        //"DELHI TO BANGALORE"
        Routes routes = transport.getRoute();
        String result = routes.getFromCity() + " TO "+routes.getToCity();
        return result;

    }

    private Integer findTotalPricePaid(Transport transport,String seatNos){
         Double totalPrice=0.0;
         List<Seat> seatList=transport.getSeatList();
         String []arr=seatNos.split(",");
         for(int i=0;i<arr.length;i++){

         }
        //TODO Function to find the total price for all
        //INTERESTING : PLEASE TRY THIS
        return 0;
    }




}

