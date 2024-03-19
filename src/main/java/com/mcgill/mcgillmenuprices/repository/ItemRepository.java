package com.mcgill.mcgillmenuprices.repository;

import com.mcgill.mcgillmenuprices.model.Item;
import com.mcgill.mcgillmenuprices.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
      // You can define custom query methods here if needed

      List<Item> findAllByCategoryIdAndRestaurantId(Long categoryId, Long restaurantId);

      List<Item> findAllByRestaurantId(Long restaurantID);

      List<Item> findAllByPrice(Double price);

      List<Item> findAllByPriceBetween(Double minPrice, Double maxPrice);

      List<Item> findAllByRestaurantIdAndCategoryIdAndPriceBetween(
              Long restaurantId,
              Long categoryId,
              Double minPrice,
              Double maxPrice
      );

}
