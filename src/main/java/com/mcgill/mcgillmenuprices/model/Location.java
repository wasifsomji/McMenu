package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @ManyToMany(mappedBy = "restaurant_locations")
      private List<Restaurant> restaurants = new ArrayList<>();

      @Column(nullable = false)
      private String name;

      @Column(nullable = false)
      private String address; // The address of the food place

      private double latitude; // The latitude for Google Maps
      private double longitude; // The longitude for Google Maps

      public Location(String name, String address, double latitude, double longitude) {
            this.name = name;
            this.address = address;
            this.latitude = latitude;
            this.longitude = longitude;
      }

      public Location() {

      }


      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getAddress() {
            return address;
      }

      public void setAddress(String address) {
            this.address = address;
      }

      public double getLatitude() {
            return latitude;
      }

      public void setLatitude(double latitude) {
            this.latitude = latitude;
      }

      public double getLongitude() {
            return longitude;
      }

      public void setLongitude(double longitude) {
            this.longitude = longitude;
      }

      // Getters and setters...
      public List<Restaurant> getRestaurants() {
            return restaurants;
      }

      public void setRestaurants(List<Restaurant> restaurants) {
            this.restaurants = restaurants;
      }
}
