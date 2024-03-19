package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

      public enum MealType {
            BREAKFAST,
            LUNCH,
            DINNER,
            DESSERT,
            SNACK
      }
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(nullable = false)
      private String name;

      @Column(nullable = true, length = 500)
      private String description;

      @Column(nullable = false)
      private Double price;

      @Enumerated(EnumType.STRING)
      private MealType mealType;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "restaurant_id")
      private Restaurant restaurant;
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "category_id")
      private Category category;

      public Item(Long id, String name, String description, Double price, MealType mealType, Restaurant restaurant, Category category) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.mealType = mealType;
            this.restaurant = restaurant;
            this.category = category;
      }

      public Item() {

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

      public String getDescription() {
            return description;
      }

      public void setDescription(String description) {
            this.description = description;
      }

      public Double getPrice() {
            return price;
      }

      public void setPrice(Double price) {
            this.price = price;
      }

      public Restaurant getRestaurant() {
            return restaurant;
      }

      public void setRestaurant(Restaurant restaurant) {
            this.restaurant = restaurant;
      }

      public Category getCategory() {
            return category;
      }

      public void setCategory(Category category) {
            this.category = category;
      }

      public MealType getMealType() {
            return mealType;
      }

      public void setMealType(MealType mealType) {
            this.mealType = mealType;
      }

}
