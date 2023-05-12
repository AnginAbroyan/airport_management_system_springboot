package com.example.ams_springboot.model;



import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.sql.Timestamp;
import java.util.Objects;



/**
 * This class represents a persistent class for Company.
 */

@Entity
@Table(name= "trip")
@Proxy(lazy = false)
public class Trip {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", unique = true, nullable = false)
    private int tripId;


    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id",
            insertable = false, updatable = false)
    private Company companyId;


    @Column(name = "trip_organizer")
    private String tripOrganizer;
    @Column(name = "departure_city")
    private String departureCity;
    @Column(name = "destination_city")
    private String destinationCity;
    @Column(name = "time_departure")
    private Timestamp timeDeparture;
    @Column(name = "time_arrival")
    private Timestamp timeArrival;

//    @OneToMany(mappedBy = "trip")
//    @JoinColumn(name = "trip_id")
//    private Set<Pass_in_trip> pass_in_tripSet;



    // Constructor with all members
    public Trip(int tripId, Company companyId, String tripOrganizer, String departureCity,
                String destinationCity, Timestamp timeDeparture, Timestamp timeArrival) {
        this.tripId = tripId;
        this.companyId = companyId;
        this.tripOrganizer = tripOrganizer;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.timeDeparture = timeDeparture;
        this.timeArrival = timeArrival;
    }



    //no-argument constructor
    public Trip(){}


    //getter and setter methods


    public int getTripId() {
        return tripId;
    }
    public void setTripId(int trip_id) {
        this.tripId = trip_id;
    }



    public Company getCompanyId() {
        return companyId;
    }
    public void setCompanyId(Company company_id) {
        this.companyId = company_id;
    }

    public String getTripOrganizer() {
        return tripOrganizer;
    }
    public void setTripOrganizer(String trip_organizer) {
        this.tripOrganizer = trip_organizer;
    }

    public String getDepartureCity() {
        return departureCity;
    }
    public void setDepartureCity(String departure_city) {
        this.departureCity = departure_city;
    }

    public String getDestinationCity() {
        return destinationCity;
    }
    public void setDestinationCity(String destination_city) {
        this.destinationCity = destination_city;
    }

    public Timestamp getTimeDeparture() {
        return timeDeparture;
    }
    public void setTimeDeparture(Timestamp time_departure) {
        this.timeDeparture = time_departure;
    }

    public Timestamp getTimeArrival() {
        return timeArrival;
    }
    public void setTimeArrival(Timestamp time_arrival) {
        this.timeArrival = time_arrival;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "trip_id=" + tripId +
                ", company_id=" + companyId +
                ", trip_organizer='" + tripOrganizer + '\'' +
                ", departure_city='" + departureCity + '\'' +
                ", destination_city='" + destinationCity + '\'' +
                ", time_departure=" + timeDeparture +
                ", time_arrival=" + timeArrival +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return tripId == trip.tripId && companyId == trip.companyId && tripOrganizer.equals(trip.tripOrganizer) && departureCity.equals(trip.departureCity) && destinationCity.equals(trip.destinationCity) && timeDeparture.equals(trip.timeDeparture) && timeArrival.equals(trip.timeArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, companyId, tripOrganizer, departureCity, destinationCity, timeDeparture, timeArrival);
    }
}

