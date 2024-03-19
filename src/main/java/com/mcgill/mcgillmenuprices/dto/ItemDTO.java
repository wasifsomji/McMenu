package com.mcgill.mcgillmenuprices.dto;

public class ItemDTO {

      private Long id;
      private String name;
      private String description;
      private Double price;

      private int rating;

      private Long restaurantId;

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

      public int getRating() {
            return rating;
      }

      public void setRating(int rating) {
            this.rating = rating;
      }

      public Long getRestaurantId() {
            return restaurantId;
      }

      public void setRestaurantId(Long restaurantId) {
            this.restaurantId = restaurantId;
      }

}

