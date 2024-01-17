package com.example.Makeyourtrip.Models;


import com.example.Makeyourtrip.Enums.City;
import com.example.Makeyourtrip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Routes {

    @Id//primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    @Enumerated(value = EnumType.STRING)
    private City fromCity;

    @Enumerated(value = EnumType.STRING)
    private City toCity;

    private String listOfStopInBetween;

    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<Transport> transportList = new ArrayList<>();

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public void setListOfStopInBetween(String listOfStopInBetween) {
        this.listOfStopInBetween = listOfStopInBetween;
    }

    public void setModeOfTransport(ModeOfTransport modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public void setTransportList(List<Transport> transportList) {
        this.transportList = transportList;
    }

    public Routes(City fromCity, City toCity, String listOfStopInBetween, ModeOfTransport modeOfTransport) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.listOfStopInBetween = listOfStopInBetween;
        this.modeOfTransport = modeOfTransport;
    }
}
