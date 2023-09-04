package com.example.Makeyourtrip.Controllers;

import com.example.Makeyourtrip.RequestDto.AddRouteDto;
import com.example.Makeyourtrip.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/add")
    public String addRoute(@RequestBody AddRouteDto addRouteDto){
        return routeService.addRoutes(addRouteDto);
    }


}
