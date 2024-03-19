package com.mcgill.mcgillmenuprices.dto;

import java.util.ArrayList;
import java.util.List;

public class RestaurantResponseDTO {
      private Long id;
      private String name;
      private final List<LocationResponseDTO> locations = new ArrayList<>();
}
