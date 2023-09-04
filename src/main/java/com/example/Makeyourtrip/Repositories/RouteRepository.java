package com.example.Makeyourtrip.Repositories;

import com.example.Makeyourtrip.Enums.City;
import com.example.Makeyourtrip.Enums.ModeOfTransport;
import com.example.Makeyourtrip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Routes,Integer> {

    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(City fromCity, City toCity, ModeOfTransport modeOfTransport);
}
