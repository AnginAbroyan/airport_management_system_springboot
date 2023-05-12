package com.example.ams_springboot.controller;


import com.example.ams_springboot.model.Company;
import com.example.ams_springboot.model.Trip;
import com.example.ams_springboot.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/v1")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(path = "trip/get")
    public List<Trip> getTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("trip/get/{tripId}")
    public Optional<Trip> getById(@PathVariable("tripId") Long id) {
        return tripService.getById(id);
    }

    @PostMapping(path = "trip/register")
    public void registerNewTrip(@RequestBody Trip trip) {
        tripService.saveTrip(trip);
    }

    @DeleteMapping(path = "trip/delete/{tripId}")
    public void deleteTrip(
            @PathVariable("tripId") Long tripId) {
        tripService.deleteById(tripId);
    }

    @PutMapping(path = "trip/update/{tripId}")
    public void updateTrip(@PathVariable("tripId") Long tripId,
                           @RequestParam(required = false) Company companyId,
                           @RequestParam(required = false) String tripOrganizer,
                           @RequestParam(required = false) String departureCity,
                           @RequestParam(required = false) String destinationCity,
                           @RequestParam(required = false) Timestamp timeDeparture,
                           @RequestParam(required = false) Timestamp timeArrival) {
        tripService.updateTrip(tripId, companyId, tripOrganizer, departureCity, destinationCity, timeDeparture, timeArrival);
    }
}
