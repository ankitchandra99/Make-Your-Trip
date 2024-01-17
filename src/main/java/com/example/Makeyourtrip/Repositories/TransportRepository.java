package com.example.Makeyourtrip.Repositories;

import com.example.Makeyourtrip.Models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransportRepository extends JpaRepository<Transport,Integer> {
    Optional<Transport> findByTransportId(Integer transportId);
}
