package com.mcgill.mcgillmenuprices.controller;

import com.mcgill.mcgillmenuprices.dto.LocationResponseDTO;
import com.mcgill.mcgillmenuprices.dto.RestaurantResponseDTO;
import com.mcgill.mcgillmenuprices.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

      @Autowired
      private MockMvc mockMvc;

      @MockBean
      private RestaurantService restaurantService;

      // Example test for getRestaurantByName
      @Test
      @WithMockUser
      public void getRestaurantByNameTest() throws Exception {
            // Given
            String restaurantName = "McGill's Diner";
            Long restaurantId = 1L;

            RestaurantResponseDTO mockRestaurantDTO = new RestaurantResponseDTO();
            mockRestaurantDTO.setId(restaurantId);
            mockRestaurantDTO.setName(restaurantName);

            // Assuming LocationResponseDTO has properties like id, name, address etc., set a mock location as well
            LocationResponseDTO mockLocation = new LocationResponseDTO();
            // mockLocation.setId(...); // set additional properties as needed
            mockRestaurantDTO.getLocations().add(mockLocation);

            given(restaurantService.getRestaurantByName(restaurantName)).willReturn(mockRestaurantDTO);

            // When & Then
            mockMvc.perform(get("/restaurants/name")
                            .param("restaurantName", restaurantName)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value(restaurantName))
                    .andExpect(jsonPath("$.id").value(restaurantId))
                    .andExpect(jsonPath("$.locations").isArray())
                    .andExpect(jsonPath("$.locations[0]").isMap()); // Add more assertions if necessary

            // Verify the interaction with the service
            verify(restaurantService).getRestaurantByName(restaurantName);
      }

      // Other tests for the controller...
}
