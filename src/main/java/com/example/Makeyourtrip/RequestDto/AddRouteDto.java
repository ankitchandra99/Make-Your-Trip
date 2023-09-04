package com.example.Makeyourtrip.RequestDto;

import com.example.Makeyourtrip.Enums.City;
import com.example.Makeyourtrip.Enums.ModeOfTransport;
import lombok.Data;

@Data
public class AddRouteDto {

    private City fromCity;
    private City  toCity;
    private String stopsInBetween;
    private ModeOfTransport modeOfTransport;
}
