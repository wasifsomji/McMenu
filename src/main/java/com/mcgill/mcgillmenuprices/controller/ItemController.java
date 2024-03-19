package com.mcgill.mcgillmenuprices.controller;

import com.mcgill.mcgillmenuprices.dto.ItemDTO;
import com.mcgill.mcgillmenuprices.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

      private final ItemService itemService;

      @Autowired
      public ItemController(ItemService itemService) {
            this.itemService = itemService;
      }

      @GetMapping("/category/restaurant")
      public ResponseEntity<List<ItemDTO>> getItemsByCategoryAndRestaurant(
              @RequestParam Long categoryId,
              @RequestParam Long restaurantId) {
            List<ItemDTO> items = itemService.getItemsByCategoryAndRestaurant(categoryId, restaurantId);
            return ResponseEntity.ok(items);
      }

      @GetMapping("/restaurant")
      public ResponseEntity<List<ItemDTO>> getItemsByRestaurant(
              @RequestParam Long restaurantID) {
            List<ItemDTO> items = itemService.getItemsByRestaurant(restaurantID);
            return ResponseEntity.ok(items);
      }

      @GetMapping("/price-range")
      public ResponseEntity<List<ItemDTO>> getItemsInPriceRange(
              @RequestParam Double minPrice,
              @RequestParam Double maxPrice) {
            List<ItemDTO> items = itemService.getItemsByPriceRange(minPrice, maxPrice);
            return ResponseEntity.ok(items);
      }

      @GetMapping("/price")
      public ResponseEntity<List<ItemDTO>> getItemsByPrice(
              @RequestParam Double price) {
            List<ItemDTO> items = itemService.getItemsByPrice(price);
            return ResponseEntity.ok(items);
      }

      @GetMapping("/restaurant/category/price-range")
      public ResponseEntity<List<ItemDTO>> getItemsByRestaurantAndCategoryAndPrieRange(
              @RequestParam Long restaurantId,
              @RequestParam Long categoryId,
              @RequestParam Double minPrice,
              @RequestParam Double maxPrice
      ) {
            List<ItemDTO> items = itemService.getItemsByRestaurantAndCategoryAndPriceRange(restaurantId, categoryId, minPrice, maxPrice);
            return ResponseEntity.ok(items);
      }
}
