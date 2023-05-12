package com.example.ams_springboot.service;

import com.example.ams_springboot.model.Passenger;
import com.example.ams_springboot.model.Trip;
import com.example.ams_springboot.repository.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    /**
     * Gets all passengers from passenger table
     * @return list of passengers
     */
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }


    /**
     * Gets a passenger from a table by given id.
     * @param id
     * @return
     */

    public Optional<Passenger> getById(Long id){
        boolean exists = passengerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Passenger with id " + id + " does not exist.");
        }
        return passengerRepository.findById(id);
    }

    /**
     * Deletes a passenger by given id
     * @param id
     */

    public void deleteById(Long id){
        boolean exists = passengerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Passenger with id " + id + " does not exist.");
        }
        passengerRepository.deleteById(id);
    }


    /**
     * saves a new passenger into the table
     * @param passenger
     */
    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }





    /**
     * Updates all the fields or only needed fields of a passenger
     * @param passengerId
     * @param passengerName
     * @param passPhone
     * @param passCountry
     * @param passCity
     */
    @Transactional
    public void updatePassenger(Long passengerId, String passengerName, String passPhone,
                                String passCountry, String passCity) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new IllegalStateException("Passenger with id " + passengerId + " does not exist."));
        if (passengerName != null && passengerName.length() > 0 && !Objects.equals(passenger.getPassengerName(), passengerName)) {
            passenger.setPassengerName(passengerName);
        }
        if (passPhone != null && passPhone.length() > 0 && !Objects.equals(passenger.getPassPhone(), passPhone)) {
            Optional<Passenger> passengerOptional = passengerRepository
                    .findPassengerByPass_phone(passPhone);
            if (passengerOptional.isPresent()) {
                throw new IllegalStateException("Phone number already exists.");
            }
            passenger.setPassPhone(passPhone);
        }
        if (passCountry != null && passCountry.length() > 0 && !Objects.equals(passenger.getPassCountry(), passCountry)) {
            passenger.setPassCountry(passCountry);
        }
        if (passCity != null && passCity.length() > 0 && !Objects.equals(passenger.getPassCity(), passCity)) {
            passenger.setPassCity(passCity);
        }
    }


    public void registerTrip(Long tripId, Passenger passenger, String place, Date date) {

    }

}
