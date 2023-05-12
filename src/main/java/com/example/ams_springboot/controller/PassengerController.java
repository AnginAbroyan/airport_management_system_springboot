package com.example.ams_springboot.controller;



import com.example.ams_springboot.model.Passenger;
import com.example.ams_springboot.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping(path = "passenger/get")
    public List<Passenger> getPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("passenger/get/{passengerId}")
    public Optional<Passenger> getById(@PathVariable("passengerId") Long id){
        return passengerService.getById(id);
    }

    @PostMapping(path = "passenger/register")
    public void registerNewPassenger(@RequestBody Passenger passenger) {
        passengerService.savePassenger(passenger);
    }

    @DeleteMapping(path = "passenger/delete/{passengerId}")
    public void deletePassenger(
            @PathVariable("passengerId") Long passengerId) {
        passengerService.deleteById(passengerId);
    }

    @PutMapping(path = "passenger/update/{passengerId}")
    public void updatePassenger(@PathVariable("passengerId") Long passengerId,
                              @RequestParam(required = false) String passName,
                              @RequestParam(required = false) String passPhone,
                                @RequestParam(required = false) String passCountry,
                                @RequestParam(required = false) String passCity) {
        passengerService.updatePassenger(passengerId, passName, passPhone, passCountry, passCity);
    }
}
