package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @ManyToOne
      @JoinColumn(name = "food_id", nullable = false)
      private Item foodItem;

      @ManyToOne
      @JoinColumn(name = "restaurant_id", nullable = false)
      private Restaurant restaurant;

      private Integer rating; // Assuming a rating scale of 1-5

      // Consider adding a unique identifier for the rater, such as a MAC address or a session ID
      private String raterIdentifier;

}
