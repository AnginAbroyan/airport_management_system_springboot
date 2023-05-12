package com.example.ams_springboot.repository;


import com.example.ams_springboot.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{

//    @Query("SELECT t FROM Trip t where t.tripId = ?1")
//    Optional<Trip> findTripByTripId(Long tripId);
}