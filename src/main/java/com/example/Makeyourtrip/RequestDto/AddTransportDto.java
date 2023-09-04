package com.example.Makeyourtrip.RequestDto;

import com.example.Makeyourtrip.Enums.ModeOfTransport;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddTransportDto {

    private ModeOfTransport modeOfTransport;
    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyTime;
    private Integer routeId;
    private String companyName;

}
