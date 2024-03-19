package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(nullable = false)
      private String name;

      @Column(nullable = true, length = 500)
      private String description;

      @Column(nullable = false)
      private Double price;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "restaurant_id")
      private Restaurant restaurant;
}
