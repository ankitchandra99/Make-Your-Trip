package com.example.Makeyourtrip.Services;

import com.example.Makeyourtrip.Enums.ModeOfTransport;
import com.example.Makeyourtrip.Exceptions.RouteNotFoundException;
import com.example.Makeyourtrip.Models.Routes;
import com.example.Makeyourtrip.Models.Transport;
import com.example.Makeyourtrip.Repositories.RouteRepository;
import com.example.Makeyourtrip.Repositories.TransportRepository;
import com.example.Makeyourtrip.RequestDto.AddTransportDto;
import com.example.Makeyourtrip.RequestDto.SearchFlightDto;
import com.example.Makeyourtrip.ResponseDtos.FlightResult;
import com.example.Makeyourtrip.Transformers.TransportTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private RouteRepository routeRepository;


    public String addTransport(AddTransportDto addTransportDto)throws Exception{

        Transport transportObj = TransportTransformer.convertDtoToEntity(addTransportDto);
        Optional<Routes> optionalRoutes = routeRepository.findById(addTransportDto.getRouteId());
        if(!optionalRoutes.isPresent())
            throw new RouteNotFoundException("Route Id is incorrect");

        Routes route = optionalRoutes.get();
        //FK column that we are setting
        transportObj.setRoute(route);
        //Bidirectional mapping also needs to be taken care of
        route.getTransportList().add(transportObj);

        //Bcz of bidirectional mapping I am only saving the parent entity
        //And child will get automatically saved
        routeRepository.save(route);
        return "Transport has been added successfully";
    }

    public List<FlightResult> searchForFlights(SearchFlightDto searchFlightDto){

    List<Routes> routes = routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlightDto.getFromCity(),searchFlightDto.getToCity(), ModeOfTransport.FLIGHT);


    List<FlightResult> flightResults = new ArrayList<>();

    for(Routes route : routes){

        List<Transport> transportList = route.getTransportList();

        for(Transport transport:transportList){
            //date filter
            if(transport.getJourneyDate().equals(searchFlightDto.getJourneyDate())){
                FlightResult result = TransportTransformer.convertEntityToFlightResult(transport);
                result.setListOfStopInBetween(route.getListOfStopInBetween());
                flightResults.add(result);
            }
        }
    }
        return flightResults;
    }
}
