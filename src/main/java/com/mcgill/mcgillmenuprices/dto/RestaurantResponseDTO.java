package com.mcgill.mcgillmenuprices.dto;

import java.util.ArrayList;
import java.util.List;

public class RestaurantResponseDTO {
      private Long id;
      private String name;
      private final List<LocationResponseDTO> locations = new ArrayList<>();

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

      public List<LocationResponseDTO> getLocations() {
            return locations;
      }
}
