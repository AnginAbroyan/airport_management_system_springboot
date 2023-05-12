package com.example.ams_springboot.service;



import com.example.ams_springboot.model.Company;
import com.example.ams_springboot.model.Trip;
import com.example.ams_springboot.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }


    /**
     * Gets all trips from trip table
     * @return list of trips
     */
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }


    /**
     * Gets a trip from a table by given id.
     * @param id
     * @return
     */

    public Optional<Trip> getById(Long id){
        boolean exists = tripRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Trip with id " + id + " does not exist.");
        }
        return tripRepository.findById(id);
    }

    /**
     * Deletes a Trip by given id
     * @param id
     */

    public void deleteById(Long id){
        boolean exists = tripRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Trip with id " + id + " does not exist.");
        }
        tripRepository.deleteById(id);
    }


    /**
     * saves a new trip into the table
     * @param trip
     */
    public void saveTrip(Trip trip){
        tripRepository.save(trip);
    }


    /**
     * Updates all the fields or only needed fields of a trip
     * @param tripId
     * @param tripOrganizer
     * @param departureCity
     * @param destinationCity
     * @param timeDeparture
     * @param timeArrival
     */
    @Transactional
    public void updateTrip(Long tripId, Company companyId, String tripOrganizer, String departureCity,
                           String  destinationCity, Timestamp timeDeparture, Timestamp timeArrival) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalStateException("Trip with id " + tripId + " does not exist."));
        if (tripOrganizer != null && tripOrganizer.length() > 0  && !Objects.equals(trip.getTripOrganizer(), tripOrganizer)) {
            trip.setTripOrganizer(tripOrganizer);
        }
        if (departureCity != null && departureCity.length() > 0 && !Objects.equals(trip.getDepartureCity(), departureCity)) {
            trip.setDepartureCity(departureCity);
        }
        if (destinationCity != null && destinationCity.length() > 0 && !Objects.equals(trip.getDestinationCity(), destinationCity)) {
            trip.setDestinationCity(destinationCity);
        }
        if (timeDeparture != null  && !Objects.equals(trip.getTimeDeparture(), timeDeparture)) {
            trip.setTimeDeparture(timeDeparture);
        }
        if (timeArrival != null  && !Objects.equals(trip.getTimeArrival(), timeArrival)) {
            trip.setTimeArrival(timeArrival);
        }
        if (companyId != null && !Objects.equals(trip.getCompanyId(), companyId)) {
            trip.setCompanyId(companyId);
        }
    }
}
