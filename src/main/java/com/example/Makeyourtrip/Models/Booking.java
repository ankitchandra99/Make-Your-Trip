package com.example.Makeyourtrip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//This will keep a record of already booked seats on a particular Date
//of a particular transportId
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    private String seatNos; //Comma seperated Values : 1A,1C,1E

    private LocalDate journeyDate;

    private Integer transportId;

    @ManyToOne
    @JoinColumn
    private Transport transport;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private TicketEntity ticketEntity;


    @ManyToOne
    @JoinColumn
    private User user;
}
