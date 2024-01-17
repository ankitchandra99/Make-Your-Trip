package com.example.Makeyourtrip.Repositories;

import com.example.Makeyourtrip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

  /*  @Query(value = "select * from bookings where journey_date =:journeyDateInput and transport_id =:transportIdInput",nativeQuery = true)
    List<Booking> findBookings(LocalDate journeyDateInput, Integer transportIdInput);*/

    List<Booking> findByJourneyDateAndTransportId(LocalDate journeyDateInput, Integer transportIdInput);
}
