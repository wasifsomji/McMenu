package com.mcgill.mcgillmenuprices.controller;

import com.mcgill.mcgillmenuprices.dto.ItemDTO;
import com.mcgill.mcgillmenuprices.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
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
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

      @Autowired
      private MockMvc mockMvc;

      @MockBean
      private ItemService itemService;

      @Test
      @WithMockUser
      public void getItemsByCategoryAndRestaurantTest() throws Exception {
            // Setup a mock ItemDTO response
            ItemDTO mockItemDTO = new ItemDTO();
            mockItemDTO.setId(1L);
            mockItemDTO.setName("Burger");
            mockItemDTO.setDescription("Delicious beef burger");
            mockItemDTO.setPrice(9.99);
            mockItemDTO.setRating(5);
            mockItemDTO.setRestaurantId(1L);

            List<ItemDTO> mockedItems = Collections.singletonList(mockItemDTO);

            // Mock the service layer to return the mockItemDTO list
            when(itemService.getItemsByCategoryAndRestaurant(1L, 1L)).thenReturn(mockedItems);

            // Perform the GET request and expect a 200 OK response
            mockMvc.perform(get("/items/category/restaurant")
                            .param("categoryId", "1")
                            .param("restaurantId", "1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            // Verify that the service method was called with the right parameters
            verify(itemService).getItemsByCategoryAndRestaurant(1L, 1L);
      }

      // Additional tests for other endpoints
}
