package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(nullable = false)
      private String name;

      // Add more fields as needed, such as latitude, longitude, etc.

      // Constructors, getters, setters
}
