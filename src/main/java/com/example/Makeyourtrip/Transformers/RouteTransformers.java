package com.example.Makeyourtrip.Transformers;

import com.example.Makeyourtrip.Models.Routes;
import com.example.Makeyourtrip.RequestDto.AddRouteDto;

public class RouteTransformers {

    public static Routes convertDtoToEntity(AddRouteDto addRouteDto){

        Routes routeObject = Routes.builder().
                        fromCity(addRouteDto.getFromCity())
                        .toCity(addRouteDto.getToCity())
                        .listOfStopInBetween(addRouteDto.getStopsInBetween())
                        .modeOfTransport(addRouteDto.getModeOfTransport())
                        .build();
        return routeObject;



    }
}
