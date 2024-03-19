package com.mcgill.mcgillmenuprices.service;

import com.mcgill.mcgillmenuprices.dto.RestaurantResponseDTO;
import com.mcgill.mcgillmenuprices.model.Restaurant;
import com.mcgill.mcgillmenuprices.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
      private final RestaurantRepository restaurantRepository;
      private final ModelMapper modelMapper;

      @Autowired
      public RestaurantService(RestaurantRepository restaurantRepository, ModelMapper modelMapper) {
            this.restaurantRepository = restaurantRepository;
            this.modelMapper = modelMapper;
      }

      public RestaurantResponseDTO getRestaurantByName(String name) {
            Restaurant restaurant = restaurantRepository.findByName(name);
            if (restaurant != null) {
                  return modelMapper.map(restaurant, RestaurantResponseDTO.class);
            } else {
                  // Handle the case where the restaurant is not found, e.g., throw an exception or return null
                  throw new EntityNotFoundException("Restaurant with name " + name + " not found");
            }
      }
}
