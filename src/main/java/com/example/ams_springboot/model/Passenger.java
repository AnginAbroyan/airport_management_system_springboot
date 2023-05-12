package com.example.ams_springboot.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name= "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long passengerId;


    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "pass_phone")
    private String passPhone;

    @Column(name = "pass_country")
    private String passCountry;

    @Column(name = "pass_city")
    private String passCity;


//    @OneToMany(mappedBy = "passenger")
//    @JoinColumn(name = "passenger_id")
//    private Set<Pass_in_trip> pass_in_tripSet;

    public Passenger(Long passengerId, String passengerName, String passPhone, String passCountry, String passCity) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passPhone = passPhone;
        this.passCountry = passCountry;
        this.passCity = passCity;
    }

    public Passenger() {
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passenger_id) {
        this.passengerId = passenger_id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passenger_name) {
        this.passengerName = passenger_name;
    }

    public String getPassPhone() {
        return passPhone;
    }

    public void setPassPhone(String pass_phone) {
        this.passPhone = pass_phone;
    }

    public String getPassCountry() {
        return passCountry;
    }

    public void setPassCountry(String pass_country) {
        this.passCountry = pass_country;
    }

    public String getPassCity() {
        return passCity;
    }

    public void setPassCity(String pass_city) {
        this.passCity = pass_city;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passenger_id=" + passengerId +
                ", passenger_name='" + passengerName + '\'' +
                ", pass_phone='" + passPhone + '\'' +
                ", pass_country='" + passCountry + '\'' +
                ", pass_city='" + passCity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return passengerId.equals(passenger.passengerId) && passengerName.equals(passenger.passengerName) && passPhone.equals(passenger.passPhone) && passCountry.equals(passenger.passCountry) && passCity.equals(passenger.passCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, passengerName, passPhone, passCountry, passCity);
    }
}

