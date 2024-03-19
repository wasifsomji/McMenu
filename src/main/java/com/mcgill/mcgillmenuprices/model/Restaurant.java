package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;
import com.mcgill.mcgillmenuprices.model.Item;

import java.util.ArrayList;
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
      private List<Item> menu = new ArrayList<>();

      public void addMenuItem(Item item) {
            menu.add(item);
            item.setRestaurant(this);
      }

      public void removeMenuItem(Item item) {
            menu.remove(item);
            item.setRestaurant(null);
      }

      @OneToMany(mappedBy = "restaurant", cascade = CascadeType .ALL, orphanRemoval = true)
      private List<Category> categories;

      public Restaurant(Long id, String name, List<Location> locations, List<Item> menu, List<Category> categories) {
            this.id = id;
            this.name = name;
            this.locations = locations;
            this.menu = menu;
            this.categories = categories;
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

}
