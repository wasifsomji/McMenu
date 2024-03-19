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

      @Column(nullable = false)
      private String location;

      @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Item> menu;

      @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Category> categories;

      public Restaurant(Long id, String name, String location, List<Item> menu, List<Category> categories) {
            this.id = id;
            this.name = name;
            this.location = location;
            this.menu = menu;
            this.categories = categories;
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

      public String getLocation() {
            return location;
      }

      public void setLocation(String location) {
            this.location = location;
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
