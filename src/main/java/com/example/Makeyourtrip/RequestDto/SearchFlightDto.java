package com.example.Makeyourtrip.RequestDto;

import com.example.Makeyourtrip.Enums.City;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchFlightDto {

    private City fromCity;
    private City toCity;
    private LocalDate journeyDate;

}
