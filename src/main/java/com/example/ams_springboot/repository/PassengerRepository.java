package com.example.ams_springboot.repository;


import com.example.ams_springboot.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

    @Query("SELECT p FROM Passenger p where p.passPhone = ?1")
    Optional<Passenger> findPassengerByPass_phone(String passPhone);
}