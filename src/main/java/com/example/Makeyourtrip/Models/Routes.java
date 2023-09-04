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

    @Id
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


}
