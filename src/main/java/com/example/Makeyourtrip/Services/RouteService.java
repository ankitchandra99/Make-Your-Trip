package com.example.Makeyourtrip.Services;

import com.example.Makeyourtrip.Models.Routes;
import com.example.Makeyourtrip.Repositories.RouteRepository;
import com.example.Makeyourtrip.RequestDto.AddRouteDto;
import com.example.Makeyourtrip.Transformers.RouteTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public String addRoutes(AddRouteDto addRouteDto){
//        Routes route = new Routes();
        Routes routeObj = RouteTransformers.convertDtoToEntity(addRouteDto);
        routeRepository.save(routeObj);
        return "Routes has been successfully added to DB. ";
    }


}
