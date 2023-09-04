package com.example.Makeyourtrip.Repositories;

import com.example.Makeyourtrip.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
