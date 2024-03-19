package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(nullable = false)
      private String name;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "restaurant_id")
      private Restaurant restaurant;

      @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Item> items;

      public Category(Long id, String name, Restaurant restaurant, List<Item> items) {
            this.id = id;
            this.name = name;
            this.restaurant = restaurant;
            this.items = items;
      }

      public Category() {
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

      public Restaurant getRestaurant() {
            return restaurant;
      }

      public void setRestaurant(Restaurant restaurant) {
            this.restaurant = restaurant;
      }

      public List<Item> getItems() {
            return items;
      }

      public void setItems(List<Item> items) {
            this.items = items;
      }
}
