package com.mcgill.mcgillmenuprices.dto;

public class RatingDTO {
      private Long itemId; // Set this if the rating is for an item
      private Long restaurantId; // Set this if the rating is for a restaurant
      private Integer rating;
      private String raterIdentifier; // Optional: Consider privacy implications

      public Long getItemId() {
            return itemId;
      }

      public void setItemId(Long itemId) {
            this.itemId = itemId;
      }

      public Long getRestaurantId() {
            return restaurantId;
      }

      public void setRestaurantId(Long restaurantId) {
            this.restaurantId = restaurantId;
      }

      public Integer getRating() {
            return rating;
      }

      public void setRating(Integer rating) {
            this.rating = rating;
      }

      public String getRaterIdentifier() {
            return raterIdentifier;
      }

      public void setRaterIdentifier(String raterIdentifier) {
            this.raterIdentifier = raterIdentifier;
      }
}
