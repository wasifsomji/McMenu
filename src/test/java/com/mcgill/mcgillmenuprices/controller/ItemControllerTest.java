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
      private ItemDTO createMockItemDTO(Long id, String name, String description, Double price, int rating, Long restaurantId) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(id);
            itemDTO.setName(name);
            itemDTO.setDescription(description);
            itemDTO.setPrice(price);
            // Assume that 'rating' is part of your ItemDTO and there is a way to set it.
            itemDTO.setRating(rating);
            itemDTO.setRestaurantId(restaurantId);
            return itemDTO;
      }

      @Autowired
      private MockMvc mockMvc;

      @MockBean
      private ItemService itemService;


      @Test
      @WithMockUser
      public void getItemsByCategoryAndRestaurantTest() throws Exception {
            // Set up a mock ItemDTO response
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

      @Test
      @WithMockUser
      public void getItemsByRestaurantTest() throws Exception {
            Long restaurantId = 2L;
            List<ItemDTO> mockedItems = Collections.singletonList(createMockItemDTO(2L, "Pizza", "Cheesy pizza", 12.99, 4, restaurantId));

            when(itemService.getItemsByRestaurant(restaurantId)).thenReturn(mockedItems);

            mockMvc.perform(get("/items/restaurant")
                            .param("restaurantID", restaurantId.toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            verify(itemService).getItemsByRestaurant(restaurantId);
      }
      @Test
      @WithMockUser
      public void getItemsInPriceRangeTest() throws Exception {
            Double minPrice = 5.00;
            Double maxPrice = 10.00;
            List<ItemDTO> mockedItems = Collections.singletonList(createMockItemDTO(3L, "Salad", "Fresh salad", 7.99, 5, 3L));

            when(itemService.getItemsByPriceRange(minPrice, maxPrice)).thenReturn(mockedItems);

            mockMvc.perform(get("/items/price-range")
                            .param("minPrice", minPrice.toString())
                            .param("maxPrice", maxPrice.toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            verify(itemService).getItemsByPriceRange(minPrice, maxPrice);
      }
      @Test
      @WithMockUser
      public void getItemsByPriceTest() throws Exception {
            Double price = 9.99;
            List<ItemDTO> mockedItems = Collections.singletonList(createMockItemDTO(1L, "Burger", "Delicious beef burger", price, 5, 1L));

            when(itemService.getItemsByPrice(price)).thenReturn(mockedItems);

            mockMvc.perform(get("/items/price")
                            .param("price", price.toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            verify(itemService).getItemsByPrice(price);
      }

      // Test for getting items by restaurant, category, and price range
      @Test
      @WithMockUser
      public void getItemsByRestaurantAndCategoryAndPriceRangeTest() throws Exception {
            Long restaurantId = 1L;
            Long categoryId = 1L;
            Double minPrice = 10.00;
            Double maxPrice = 20.00;
            List<ItemDTO> mockedItems = Collections.singletonList(createMockItemDTO(4L, "Steak", "Grilled steak", 19.99, 5, restaurantId));

            when(itemService.getItemsByRestaurantAndCategoryAndPriceRange(restaurantId, categoryId, minPrice, maxPrice)).thenReturn(mockedItems);

            mockMvc.perform(get("/items/restaurant/category/price-range")
                            .param("restaurantId", restaurantId.toString())
                            .param("categoryId", categoryId.toString())
                            .param("minPrice", minPrice.toString())
                            .param("maxPrice", maxPrice.toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            verify(itemService).getItemsByRestaurantAndCategoryAndPriceRange(restaurantId, categoryId, minPrice, maxPrice);
      }
}
