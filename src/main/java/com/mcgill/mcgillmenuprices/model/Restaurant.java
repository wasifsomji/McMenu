package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;
import com.mcgill.mcgillmenuprices.model.Item;

import java.util.List;


@Entity
@Table(name = "restaurants")
public class Restaurant {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(nullable = false)
      private String name;

      @ManyToMany
      @JoinTable(
              name = "restaurant_locations",
              joinColumns = @JoinColumn(name = "restaurant_id"),
              inverseJoinColumns = @JoinColumn(name = "location_id")
      )
      private List<Location> locations;

      @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Item> menu;

      @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Category> categories;

      @Column(nullable = false)
      private int rating; // Rating field ranging from 1 to 5

      public Restaurant(Long id, String name, List<Location> locations, List<Item> menu, List<Category> categories, int rating) {
            this.id = id;
            this.name = name;
            this.locations = locations;
            this.menu = menu;
            this.categories = categories;
            this.rating = rating;
      }

      public Restaurant() {

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

      public List<Location> getLocations() {
            return locations;
      }

      public void setLocations(List<Location> locations) {
            this.locations = locations;
      }

      public List<Item> getMenu() {
            return menu;
      }

      public void setMenu(List<Item> menu) {
            this.menu = menu;
      }

      public List<Category> getCategories() {
            return categories;
      }

      public void setCategories(List<Category> categories) {
            this.categories = categories;
      }

      public int getRating() {
            return rating;
      }

      public void setRating(int rating) {
            this.rating = rating;
      }
}
