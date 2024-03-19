package com.mcgill.mcgillmenuprices.controller;

import com.mcgill.mcgillmenuprices.dto.RestaurantResponseDTO;
import com.mcgill.mcgillmenuprices.model.Restaurant;
import com.mcgill.mcgillmenuprices.service.ItemService;
import com.mcgill.mcgillmenuprices.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
      private RestaurantService restaurantService;

      @Autowired
      public RestaurantController(RestaurantService restaurantService) {
            this.restaurantService = restaurantService;
      }

      @GetMapping
      public ResponseEntity<RestaurantResponseDTO> getRestaurantByName(String restaurantName) {
            RestaurantResponseDTO restaurant = restaurantService.getRestaurantByName(restaurantName);
            return ResponseEntity.ok(restaurant);
      }
}
